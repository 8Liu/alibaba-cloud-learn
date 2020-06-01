package com.liudehuang.alibaba.sentinel.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-05-30
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-05-30
 * @UpdateRemark:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/sentinelNacos")
public class SentinelNacosController {

    @GetMapping("/nacosDatasouceTest")
    public String nacosDatasouceTest(){
        return "nacosDatasourceTest";
    }
}
