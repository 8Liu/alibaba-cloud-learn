package com.liudehuang.boot.security.jwttoken.model.response;

import com.liudehuang.boot.security.jwttoken.model.domain.BaseUser;
import lombok.Data;

import java.io.Serializable;
@Data
public class ResponseToken implements Serializable {

    private String token;

    private BaseUser user;

    public ResponseToken(String token, BaseUser user) {
        this.token = token;
        this.user = user;
    }
}
