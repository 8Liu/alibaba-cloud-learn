package com.liudehuang.boot.security.session.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-05
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-05
 * @UpdateRemark:
 * @Version: 1.0
 */
@RestController
public class TestController {
    @GetMapping("/login")
    public String login(Authentication authentication){
        return "login:"+ JSONObject.toJSONString(authentication);
    }
    //SecurityContextHolder.getContext().getAuthentication()
    @GetMapping("/hello")
    public String hello(Authentication authentication){
        return "hello:"+JSONObject.toJSONString(authentication);
    }

    @GetMapping("session/invalid")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String sessionInvalid(){
        return "session已失效，请重新认证";
    }
}
