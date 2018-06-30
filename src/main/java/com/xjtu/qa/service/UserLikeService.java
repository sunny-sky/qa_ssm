package com.xjtu.qa.service;



import java.util.List;


import com.xjtu.qa.pojo.UserLike;

public interface UserLikeService {
	void add(UserLike userLike);
	void delete(int id);
	UserLike get(int userid,int aid);
	
	int getCount(int aid);
	List<UserLike> listByUserId(int userid);

	
	void fillAnswer(List<UserLike> uls);
}
