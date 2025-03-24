package com.powernode.service;

import com.github.pagehelper.PageInfo;
import com.powernode.entity.TUser;

public interface UserService {

    TUser getUserById(Long userId);

    PageInfo<TUser> getUserByPage(Integer current);

    int upDateUser();

    int addUser(TUser user);

    int modifyUser(TUser user);

    int DeleteUserById(Long fId);
}
