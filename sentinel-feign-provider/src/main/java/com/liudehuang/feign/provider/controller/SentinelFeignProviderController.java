package com.liudehuang.feign.provider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
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
@RequestMapping("/sentinelFeignProvider")
public class SentinelFeignProviderController {

    @SentinelResource("provider")
    @GetMapping("/provider")
    public String provider(){
        return "provider";
    }

}
