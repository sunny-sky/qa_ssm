package com.xjtu.qa.mapper;

import com.xjtu.qa.pojo.Reply;
import com.xjtu.qa.pojo.ReplyExample;
import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);

    int insertSelective(Reply record);

    List<Reply> selectByExampleWithBLOBs(ReplyExample example);

    List<Reply> selectByExample(ReplyExample example);

    Reply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKeyWithBLOBs(Reply record);

    int updateByPrimaryKey(Reply record);
}