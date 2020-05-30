package com.liudehuang.alibaba.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-05-28
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-05-28
 * @UpdateRemark:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/paramFlowRule")
public class ParamFlowRuleController {
    /**
     * 热点参数规则：热点参数规则是一种更细粒度的流控规则，它允许将规则具体到参数上
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/paramFlowRuleTest")
    @SentinelResource("paramFlowRuleTest")
    public String paramFlowRuleTest(String name, Integer age){
        return "paramFlowRuleTest:"+name+","+age;
    }
}
