package com.xjtu.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjtu.qa.pojo.Category;
import com.xjtu.qa.pojo.Category2;
import com.xjtu.qa.service.Category2Service;
import com.xjtu.qa.service.CategoryService;

@Controller
@RequestMapping("")
public class PageController {
	@Autowired
    CategoryService categoryService;
	@Autowired
	Category2Service category2Service;
	
    @RequestMapping("registerPage")
    public String registerPage() {
        return "fore/register";
    }
    
    @RequestMapping("registerSuccessPage")   
    public String registerSuccessPage() {
        return "fore/registerSuccess";
    }
    
    @RequestMapping("loginPage")
    public String loginPage() {
        return "fore/login";
    }

    @RequestMapping("foreaskQuestion")
    public String askQuestion(Model model) {
    	List<Category> cs= categoryService.list();
    	List<Category2> c2s= category2Service.list();
    	model.addAttribute("cs", cs);
    	model.addAttribute("c2s", c2s);
        return "fore/askQuestion";
    }
    
    @RequestMapping("addAnswer")
    public String addAnswer(){
    	return "fore/addAnswer";
    }
    
    @RequestMapping("adminLogin")
    public String loginAdmin(){
    	return "admin/loginAdminPage";
    }
}
