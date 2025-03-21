package com.powernode.mapper;

import com.powernode.entity.TUser;

public interface TUserDao {
    int deleteByPrimaryKey(Long fUserId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long fUserId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}