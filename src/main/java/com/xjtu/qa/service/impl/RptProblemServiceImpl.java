package com.xjtu.qa.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.qa.mapper.RptProblemMapper;
import com.xjtu.qa.pojo.Question;
import com.xjtu.qa.pojo.RptProblem;
import com.xjtu.qa.pojo.RptProblemExample;
import com.xjtu.qa.pojo.User;
import com.xjtu.qa.service.QuestionService;
import com.xjtu.qa.service.RptProblemService;
import com.xjtu.qa.service.UserService;

@Service
public class RptProblemServiceImpl implements RptProblemService {
    @Autowired
    RptProblemMapper rptProblemMapper;
    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;

   

 
    @Override
    public void add(RptProblem rp){
    	rptProblemMapper.insert(rp);
    }
    
    @Override
    public void delete(int id){
    	rptProblemMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public void update(RptProblem rp){
    	rptProblemMapper.updateByPrimaryKeySelective(rp);
    }
    
    @Override
    public RptProblem get(int id){
    	RptProblem result = rptProblemMapper.selectByPrimaryKey(id);
    	return result;
    }
    
    @Override
    public List<RptProblem> list(){
    	RptProblemExample example =new RptProblemExample();
        example.setOrderByClause("id desc");
        return rptProblemMapper.selectByExample(example);
    }
    
    @Override
    public void setUser(List<RptProblem> rps){
        for (RptProblem rp: rps) {
            setUser(rp);
        }
    }
    
    private void setUser(RptProblem rp) {
    	User user = userService.get(rp.getUserid());
    	rp.setUser(user);
    }

    @Override
    public void setQuestion(List<RptProblem> rps){
        for (RptProblem rp: rps) {
            setQuestion(rp);
        }
    }
    
    private void setQuestion(RptProblem rp) {
    	Question question = questionService.get(rp.getQid());
    	rp.setQuestion(question);
    }
    
    @Override
    public List<RptProblem> listByQid(int qid){
    	RptProblemExample example =new RptProblemExample();
    	example.createCriteria().andQidEqualTo(qid);
        example.setOrderByClause("id desc");
        return rptProblemMapper.selectByExample(example);
    }
    
}
