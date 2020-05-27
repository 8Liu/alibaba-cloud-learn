package com.liudehuang.alibaba.nacos.consumer.feign.controller;

import com.liudehuang.alibaba.nacos.consumer.feign.service.NacosProviderService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/nacosFeign")
@RefreshScope
public class NacosFeignController {

    @Autowired
    private NacosProviderService nacosProviderService;

    @GetMapping("/test")
    public String test() {
        return nacosProviderService.provider();
    }
}
