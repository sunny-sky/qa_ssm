package com.xjtu.qa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xjtu.qa.mapper.UserLikeMapper;
import com.xjtu.qa.pojo.UserLike;
import com.xjtu.qa.service.UserLikeService;

public class UserLikeServiceImpl implements UserLikeService{
	@Autowired
	UserLikeMapper userLikeMapper;
	
	@Override
    public void add(UserLike ul) {
		userLikeMapper.insert(ul);
    }
	
	@Override
    public void delete(int id) {
		userLikeMapper.deleteByPrimaryKey(id);
    }
}
