package com.xjtu.qa.service;

import java.util.List;

import com.xjtu.qa.pojo.Category;
import com.xjtu.qa.pojo.Question;
import com.xjtu.qa.pojo.UserLike;


public interface QuestionService {
    void add(Question q);
    void delete(int id);
    void update(Question q);
    Question get(int id);
    @SuppressWarnings("rawtypes")
	List list(int cid);

    void setAnswerNum(Question q);
    void setUserLikeNum(UserLike ul);
    
    public void fill(List<Category> categorys);
    public void fill(Category category);
}
