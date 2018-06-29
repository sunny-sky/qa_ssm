package com.xjtu.qa.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjtu.qa.mapper.Category2Mapper;
import com.xjtu.qa.pojo.Category2;
import com.xjtu.qa.pojo.Category2Example;
import com.xjtu.qa.pojo.Question;
import com.xjtu.qa.pojo.User;
import com.xjtu.qa.service.QuestionService;


@Controller
@RequestMapping("")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	@Autowired
	Category2Mapper category2Mapper;

    @RequestMapping("fore_question_add")
    public String add(@RequestParam("c2id") int c2id,@RequestParam("content") String content,@RequestParam("c1id") int c1id, HttpSession session) throws IOException {
    	Question q = new Question();
    	q.setContent(content);
    	q.setC1id(c1id);
    	q.setC2id(c2id);
    	User u = (User)session.getAttribute("user");
    	q.setUserid(u.getId());
    	
    	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        Date d= new Date();
        String str = sdf.format(d);
    	q.setCreationtime(str);
        
    	questionService.add(q);
//        System.out.println(q.getId());
        
 
        return "fore/askQuestion";
    }
    
    @RequestMapping("Cascading_menu")
    @ResponseBody
    public String Cascading(@RequestParam("c1id") int c1id,HttpSession session)throws IOException {
    	System.out.println("传到controller的c1id为："+c1id);
    	Category2Example example = new Category2Example();
    	example.createCriteria().andC1idEqualTo(c1id);
        example.setOrderByClause("id desc");
        List<Category2> c2s = category2Mapper.selectByExample(example);
        JSONObject obj = new JSONObject();
        obj.put("c2s",c2s);
        String a = obj.toString();
        //session.setAttribute("c2s", c2s);   
        System.out.println(a);
    	return a;
    }
}
