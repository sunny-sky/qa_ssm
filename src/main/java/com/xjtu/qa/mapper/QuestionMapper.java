package com.xjtu.qa.mapper;

import com.xjtu.qa.pojo.Question;
import com.xjtu.qa.pojo.QuestionExample;
import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}