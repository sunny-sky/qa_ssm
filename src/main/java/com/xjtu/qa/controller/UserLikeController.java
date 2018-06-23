package com.xjtu.qa.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjtu.qa.pojo.Answer;
import com.xjtu.qa.pojo.User;
import com.xjtu.qa.pojo.UserLike;
import com.xjtu.qa.service.AnswerService;
import com.xjtu.qa.service.UserLikeService;

@Controller
@RequestMapping("")
public class UserLikeController {
	@Autowired
	UserLikeService userLikeService;
	@Autowired
	AnswerService answerService;

	@RequestMapping("userlike_taggle")
	@ResponseBody
    public String userlike(@RequestParam("aid") int aid, HttpSession session) throws IOException {
		User user =(User)  session.getAttribute("user");
		session.setAttribute("aid", aid);
		System.out.println(aid);
		Answer answer = answerService.get(aid);
		if(answer.getLikenumber()==null){
			answer.setLikenumber(0);
		}
		int userLikeNum = answer.getLikenumber();
		int userid = user.getId();
		UserLike userLike = userLikeService.get(userid,aid);		
		if(userLike==null){
			UserLike userLike1 = new UserLike();
			userLike1.setAid(aid);
			userLike1.setUserid(userid);
			userLikeService.add(userLike1);
			userLikeNum = userLikeNum + 1;
			answer.setLikenumber(userLikeNum);
			return "success";
		}
		else{
			int id = userLike.getId();
			userLikeService.delete(id);
			userLikeNum = userLikeNum - 1;
			answer.setLikenumber(userLikeNum);
			return "fail";
		}		
	}
	
	@RequestMapping("userlike_get")
	@ResponseBody
	public String userlikeget(@RequestParam("aid") int aid, HttpSession session) throws IOException {
		User user =(User)  session.getAttribute("user");
		session.setAttribute("aid", aid);
		System.out.println("userlike_get中aid:"+aid);
		int userid = user.getId();
		UserLike userLike = userLikeService.get(userid,aid);		
		if(userLike==null){			
			return "NO";
		}
		else{
			return "YES";
		}		
	}
}
