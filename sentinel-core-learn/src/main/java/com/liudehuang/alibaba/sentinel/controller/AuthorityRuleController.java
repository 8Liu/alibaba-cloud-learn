package com.liudehuang.alibaba.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-05-28
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-05-28
 * @UpdateRemark:黑白名单限流
 * @Version: 1.0
 */
@RestController
@RequestMapping("/authorityRule")
public class AuthorityRuleController {
    /**
     * 黑名单白名单限流
     * 1.实现RequestOriginParser来源设置接口，设置来源规则
     * 2.为此接口配置授权（黑白名单）规则，流控应用设置为RequestOriginParser配置的来源
     * 3.选择授权类型
     * @return
     */
    @GetMapping("/authorityRuleTest")
    public String authorityRuleTest(){
        return "authorityRuleTest";
    }
}
