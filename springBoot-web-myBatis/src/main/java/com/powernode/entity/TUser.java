package com.powernode.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * t_user
 */
@Data
public class TUser implements Serializable {
    /**
     * 用户ID
     */
    @NotNull(message = "用户唯一标识不能为空")
    @Positive(message = "用户唯一标识必须大于0")
    private Long fUserId;

    /**
     * 地址
     */
    private String fAddress;

    /**
     * 生日
     */
    private Long fBirthday;

    /**
     * 自定义头像名
     */
    private String fCustomface;

    /**
     * 自定义头像格式
     */
    private String fCustomfacefmt;

    /**
     * 用户头像类型
     */
    private Integer fFacetype;

    /**
     * 性别
     */
    private Integer fGender;

    /**
     * 自增ID
     */
    @NotNull(message = "用户ID不能为空")
    @Positive(message = "用户ID必须大于0")
    private Long fId;

    /**
     * 邮箱
     */
    private String fMail;

    /**
     * 用户昵称
     */
    @NotBlank(message = "昵称不能为空")
    private String fNickname;

    /**
     * 群账号群主userid
     */
    private Long fOwnerId;

    /**
     * 用户密码
     */
    @NotBlank(message = "密码不能为空")
    private String fPassword;

    /**
     * 电话
     */
    private String fPhonenumber;

    /**
     * 注册时间
     */
    private LocalDateTime fRegisterTime;

    /**
     * 备注
     */
    private String fRemark;

    /**
     * 地址
     */
    private String fSignature;

    /**
     * 更新时间
     */
    private LocalDateTime fUpdateTime;

    /**
     * 用户名
     */
    private String fUsername;

    private static final long serialVersionUID = 1L;
}