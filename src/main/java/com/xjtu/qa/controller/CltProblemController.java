package com.xjtu.qa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjtu.qa.pojo.CltProblem;
import com.xjtu.qa.pojo.Question;
import com.xjtu.qa.pojo.User;
import com.xjtu.qa.service.CltProblemService;
import com.xjtu.qa.service.QuestionService;


@Controller
@RequestMapping("")
public class CltProblemController {
	@Autowired
	QuestionService questionService;
	@Autowired
	CltProblemService cltProblemService;
	
	@RequestMapping("foreaddCltp")
	@ResponseBody
    public String foreaddCltp(@RequestParam("qid") int qid,HttpSession session){
		User user =(User)  session.getAttribute("user");
		Question question = questionService.get(qid);		
		int userid = user.getId();
		CltProblem cltProblem = cltProblemService.get(userid, qid);
		if(cltProblem==null){
			CltProblem cltProblem1 = new CltProblem();
			cltProblem1.setQid(qid);
			cltProblem1.setUserid(userid);
			cltProblemService.add(cltProblem1);
			List<CltProblem> cps = cltProblemService.list(qid);
	    	int cltProblemNum = cps.size();
			question.setCltProblemNum(cltProblemNum);
			session.setAttribute("cltProblemNum1", cltProblemNum);
			System.out.println("cltProblem中处理后收藏数"+cltProblemNum);
			return "success";
		}
		else{
			int id = cltProblem.getId();
			cltProblemService.delete(id);
			List<CltProblem> cps = cltProblemService.list(qid);
	    	int cltProblemNum = cps.size();
			question.setCltProblemNum(cltProblemNum);
			session.setAttribute("cltProblemNum1", cltProblemNum);
			System.out.println("cltProblem中处理后收藏数"+cltProblemNum);
			return "fail";
		}
	
    }
}
