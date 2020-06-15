package com.liudehuang.boot.security.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/oauth2")
public class Oauth2Controller {

    @GetMapping("/getToken")
    public Map<String, Object> getToken(@RequestParam("code") String code, @RequestParam("state") String state){

        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("state", state);
        map.put("token", "token123456");
        return map;
    }
}
