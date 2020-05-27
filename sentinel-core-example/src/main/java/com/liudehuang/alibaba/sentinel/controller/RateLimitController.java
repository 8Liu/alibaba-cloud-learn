package com.liudehuang.alibaba.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.liudehuang.alibaba.sentinel.handler.ExceptionHandler;
import com.liudehuang.alibaba.sentinel.service.NacosProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/rateLimit")
public class RateLimitController {
    @Autowired
    private NacosProviderFeign nacosProviderFeign;

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "exHandler",blockHandlerClass = ExceptionHandler.class)
    public String byResource(){
        String str = "success,按资源名称限流";
        System.out.println(str);
        return str;
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public String byUrl(){
        String str = nacosProviderFeign.provider();
        return str;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


}
