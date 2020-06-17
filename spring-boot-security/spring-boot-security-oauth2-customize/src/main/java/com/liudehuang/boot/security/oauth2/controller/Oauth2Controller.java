package com.liudehuang.boot.security.oauth2.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Oauth2Controller {

    @GetMapping("/getToken")
    public Map<String, Object> getToken(@RequestParam("code") String code, @RequestParam("state") String state){

        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("state", state);
        map.put("token", "token123456");
        return map;
    }

    @GetMapping("/index")
    public String index(Authentication authentication){
        return JSONObject.toJSONString(authentication);
    }
}
