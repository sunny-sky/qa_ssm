package com.xjtu.qa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import com.xjtu.qa.pojo.User;
import com.xjtu.qa.service.UserService;

@Controller
@RequestMapping("")
public class AdminController {
	@Autowired
	UserService userService;
	
	
	@RequestMapping("adminLoginCheck")
	public String adminlogin(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpSession session) {
		name = HtmlUtils.htmlEscape(name);
		User user = userService.get(name,password);
		if(null==user){
            model.addAttribute("msg", "账号密码错误");
            return "admin/loginAdminPage";
        }
		if(user.getAuthority()==null){
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

}