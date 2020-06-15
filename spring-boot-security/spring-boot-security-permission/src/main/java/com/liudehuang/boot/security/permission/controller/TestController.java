package com.liudehuang.boot.security.permission.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-06
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-06
 * @UpdateRemark:
 * @Version: 1.0
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/index")
    public String index(Authentication authentication){
        return JSONObject.toJSONString(authentication);
    }

    @GetMapping("/auth/admin")
    @PreAuthorize("hasAuthority('admin')")
    public String authenticationTest() {
        return "您拥有admin权限，可以查看";
    }

    @GetMapping("session/invalid")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String sessionInvalid(){
        return "session已失效，请重新认证";
    }
}
