package com.xjtu.qa.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import com.xjtu.qa.pojo.Answer;
import com.xjtu.qa.pojo.User;
import com.xjtu.qa.service.AnswerService;

@Controller
@RequestMapping("")
public class AnswerController {
	@Autowired
	AnswerService answerService;
	
	@RequestMapping("fore_answer_add")
    public String addanswer(String qid, Model model,HttpSession session,String content) throws IOException {
		Answer a = new Answer();
		int Qid = Integer.parseInt(qid);
        a.setQid(Qid);
        content = HtmlUtils.htmlEscape(content);
        a.setContent(content);        
        User user =(User)  session.getAttribute("user");
        a.setUserid(user.getId());
        a.setUser(user);
        answerService.add(a);
            
        return "redirect:forequestion?qid="+Qid;
	}
}
