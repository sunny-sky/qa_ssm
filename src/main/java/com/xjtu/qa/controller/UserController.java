package com.xjtu.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjtu.qa.pojo.User;
import com.xjtu.qa.service.UserService;
import com.xjtu.qa.util.Page;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
  
    //用户分页查找
    @RequestMapping("admin_user_list")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
 
        @SuppressWarnings("unchecked")
		List<User> us= userService.list();
 
        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);
 
        model.addAttribute("us", us);
        model.addAttribute("page", page);
 
        return "admin/listUser";
    }
 
}
