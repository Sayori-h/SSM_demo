package com.powernode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * t_user
 */
@Data // 自动生成 getter/setter
@NoArgsConstructor // 无参构造
@AllArgsConstructor // 全参构造
public class TUser implements Serializable {

    /**
     * 用户ID
     */
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
    private Long fId;

    /**
     * 邮箱
     */
    private String fMail;

    /**
     * 用户昵称
     */
    private String fNickname;

    /**
     * 群账号群主userid
     */
    private Long fOwnerId;

    /**
     * 用户密码
     */
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