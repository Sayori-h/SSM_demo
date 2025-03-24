package com.powernode.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 枚举类
 *
 */
@AllArgsConstructor
@Getter
public enum CodeEnum {

    OK(200, "成功"), //使用有参构造方法创建一个CodeEnum枚举类的对象

    FAIL(500, "失败"), //使用有参构造方法创建一个CodeEnum枚举类的对象

    INVALID_PARAM(500, "无效参数"),

    USER_PASSWORD_ERROR(401, "登录密码错误"), //使用有参构造方法创建一个CodeEnum枚举类的对象

    USER_ACCOUNT_LOCK(402, "账号已被锁定"); //使用有参构造方法创建一个CodeEnum枚举类的对象

    //CodeEnum枚举类的一个成员变量
    private final int code;

    //CodeEnum枚举类的一个成员变量
    private final String msg;
}
