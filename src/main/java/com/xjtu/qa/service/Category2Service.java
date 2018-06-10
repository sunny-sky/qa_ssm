package com.xjtu.qa.service;

import java.util.List;

import com.xjtu.qa.pojo.Category;
import com.xjtu.qa.pojo.Category2;


public interface Category2Service {
	List<Category2> list();
    
    void add(Category2 category2);
    
    void delete(int id);
    
    Category2 get(int id);
    
    void update(Category2 category2);
    
    void setCategory(List<Category2> c2s);
    
    public void fill(List<Category> categorys);
    public void fill(Category category);
    public void fillByRow(List<Category> categorys);
}
