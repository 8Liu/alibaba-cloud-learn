package com.liudehuang.alibaba.sentinel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-05-28
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-05-28
 * @UpdateRemark:系统规则
 * @Version: 1.0
 */
@RestController
@RequestMapping("/systemRule")
public class SystemRuleController {
    /**
     * 系统保护规则是从应用级别的入口流量进行控制，从单台机器的总体load、rt、入口qps、cpu使用率和线程数五个纬度监控应用数据，让系统尽可能
     * 跑在最大吞吐量的同时保证系统的稳定性
     * ①Load(仅对Linux/unix-like机器生效):当系统load1超过阈值，且系统当前的并发线程数超过系统容量时才会触发系统保护。系统容量由系统的
     * maxQps*minRt计算得出，设定参考值一般是cpu cores*2.5
     * ②rt：当单台机器上所有入口流量的平均rt达到阈值即触发系统保护，单位是毫秒
     * ③线程数：当单台机器上所有入口流量的并发线程数达到阈值即触发系统保护
     * ④入口qps：当单台机器上所有入口流量的qps达到阈值即触发系统保护
     * ⑤cpu使用率：当单台机器上所有入口流量的cpu使用率达到阈值即触发系统保护
     */

}
