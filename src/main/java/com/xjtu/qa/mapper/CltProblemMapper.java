package com.xjtu.qa.mapper;

import com.xjtu.qa.pojo.CltProblem;
import com.xjtu.qa.pojo.CltProblemExample;
import java.util.List;

public interface CltProblemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CltProblem record);

    int insertSelective(CltProblem record);

    List<CltProblem> selectByExample(CltProblemExample example);

    CltProblem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CltProblem record);

    int updateByPrimaryKey(CltProblem record);
}