package com.liudehuang.sentinel.restful.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-03
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-03
 * @UpdateRemark:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/sentinelRestful")
public class SentinelRestfulController {

    @GetMapping("/sentinelRestfulTest")
    public String sentinelRestfulTest(){
        return "sentinelRestfulTest";
    }
}
