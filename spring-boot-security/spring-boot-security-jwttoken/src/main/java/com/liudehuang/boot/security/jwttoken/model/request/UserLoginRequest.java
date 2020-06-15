package com.liudehuang.boot.security.jwttoken.model.request;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String userName;

    private String password;
}
