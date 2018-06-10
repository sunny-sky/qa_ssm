package com.xjtu.qa.service;

import java.util.List;

import com.xjtu.qa.pojo.Category;
//import com.xjtu.qa.util.Page;


public interface CategoryService {
//    public List<Category> list(Page page);
//    
//    public int total();
	
	List<Category> list();
    
    void add(Category category);
    
    void delete(int id);
    
    Category get(int id);
    
    void update(Category category);
    
//    void setCategory2(Category category);
}
