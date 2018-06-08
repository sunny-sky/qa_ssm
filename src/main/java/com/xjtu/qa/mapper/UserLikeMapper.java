package com.xjtu.qa.mapper;

import com.xjtu.qa.pojo.UserLike;
import com.xjtu.qa.pojo.UserLikeExample;
import java.util.List;

public interface UserLikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLike record);

    int insertSelective(UserLike record);

    List<UserLike> selectByExample(UserLikeExample example);

    UserLike selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLike record);

    int updateByPrimaryKey(UserLike record);
}