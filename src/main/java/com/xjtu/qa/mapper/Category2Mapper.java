package com.xjtu.qa.mapper;

import com.xjtu.qa.pojo.Category2;
import com.xjtu.qa.pojo.Category2Example;
import java.util.List;

public interface Category2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category2 record);

    int insertSelective(Category2 record);

    List<Category2> selectByExample(Category2Example example);

    Category2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category2 record);

    int updateByPrimaryKey(Category2 record);
}