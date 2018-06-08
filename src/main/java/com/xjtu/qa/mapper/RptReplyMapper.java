package com.xjtu.qa.mapper;

import com.xjtu.qa.pojo.RptReply;
import com.xjtu.qa.pojo.RptReplyExample;
import java.util.List;

public interface RptReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RptReply record);

    int insertSelective(RptReply record);

    List<RptReply> selectByExample(RptReplyExample example);

    RptReply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RptReply record);

    int updateByPrimaryKey(RptReply record);
}