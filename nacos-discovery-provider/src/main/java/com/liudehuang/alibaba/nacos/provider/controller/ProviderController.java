package com.liudehuang.alibaba.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-05-27
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-05-27
 * @UpdateRemark:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/nacosProvider")
@RefreshScope
public class ProviderController {

    @Value("${server.port:8080}")
    private Integer port;

    @Value("${test.name:123456}")
    private String name;

    @GetMapping("/provider")
    public String provider(){
        Integer i = 10/0;
        return "hello,"+ name + port;
    }
}
