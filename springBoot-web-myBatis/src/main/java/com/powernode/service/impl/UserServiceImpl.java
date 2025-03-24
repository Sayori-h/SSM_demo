package com.powernode.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powernode.constant.Constants;
import com.powernode.entity.TUser;
import com.powernode.mapper.TUserDao;
import com.powernode.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TUserDao TUserDao;

    @Override
    public TUser getUserById(Long fId) {
        return TUserDao.selectByPrimaryKey(fId);
    }

    @Override
    public PageInfo<TUser> getUserByPage(Integer current) {
        try (Page<?> ignored = PageHelper.startPage(current, Constants.PAGE_SIZE)) {
            List<TUser> list = TUserDao.selectByPage(); // 移除current参数
            return new PageInfo<>(list);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int upDateUser() {
        TUser tUser = new TUser();
        tUser.setFId(30001L);
        tUser.setFNickname("麦克阿瑟");
        int a=1/0;
        return TUserDao.updateByPrimaryKeySelective(tUser);
    }

    @Override
    public int addUser(TUser user) {
        return TUserDao.insert(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int modifyUser(TUser user) {
        return TUserDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public int DeleteUserById(Long fId) {
        return TUserDao.deleteByPrimaryKey(fId);
    }
}
