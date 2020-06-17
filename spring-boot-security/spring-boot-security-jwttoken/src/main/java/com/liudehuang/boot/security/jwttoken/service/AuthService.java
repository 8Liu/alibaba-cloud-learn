package com.liudehuang.boot.security.jwttoken.service;

import com.liudehuang.boot.security.jwttoken.model.domain.BaseUser;
import com.liudehuang.boot.security.jwttoken.model.request.UserLoginRequest;
import com.liudehuang.boot.security.jwttoken.model.request.UserRegisterRequest;
import com.liudehuang.boot.security.jwttoken.model.response.ResponseToken;

public interface AuthService {
    /**
     * 用户注册
     * @param param
     * @return
     */
    BaseUser register(UserRegisterRequest param);

    /**
     * 用户登录
     * @param param
     * @return
     */
    ResponseToken login(UserLoginRequest param);

    /**
     * 根据token获取用户名
     * @param token
     * @return
     */
    BaseUser getUserByToken(String token);

    /**
     * 使用旧token刷新新token
     * @param token
     * @return
     */
    ResponseToken refresh(String token);

    /**
     * 登出
     * @param token
     */
    void logout(String token);


}
