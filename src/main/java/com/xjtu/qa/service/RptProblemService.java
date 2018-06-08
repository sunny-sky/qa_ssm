package com.xjtu.qa.service;


import java.util.List;


import com.xjtu.qa.pojo.RptProblem;

public interface RptProblemService {
    void add(RptProblem rp);
    
    void delete(int id);
    void update(RptProblem rp);
    RptProblem get(int id);
    List<RptProblem> list();
    void setUser(List<RptProblem> rps);
    


 
}