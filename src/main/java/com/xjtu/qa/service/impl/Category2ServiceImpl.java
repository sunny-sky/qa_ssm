package com.xjtu.qa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjtu.qa.mapper.Category2Mapper;
import com.xjtu.qa.pojo.Category;
import com.xjtu.qa.pojo.Category2;
import com.xjtu.qa.pojo.Category2Example;
import com.xjtu.qa.service.Category2Service;
import com.xjtu.qa.service.CategoryService;

@Service
public class Category2ServiceImpl implements Category2Service{
	
    @Autowired
    Category2Mapper category2Mapper;
    @Autowired
    CategoryService categoryService;
	
    @Override
	public List<Category2> list(){
        Category2Example example =new Category2Example();
        example.setOrderByClause("id desc");
        return category2Mapper.selectByExample(example);		
	}
    
    @Override
    public void add(Category2 category2){
    	category2Mapper.insert(category2);
    }
    
    @Override
    public void delete(int id){
        category2Mapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public Category2 get(int id){
    	return category2Mapper.selectByPrimaryKey(id);
    }
    
    @Override
    public void update(Category2 category2){
    	category2Mapper.updateByPrimaryKeySelective(category2);
    }
    
    @Override
    public void setCategory(List<Category2> c2s){
        for (Category2 c2: c2s) {
            setCategory(c2);
        }
    }
    
    private void setCategory(Category2 c2) {
    	Category category = categoryService.get(c2.getC1id());
    	c2.setCategory(category);
    }
    
    @Override
    public void fill(List<Category> cs) {
        for (Category c : cs) {
            fill(c);
        }
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List list(int c1id) {
    	Category2Example example = new Category2Example();
        example.createCriteria().andC1idEqualTo(c1id);
        example.setOrderByClause("id desc");
        List result = category2Mapper.selectByExample(example);
        setCategory(result);
        return result;
    }
    
    @Override
    public void fill(Category c) {
        @SuppressWarnings("unchecked")
		List<Category2> ps = list(c.getId());
        c.setCategory2s(ps);
    }
    
    @Override
    public void fillByRow(List<Category> cs) {
        int categoryNumberEachRow = 8;
        for (Category c : cs) {
            List<Category2> category2s =  c.getCategory2s();
            List<List<Category2>> category2sByRow =  new ArrayList<>();
            for (int i = 0; i < category2s.size(); i+=categoryNumberEachRow) {
                int size = i+categoryNumberEachRow;
                size= size>category2s.size()?category2s.size():size;
                List<Category2> category2sOfEachRow =category2s.subList(i, size);
                category2sByRow.add(category2sOfEachRow);
            }
            c.setCategory2sByRow(category2sByRow);
        }
    }
    
}
