package com.liudehuang.boot.actuator.controller;

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
public class ActuatorController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
