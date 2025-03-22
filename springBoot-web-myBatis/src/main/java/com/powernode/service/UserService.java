package com.powernode.service;

import com.github.pagehelper.PageInfo;
import com.powernode.entity.TUser;

import java.util.List;

public interface UserService {

    TUser getUserById(Long userId);

    PageInfo<TUser> getUserByPage(Integer current);

    int upDateUser();
}
