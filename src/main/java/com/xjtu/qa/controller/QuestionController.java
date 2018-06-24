package com.xjtu.qa.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xjtu.qa.pojo.Question;
import com.xjtu.qa.pojo.User;
import com.xjtu.qa.service.QuestionService;


@Controller
@RequestMapping("")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;

    @RequestMapping("fore_question_add")
    public String add(@RequestParam("c2id") int c2id,@RequestParam("content") String content,@RequestParam("c1id") int c1id, HttpSession session) throws IOException {
    	Question q = new Question();
    	q.setContent(content);
    	q.setC1id(c1id);
    	q.setC2id(c2id);
    	User u = (User)session.getAttribute("user");
    	q.setUserid(u.getId());
    	questionService.add(q);
        System.out.println(q.getId());
        
 
        return "fore/askQuestion";
    }
}
