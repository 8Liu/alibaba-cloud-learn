package com.liudehuang.boot.security.jwttoken.controller;

import com.liudehuang.boot.security.jwttoken.model.request.UserLoginRequest;
import com.liudehuang.boot.security.jwttoken.model.response.ResponseToken;
import com.liudehuang.boot.security.jwttoken.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody UserLoginRequest userLoginRequest){
        ResponseToken responseToken =  authService.login(userLoginRequest);
        Map<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("message","success");
        map.put("data",responseToken);
        return map;
    }
}
