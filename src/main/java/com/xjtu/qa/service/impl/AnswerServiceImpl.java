package com.xjtu.qa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.qa.mapper.AnswerMapper;
import com.xjtu.qa.pojo.Answer;
import com.xjtu.qa.pojo.AnswerExample;
import com.xjtu.qa.pojo.User;
import com.xjtu.qa.service.AnswerService;
import com.xjtu.qa.service.UserService;

@Service
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	AnswerMapper answerMapper;
    @Autowired
    UserService userService;
    
    @Override
    public void add(Answer a) {
    	answerMapper.insert(a);
    }
    
    @Override
    public void delete(int id) {
    	answerMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public void update(Answer a) {
    	answerMapper.updateByPrimaryKeySelective(a);
    }
    
    @Override
    public Answer get(int id) {
        return answerMapper.selectByPrimaryKey(id);
    }
    

    
    
    public void setUser(List<Answer> answers){
        for (Answer answer : answers) {
            setUser(answer);
        }
    }
    
    private void setUser(Answer answer) {
        int uid = answer.getUserid();
        User user =userService.get(uid);
        answer.setUser(user);
    }
    
    @Override
    public int getCount(int qid) {
        return list(qid).size();
    }
    
    public List<Answer> list(int qid){
    	AnswerExample example =new AnswerExample();
        example.createCriteria().andQidEqualTo(qid);
        example.setOrderByClause("id desc");
  
        List<Answer> result =answerMapper.selectByExample(example);
        setUser(result);
        return result;
    }
    
}
