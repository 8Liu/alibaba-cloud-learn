package com.liudehuang.boot.security.authentication.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-05
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-05
 * @UpdateRemark:
 * @Version: 1.0
 */
@Data
public class SmsCode {

    private String code;

    private LocalDateTime expireTime;

    public SmsCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public SmsCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
