package com.xjtu.qa.service;



import com.xjtu.qa.pojo.UserLike;

public interface UserLikeService {
	void add(UserLike userLike);
	void delete(int id);
	UserLike get(int userid,int aid);
	
	int getCount(int qid);
}
