package com.xjtu.qa.service;


import java.util.List;


import com.xjtu.qa.pojo.CltProblem;


public interface CltProblemService {

	void add(CltProblem cp);
    void delete(int id);


    CltProblem get(int userid,int qid);
    List<CltProblem> list(int qid);
}
