package com.xjtu.qa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.qa.mapper.CategoryMapper;
import com.xjtu.qa.pojo.Category;
import com.xjtu.qa.pojo.CategoryExample;
import com.xjtu.qa.service.CategoryService;
//import com.xjtu.qa.util.Page;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
 
    @Override
    public List<Category> list() {
        CategoryExample example =new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
    }
 
    @Override
    public void add(Category category) {
        categoryMapper.insert(category);
    }
 
    @Override
    public void delete(int id) {
        categoryMapper.deleteByPrimaryKey(id);
    }
 
    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
 
    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }
}