package com.powernode.service;

import com.github.pagehelper.PageInfo;
import com.powernode.entity.TUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.concurrent.CompletableFuture;

public interface UserService {

    CompletableFuture<TUser> getUserById(Long userId);

    PageInfo<TUser> getUserByPage(Integer current);

    int upDateUser();

    int addUser(TUser user);

    int modifyUser(TUser user);

    int DeleteUserById(Long fId);

    TUser getUserByUsername(@NotBlank(message = "用户名不能为空")
                            @Size(min = 4, max = 20, message = "用户名长度需4-20字符") String username);
}
