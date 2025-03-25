package com.powernode.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface HelloService {

    String hello();

    boolean validateLogin(
            @NotBlank(message = "用户名不能为空")
            @Size(min = 4, max = 20, message = "用户名长度需4-20字符") String username,
            @NotBlank(message = "密码不能为空") @Size(min = 6, max = 18, message = "密码长度需6-18字符")
            String password);
}
