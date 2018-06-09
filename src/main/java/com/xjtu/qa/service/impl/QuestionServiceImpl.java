package com.xjtu.qa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.qa.mapper.QuestionMapper;
import com.xjtu.qa.pojo.Question;
import com.xjtu.qa.pojo.QuestionExample;
import com.xjtu.qa.service.QuestionService;


@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    QuestionMapper questionMapper;
 
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
 
    public List<Question> list(){
        QuestionExample example =new QuestionExample();
        example.setOrderByClause("id desc");
        return questionMapper.selectByExample(example);
 
    }
}
