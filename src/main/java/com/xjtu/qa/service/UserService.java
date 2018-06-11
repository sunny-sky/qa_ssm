package com.xjtu.qa.service;

import java.util.List;

import com.xjtu.qa.pojo.User;

public interface UserService {
    void add(User c);
    void delete(int id);
    void update(User c);
    User get(int id);
    @SuppressWarnings("rawtypes")
	List list();
    
    boolean isExist(String name);
    
    User get(String name, String password);
}