package com.powernode.service.impl;

import com.powernode.entity.TUser;
import com.powernode.mapper.TUserDao;
import com.powernode.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TUserDao TUserDao;

    @Override
    public TUser getUserById(Long userId) {
        return TUserDao.selectByPrimaryKey(userId);
    }
}
