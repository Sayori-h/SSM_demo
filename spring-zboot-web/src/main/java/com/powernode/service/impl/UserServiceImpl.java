package com.powernode.service.impl;

import com.powernode.entity.TUser;
import com.powernode.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public TUser getUser() {
        return new TUser(
                null, // fUserId
                "上海", // fAddress
                946656000L, // fBirthday (示例时间戳)
                "avatar.jpg", // fCustomface
                "jpg", // fCustomfacefmt
                1, // fFacetype
                0, // fGender
                1001L, // fId
                "test@powernode.com", // fMail
                "灵码助手", // fNickname
                null, // fOwnerId
                "123456", // fPassword
                "13800138000", // fPhonenumber
                LocalDateTime.now(), // fRegisterTime
                "备注信息", // fRemark
                "个性签名", // fSignature
                LocalDateTime.now(), // fUpdateTime
                "lingma" // fUsername
        );
    }
}
