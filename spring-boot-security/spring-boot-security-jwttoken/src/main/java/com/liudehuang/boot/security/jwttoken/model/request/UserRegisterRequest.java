package com.liudehuang.boot.security.jwttoken.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterRequest implements Serializable {

    private String userName;

    private String userPassword;

    private String nickName;

}
