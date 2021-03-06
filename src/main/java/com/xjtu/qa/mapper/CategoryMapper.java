package com.xjtu.qa.mapper;

import com.xjtu.qa.pojo.Category;
import com.xjtu.qa.pojo.Category2;
import com.xjtu.qa.pojo.CategoryExample;
import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
    
    List<Category2> selectWithCategory2(Category record);
}