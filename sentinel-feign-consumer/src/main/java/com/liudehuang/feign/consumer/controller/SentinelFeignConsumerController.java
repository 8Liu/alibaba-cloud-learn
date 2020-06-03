package com.liudehuang.feign.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.liudehuang.feign.consumer.service.SentinelFeignProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-02
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-02
 * @UpdateRemark:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/sentinelFeignConsumer")
public class SentinelFeignConsumerController {

    private Integer i = 0;

    @Autowired
    private SentinelFeignProviderService providerService;

    @GetMapping("/consumer")
    @SentinelResource("consumer")
    public String consumer(){
        return providerService.provider();
    }
}
