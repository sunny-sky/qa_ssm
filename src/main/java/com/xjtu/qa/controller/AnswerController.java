package com.xjtu.qa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.xjtu.qa.pojo.Answer;
import com.xjtu.qa.pojo.Reply;

import com.xjtu.qa.pojo.User;
import com.xjtu.qa.service.AnswerService;


@Controller
@RequestMapping("")
public class AnswerController {
	@Autowired
	AnswerService answerService;
	
	@RequestMapping("fore_answer_add")
    public String addanswer(String qid, Model model,HttpSession session,String content) throws IOException {
		Answer a = new Answer();
		int Qid = Integer.parseInt(qid);
        a.setQid(Qid);
        content = HtmlUtils.htmlEscape(content);
        a.setContent(content);        
        User user =(User)  session.getAttribute("user");
        a.setUserid(user.getId());
        a.setUser(user);
        answerService.add(a);
            
        return "redirect:forequestion?qid="+Qid;
	}
	
	@RequestMapping("forereplyAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("aid") String aid, HttpSession session) {
		Answer answer = answerService.get(Integer.parseInt(aid));
        List<Reply> replys = answerService.fillReply(Integer.parseInt(aid));
 
        
        session.setAttribute("answer", answer);
        System.out.print(answer.getContent());
        session.setAttribute("replys", replys);
        return "success";
    }
}
