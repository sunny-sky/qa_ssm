package com.xjtu.qa.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.xjtu.qa.pojo.Question;
import com.xjtu.qa.service.QuestionService;


@Controller
@RequestMapping("")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;

    @RequestMapping("fore_question_add")
    public String add(Question q, HttpSession session) throws IOException {
    	System.out.println(q.getId());
    	questionService.add(q);
        System.out.println(q.getId());
        
 
        return "redirect:/askQuestion";
    }
}
