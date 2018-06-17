package com.xjtu.qa.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.qa.mapper.QuestionMapper;
import com.xjtu.qa.mapper.AnswerMapper;
import com.xjtu.qa.pojo.Answer;
import com.xjtu.qa.pojo.AnswerExample;
import com.xjtu.qa.pojo.Category;
import com.xjtu.qa.pojo.Question;
import com.xjtu.qa.pojo.QuestionExample;
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
    @Autowired
    AnswerMapper answerMapper;
    
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
    public List list(int c1id) {
    	QuestionExample example = new QuestionExample();
        example.createCriteria().andC1idEqualTo(c1id);
        example.setOrderByClause("id desc");
        List result = questionMapper.selectByExample(example);
        setCategory(result);

        return result;
    }
    
    @Override
    public void setAnswerAndCltProblemNum(Question q) {
    	int answerNum = answerService.getCount(q.getId());
        q.setAnswerNum(answerNum);
        
    }
    
    @Override
    public void setAnswerAndCltProblemNum(List<Question> qs) {
    	for (Question q : qs) {
    		setAnswerAndCltProblemNum(q);
        }
    }
    
    @Override
    public List<Question> search(String keyword){
    	QuestionExample example = new QuestionExample();
        example.createCriteria().andContentLike("%" + keyword + "%");
        example.setOrderByClause("id desc");
        List<Question> result = questionMapper.selectByExample(example);
        setCategory(result);
        return result;
    }
    
    

    
    @Override
    public void fill(List<Category> cs) {
        for (Category c : cs) {
            fill(c);
        }
    }
    
    @Override
    public void fill(Category c) {
        @SuppressWarnings("unchecked")
		List<Question> qs = list(c.getId());
        c.setQuestions(qs);
    }
    
    @Override
    public List<Answer> listAnswers(int qid){
    	AnswerExample example =new AnswerExample();
        example.createCriteria().andQidEqualTo(qid);
        example.setOrderByClause("id desc");
        
        Question q = new Question();
        q = get(qid);
  
        List<Answer> answers =answerMapper.selectByExample(example);
        for(Answer a:answers){
    		System.out.println("QuestionServiceImpl中"+a.getContent());
    	}
        q.setAnswers(answers);
        return answers;
    }


}
