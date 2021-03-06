package com.xjtu.qa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.github.pagehelper.PageHelper;
import com.xjtu.qa.pojo.Answer;
import com.xjtu.qa.pojo.Category;
import com.xjtu.qa.pojo.CltProblem;
import com.xjtu.qa.pojo.Question;
import com.xjtu.qa.pojo.Reply;
import com.xjtu.qa.pojo.User;
import com.xjtu.qa.pojo.UserLike;
import com.xjtu.qa.service.AnswerService;
import com.xjtu.qa.service.Category2Service;
import com.xjtu.qa.service.CategoryService;
import com.xjtu.qa.service.CltProblemService;
import com.xjtu.qa.service.QuestionService;
import com.xjtu.qa.service.ReplyService;
import com.xjtu.qa.service.UserLikeService;
import com.xjtu.qa.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
 
@Controller
@RequestMapping("")
public class ForeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;
    @Autowired
    Category2Service category2Service;
    @Autowired
    AnswerService answerService;
    @Autowired
    ReplyService replyService;
    @Autowired
    CltProblemService cltProblemService;
    @Autowired
    UserLikeService userLikeService;

 
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();        
        category2Service.fill(cs);
        category2Service.fillByRow(cs);
        questionService.fill(cs);
        for(Category c:cs){
            questionService.setAnswerAndCltProblemNum(c.getQuestions()); 	
        }
        
        model.addAttribute("cs", cs);
        return "fore/home";
    }
 
    @RequestMapping("foreregister")
    public String register(Model model,User user) {
        
    	String name =  user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        boolean exist = userService.isExist(name);
         
        if(exist){
            String m ="用户名已经被使用,不能使用";
            model.addAttribute("msg", m);
            model.addAttribute("user", null);
            return "fore/register";
        }
        
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        Date d= new Date();
        String str = sdf.format(d);
        user.setCreationtime(str);
        
        userService.add(user);
    
        return "redirect:registerSuccessPage";
    }
    
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }
        if("-1"==user.getAuthority()){
            model.addAttribute("msg", "账号被限制登陆");
            return "fore/login";
        }
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
    
    @RequestMapping("forequestion")
    public String question(@RequestParam("qid") int qid, Model model,HttpSession session){
    	Question q = questionService.get(qid);    	
    	List<Answer> answers = questionService.listAnswers(qid);
    	int answerNum = answers.size();
    	List<CltProblem> cps = cltProblemService.list(qid);
    	int cltProblemNum = cps.size();
    	
    	for(Answer a:answers){
    		a.setLikenumber(userLikeService.getCount(a.getId()));
    		answerService.update(a);
    	}
    	
    	System.out.println("q.getCltProblemNum()="+cltProblemNum);
    	String cltButton = null;
    	if(session.getAttribute("user")==null){
    		cltButton = "登陆后收藏";
			for(Answer a:answers){
				a.setUserLikeStatus("未登录");
			}
    	}
    	else{
    		User user = (User)session.getAttribute("user");    		
    		CltProblem cp = cltProblemService.get(user.getId(), qid);
    		if(cp==null){
    			cltButton = "收藏问题";

    		}
    		else{
    			cltButton = "已收藏";    			
    		}
    		for(Answer a:answers){
    			UserLike ul = userLikeService.get(user.getId(), a.getId());
    			if(ul==null){
    				a.setUserLikeStatus("点赞");
    			}
    			else{
    				a.setUserLikeStatus("已赞");
    			}
    		}
    		

    	}
    	model.addAttribute("answerNum", answerNum);
    	model.addAttribute("cltProblemNum", cltProblemNum);
    	model.addAttribute("q", q);
    	model.addAttribute("answers", answers);
    	model.addAttribute("cltButton", cltButton);

    	return "fore/question";
    	
    }
    
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin( HttpSession session) {
        User user =(User)  session.getAttribute("user");
        if(null!=user)
            return "success";
        return "fail";
    }
 
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password,HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);
 
        if(null==user||user.getAuthority()=="-1"){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
    
    @RequestMapping("foresearch")
    public String search( String keyword,Model model){
 
        PageHelper.offsetPage(0,20);
        List<Question> qs= questionService.search(keyword);
        questionService.setAnswerAndCltProblemNum(qs);
        for(Question q:qs){
        	int num = cltProblemService.getCountByQid(q.getId());
        	q.setCltProblemNum(num);
        }
        model.addAttribute("qs",qs);
        return "fore/searchResult";
    }

    @RequestMapping("foreanswer")
    public String review( Model model,int qid) {
        Question q = questionService.get(qid);
        List<Answer> answers = questionService.listAnswers(qid);
        questionService.setAnswerAndCltProblemNum(q);

        model.addAttribute("q", q);
        model.addAttribute("answers", answers);

        return "fore/answer";
    }
    
    @RequestMapping("foredoanswer")
    public String doreanswer( Model model,HttpSession session,@RequestParam("qid") int qid,String content) {
        Answer a = new Answer();
        a.setQid(qid);
        content = HtmlUtils.htmlEscape(content);
        a.setContent(content);        
        User user =(User)  session.getAttribute("user");
        a.setUserid(user.getId());
        a.setUser(user);
        answerService.add(a);
        

     
        return "redirect:foreanswer?qid="+qid+"&showonly=true";
    }
    
    @RequestMapping("forereply")
    public String reply(Model model,HttpSession session,@RequestParam("aid") int aid){
    	Answer answer = answerService.get(aid);
    	List<Reply> replys = answerService.fillReply(aid);

    	int replyNum = replys.size();
      
    	session.setAttribute("replyNum", replyNum);
    	session.setAttribute("answer", answer);
//    	System.out.print(answer.getContent());
    	session.setAttribute("replys", replys);
    	
    	return "fore/reply";
    }
    
    @RequestMapping("fore_reply_add")
    public String addreply(@RequestParam("aid") int aid,@RequestParam("userid") int userid,String content,HttpSession session){
    	Reply reply = new Reply();
    	reply.setAid(aid);
    	reply.setUserid(userid);
    	reply.setContent(content);
    	
    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        Date d= new Date();
        String str = sdf.format(d);
        reply.setCreationtime(str);
    	
    	replyService.add(reply);
    	String url = "fore/reply";
    	System.out.print(url);
    	return url;
    }
    
    @RequestMapping("forePersonalCenter")
    public String addreply(HttpSession session){
    	User user = (User)session.getAttribute("user");
    	int userid = user.getId();
    	session.setAttribute("user", user);
    	
    	List<Question> qs = questionService.listByUserId(userid);
    	session.setAttribute("qs", qs);
    	
    	List<Answer> as = answerService.listByUserId(userid);
    	session.setAttribute("as", as);
    	
    	List<CltProblem> cps = cltProblemService.listByUserId(userid);
    	cltProblemService.fillQuestion(cps);
    	session.setAttribute("cps", cps);
    	
    	List<UserLike> uls = userLikeService.listByUserId(userid);
    	userLikeService.fillAnswer(uls);
    	session.setAttribute("uls", uls);
    	 	
    	return "fore/personalCenter";
    }
}



