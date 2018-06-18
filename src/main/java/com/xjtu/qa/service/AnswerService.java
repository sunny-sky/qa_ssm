package com.xjtu.qa.service;



import java.util.List;

import com.xjtu.qa.pojo.Answer;

public interface AnswerService {
    void add(Answer a);
    
    void delete(int id);
    void update(Answer a);
    Answer get(int id);
    
	
 
    int getCount(int qid);
    List<Answer> list(int qid);
}
