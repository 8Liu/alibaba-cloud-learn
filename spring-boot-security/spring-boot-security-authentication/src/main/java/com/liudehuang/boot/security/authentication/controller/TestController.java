package com.liudehuang.boot.security.authentication.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-04
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-04
 * @UpdateRemark:
 * @Version: 1.0
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello spring security";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    public String index(Authentication authentication){
        return "欢迎来到index页面:"+ JSONObject.toJSONString(authentication);
    }
}
