package com.xjtu.qa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.qa.mapper.UserLikeMapper;
import com.xjtu.qa.pojo.Answer;
import com.xjtu.qa.pojo.UserLike;
import com.xjtu.qa.pojo.UserLikeExample;
import com.xjtu.qa.service.AnswerService;
import com.xjtu.qa.service.UserLikeService;

@Service
public class UserLikeServiceImpl implements UserLikeService{
	@Autowired
	UserLikeMapper userLikeMapper;	
	@Autowired
	AnswerService answerService;
	
	@Override	
    public void add(UserLike ul) {
		userLikeMapper.insert(ul);
    }
	
	@Override
    public void delete(int id) {
		userLikeMapper.deleteByPrimaryKey(id);
    }
	@Override
	public UserLike get(int userid,int aid){
		UserLikeExample example =new UserLikeExample();
        example.createCriteria().andUseridEqualTo(userid).andAidEqualTo(aid);
        if(userLikeMapper.selectByExample(example).size()==0){
        	return null;
        }
        UserLike userlike = userLikeMapper.selectByExample(example).get(0);
        return userlike;
	}
	
	@Override
	public int getCount(int aid){
		UserLikeExample example = new UserLikeExample();
		example.createCriteria().andAidEqualTo(aid);
		example.setOrderByClause("id desc");

		List<UserLike> result = userLikeMapper.selectByExample(example);
		int userLikeNum = result.size();
		return userLikeNum;
	}
	
	@Override
	public List<UserLike> listByUserId(int userid){
		UserLikeExample example = new UserLikeExample();
		example.createCriteria().andUseridEqualTo(userid);
		example.setOrderByClause("id desc");
		List<UserLike> result = userLikeMapper.selectByExample(example);
		return result;
	}
	
	@Override
	public void fillAnswer(List<UserLike> uls){
		for(UserLike ul:uls){
			Answer answer = answerService.get(ul.getAid());
			ul.setAnswer(answer);
		}
	}
}
