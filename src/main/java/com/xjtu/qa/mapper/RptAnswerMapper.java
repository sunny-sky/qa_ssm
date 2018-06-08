package com.xjtu.qa.mapper;

import com.xjtu.qa.pojo.RptAnswer;
import com.xjtu.qa.pojo.RptAnswerExample;
import java.util.List;

public interface RptAnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RptAnswer record);

    int insertSelective(RptAnswer record);

    List<RptAnswer> selectByExample(RptAnswerExample example);

    RptAnswer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RptAnswer record);

    int updateByPrimaryKey(RptAnswer record);
}