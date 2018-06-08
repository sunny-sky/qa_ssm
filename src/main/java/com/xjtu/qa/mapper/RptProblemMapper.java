package com.xjtu.qa.mapper;

import com.xjtu.qa.pojo.RptProblem;
import com.xjtu.qa.pojo.RptProblemExample;
import java.util.List;

public interface RptProblemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RptProblem record);

    int insertSelective(RptProblem record);

    List<RptProblem> selectByExample(RptProblemExample example);

    RptProblem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RptProblem record);

    int updateByPrimaryKey(RptProblem record);
}