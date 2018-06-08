package com.xjtu.qa.mapper;

import com.xjtu.qa.pojo.Answer;
import com.xjtu.qa.pojo.AnswerExample;
import java.util.List;

public interface AnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Answer record);

    int insertSelective(Answer record);

    List<Answer> selectByExampleWithBLOBs(AnswerExample example);

    List<Answer> selectByExample(AnswerExample example);

    Answer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKeyWithBLOBs(Answer record);

    int updateByPrimaryKey(Answer record);
}