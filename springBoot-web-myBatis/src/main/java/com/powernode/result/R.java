package com.powernode.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * controller的返回结果统一使用该类进行封装
 *
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class R {

    //返回的状态码，比如200表示成功，500表示失败
    private int code;

    //返回的状态信息，也就是返回的那个状态码代表后端是什么错误，比如：用户不存在，登录密码错误....
    private String msg;

    //返回的具体数据，数据可以是任何类型，比如登录成功，那么返回user对象
    private Object data;

    public static R OK(CodeEnum codeEnum) {
        return R.builder()
                .code(codeEnum.getCode())
                .msg(codeEnum.getMsg())
                .build();
    }

    public static R OK(CodeEnum codeEnum, Object data) {
        return R.builder()
                .code(codeEnum.getCode())
                .msg(codeEnum.getMsg())
                .data(data)
                .build();
    }

    public static R FAIL(CodeEnum codeEnum) {
        return R.builder()
                .code(codeEnum.getCode())
                .msg(codeEnum.getMsg())
                .build();
    }

    public static R FAIL(CodeEnum codeEnum,String msg) {
        return R.builder()
                .code(codeEnum.getCode())
                .msg(msg)
                .build();
    }

    // 在R类中添加
    // 在R类中修改putData方法
    @SuppressWarnings("unchecked")
    public R putData(String key, Object value) {
        if (this.data == null) {
            this.data = new HashMap<String, Object>();
        }
        // 添加类型安全检查
        if (!(this.data instanceof Map)) {
            throw new IllegalStateException("Data must be a Map instance when using putData");
        }
        ((Map<String, Object>) this.data).put(key, value);
        return this;
    }


}