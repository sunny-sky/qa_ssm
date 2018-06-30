package com.xjtu.qa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import com.xjtu.qa.pojo.Answer;
import com.xjtu.qa.pojo.CltProblem;
import com.xjtu.qa.pojo.Reply;
import com.xjtu.qa.pojo.RptProblem;
import com.xjtu.qa.pojo.User;
import com.xjtu.qa.service.AnswerService;
import com.xjtu.qa.service.CltProblemService;
import com.xjtu.qa.service.QuestionService;
import com.xjtu.qa.service.ReplyService;
import com.xjtu.qa.service.RptProblemService;
import com.xjtu.qa.service.UserService;

@Controller
@RequestMapping("")
public class AdminController {
	@Autowired
	UserService userService;
	@Autowired
	AnswerService answerService;
	@Autowired
	ReplyService replyService;
	@Autowired
	QuestionService questionService;
	@Autowired
	RptProblemService rptProblemService;
	@Autowired
	CltProblemService cltProblemService;
	
	
	@RequestMapping("adminLoginCheck")
	public String adminlogin(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
		name = HtmlUtils.htmlEscape(name);
		User user = userService.get(name,password);
		if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "admin/loginAdminPage";
        }
		if(!user.getAuthority().equals("1")){
			model.addAttribute("msg", "无登陆权限");
			return "admin/loginAdminPage";
		}
		
		session.setAttribute("user", user);
        return "redirect:admin_category_list";
    }
	
	@RequestMapping("adminlogout")
    public String adminlogout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:adminLogin";
    }
	
	@RequestMapping("admin_user_blacklist")
	public String adminUserBlacklist(@RequestParam("id") int id, HttpSession session) {
        User user = userService.get(id);
        user.setAuthority("-1");
        userService.update(user);
        return "redirect:admin_user_list";
    }
	
	
	@RequestMapping("admin_user_rmblacklist")
	public String adminUserRmblacklist(@RequestParam("id") int id, HttpSession session) {
        User user = userService.get(id);
        user.setAuthority("");
        System.out.println( user.getAuthority());
        userService.update(user);
        return "redirect:admin_user_list";
    }
	
	@RequestMapping("admin_question_delete")
	public String adminQuestionDelete(@RequestParam("qid") int qid, HttpSession session) {
        List<Answer> as = answerService.list(qid);
        for(Answer a:as){
        	List<Reply> rs = replyService.listReply(a.getId());
        	for(Reply r:rs){
        		replyService.delete(r.getId());
        	}
        	answerService.delete(a.getId());
        }
        
        List<RptProblem> rps = rptProblemService.listByQid(qid);
        for(RptProblem rp:rps){
        	rptProblemService.delete(rp.getId());
        }
        
        List<CltProblem> cps = cltProblemService.list(qid);
        for(CltProblem cp:cps){
        	cltProblemService.delete(cp.getId());
        }
        
        questionService.delete(qid);
        		
        return "redirect:admin_rptproblem_list";
    }
}
