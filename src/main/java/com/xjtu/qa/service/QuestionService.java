package com.xjtu.qa.service;

import java.util.List;

import com.xjtu.qa.pojo.Category;
import com.xjtu.qa.pojo.Question;



public interface QuestionService {
    void add(Question q);
    void delete(int id);
    void update(Question q);
    Question get(int id);
    @SuppressWarnings("rawtypes")
	List list(int cid);

    void setAnswerAndCltProblemNum(Question q);
    void setAnswerAndCltProblemNum(List<Question> qs);

    List<Question> search(String keyword);
    
    public void fill(List<Category> categorys);
    public void fill(Category category);
}
