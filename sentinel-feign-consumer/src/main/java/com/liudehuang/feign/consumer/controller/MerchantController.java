package com.liudehuang.feign.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/merchant")
public class MerchantController {

    @GetMapping("/api/{merchantId}/order/{orderId}/pay")
    public String pay(@PathVariable String merchantId, @PathVariable String orderId){
        return merchantId + ":" + orderId;
    }
}
