package com.xjtu.qa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.qa.mapper.CltProblemMapper;
import com.xjtu.qa.pojo.CltProblem;
import com.xjtu.qa.pojo.CltProblemExample;
import com.xjtu.qa.pojo.Question;
import com.xjtu.qa.service.CltProblemService;
import com.xjtu.qa.service.QuestionService;

@Service
public class CltProblemServiceImpl implements CltProblemService {
	@Autowired
	CltProblemMapper cltProblemMapper;
	@Autowired
	QuestionService questionService;
	
	@Override
    public void add(CltProblem cp) {
		cltProblemMapper.insert(cp);
    }
	
	@Override
    public void delete(int id) {
		cltProblemMapper.deleteByPrimaryKey(id);
    }
	@Override
	public CltProblem get(int userid,int qid){
		CltProblemExample example =new CltProblemExample();
        example.createCriteria().andUseridEqualTo(userid).andQidEqualTo(qid);
        if(cltProblemMapper.selectByExample(example).size()==0){
        	return null;
        }
        CltProblem cltProblem = cltProblemMapper.selectByExample(example).get(0);
        return cltProblem;
	}
	
	@Override
	public List<CltProblem> list(int qid){
		CltProblemExample example =new CltProblemExample();
		example.createCriteria().andQidEqualTo(qid);
		example.setOrderByClause("id desc");
		List<CltProblem> cps =cltProblemMapper.selectByExample(example);
		return cps;
	}
	
	@Override
	public List<CltProblem> listByUserId(int userid){
		CltProblemExample example =new CltProblemExample();
		example.createCriteria().andUseridEqualTo(userid);
		example.setOrderByClause("id desc");
		List<CltProblem> cps =cltProblemMapper.selectByExample(example);
		return cps;
	}
	
	@Override
	public void fillQuestion(List<CltProblem> cps){
		for(CltProblem cp:cps){
			Question question = questionService.get(cp.getQid());
			cp.setQuestion(question);
		}
	}
}
