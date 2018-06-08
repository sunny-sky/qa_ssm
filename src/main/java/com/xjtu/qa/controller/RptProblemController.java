package com.xjtu.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.xjtu.qa.pojo.RptProblem;
import com.xjtu.qa.service.RptProblemService;

import com.xjtu.qa.util.Page;

@Controller
@RequestMapping("")
public class RptProblemController {
	@Autowired
	RptProblemService rptProblemService;
	
	 @RequestMapping("admin_rptproblem_list")
	    public String list(Model model,Page page){
	        PageHelper.offsetPage(page.getStart(),page.getCount());
	        List<RptProblem> rps = rptProblemService.list();
	        rptProblemService.setUser(rps);
	        int total = (int) new PageInfo<>(rps).getTotal();
	        page.setTotal(total);
	        model.addAttribute("rps", rps);
	        model.addAttribute("page", page);
	        return "admin/listRptProblem";
	    }
}
