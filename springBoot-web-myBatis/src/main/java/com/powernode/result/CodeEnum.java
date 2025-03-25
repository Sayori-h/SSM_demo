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
    OK(200, "成功"),
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未授权"),
    USER_PASSWORD_ERROR(402, "登录密码错误"),
    USER_ACCOUNT_LOCK(403, "账号已被锁定"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    FAIL(500, "系统错误"),
    INVALID_PARAM(500,"非法参数");

    private final int code;
    private final String msg;
}

