package com.xjtu.qa.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.qa.mapper.QuestionMapper;
import com.xjtu.qa.pojo.Category;
import com.xjtu.qa.pojo.Question;
import com.xjtu.qa.pojo.QuestionExample;
import com.xjtu.qa.pojo.UserLike;
import com.xjtu.qa.service.AnswerService;
import com.xjtu.qa.service.CategoryService;
import com.xjtu.qa.service.QuestionService;
import com.xjtu.qa.service.UserLikeService;


@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserLikeService userLikeService;
    @Autowired
    AnswerService answerService;
    
    @Override
    public void add(Question q) {
    	questionMapper.insert(q);
    }
 
    @Override
    public void delete(int id) {
    	questionMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public void update(Question q) {
    	questionMapper.updateByPrimaryKeySelective(q);
    }
 
    @Override
    public Question get(int id) {
        return questionMapper.selectByPrimaryKey(id);
    }
 
    public void setCategory(List<Question> qs){
        for (Question q : qs)
            setCategory(q);
    }
    public void setCategory(Question q){
        int cid = q.getC1id();
        Category c = categoryService.get(cid);
        q.setCategory(c);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public List list(int cid) {
    	QuestionExample example = new QuestionExample();
        example.createCriteria().andC1idEqualTo(cid);
        example.setOrderByClause("id desc");
        List result = questionMapper.selectByExample(example);
        setCategory(result);

        return result;
    }
    
    @Override
    public void setAnswerNum(Question q) {
    	int answerNum = answerService.getCount(q.getId());
    	answerNum = answerNum + 1;
    	q.setAnswerNum(answerNum);   
    }
    
    @Override
	public void setUserLikeNum(UserLike ul){
    	int userLikeNum = answerService.getCount(ul.getAid());
    	userLikeNum = userLikeNum + 1;
    	get(ul.getAid()).setUserLikeNum(userLikeNum);
    }
    

}
