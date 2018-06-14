package com.xjtu.qa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.xjtu.qa.pojo.Answer;
import com.xjtu.qa.pojo.Category;
import com.xjtu.qa.pojo.Question;
import com.xjtu.qa.pojo.User;
import com.xjtu.qa.service.AnswerService;
import com.xjtu.qa.service.Category2Service;
import com.xjtu.qa.service.CategoryService;
import com.xjtu.qa.service.QuestionService;
import com.xjtu.qa.service.UserService;

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


 
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();        
        category2Service.fill(cs);
        category2Service.fillByRow(cs);
        questionService.fill(cs);
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
        session.setAttribute("user", user);
        return "redirect:forehome";
    }
    
    @RequestMapping("forelogout")
    public String logout( HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
    
    @RequestMapping("forequestion")
    public String question(int qid, Model model){
    	Question q = questionService.get(qid);
    	
    	List<Answer> answers = answerService.list(q.getId());
    	int answerNum = q.getAnswerNum();
    	int userLikeNum = q.getUserLikeNum();
    	model.addAttribute("answerNum", answerNum);
    	model.addAttribute("userLikeNum", userLikeNum);
    	model.addAttribute("q", q);
    	model.addAttribute("answers", answers);
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
 
        if(null==user){
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
 
}



