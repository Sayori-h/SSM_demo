package com.powernode.service.impl;

import com.powernode.entity.TUser;
import com.powernode.mapper.TUserDao;
import com.powernode.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private TUserDao tUserDao;

    @Override
    public String hello() {
        //调用底层的Mapper查询数据库(下午去开发，先省略一下)
        return "Hello, Spring MVC.";
    }

    @Override
    public boolean validateLogin(String username, String password) {
        // 查询用户
        TUser user = tUserDao.selectByUsername(username);
        if (user == null) {
            return false; // 用户不存在
        }
        // 获取数据库存储的密码（假设字段为 fPassword）
        String storedPassword = user.getFPassword();
        if (storedPassword == null || storedPassword.isEmpty()) {
            return false; // 数据库密码异常
        }
        // 验证密码（BCrypt 加密场景）
        return Objects.equals(password, storedPassword);
    }

}