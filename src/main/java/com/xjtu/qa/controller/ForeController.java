package com.xjtu.qa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjtu.qa.pojo.Category;
import com.xjtu.qa.service.Category2Service;
import com.xjtu.qa.service.CategoryService;
import com.xjtu.qa.service.QuestionService;
import com.xjtu.qa.service.UserService;

import java.util.List;
 
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


 
    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs= categoryService.list();        
        category2Service.fill(cs);
        category2Service.fillByRow(cs);
        model.addAttribute("cs", cs);
        return "fore/home";
    }
 
}
