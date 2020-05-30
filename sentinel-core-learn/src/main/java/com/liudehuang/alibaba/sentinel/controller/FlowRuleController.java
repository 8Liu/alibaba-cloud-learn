package com.liudehuang.alibaba.sentinel.controller;

import com.liudehuang.alibaba.sentinel.service.SentinelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-05-28
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-05-28
 * @UpdateRemark:
 * @Version: 1.0
 *
 * 1.sentinel的基本概念
 * 资源：sentinel要保护的资源
 * 规则：规则是定义如何保护资源的
 * 2.服务容错
 * ①不被外界环境影响 （系统负载保护）
 * ②不被上游请求压垮（限流/流量控制）
 * ③不被下游响应拖垮 (熔断降级)
 */
@RestController
@RequestMapping("/flowRule")
public class FlowRuleController {
    @Autowired
    private SentinelService sentinelService;

    /**
     * sentinel限流阈值类型为qps的测试
     * 1.资源
     * 2.针对来源：针对哪个微服务进行限流
     * 3.限流类型：qps 线程
     * @return
     */
    @GetMapping("/qpsTest")
    public String qpsTest(){
        return "qpsTest";
    }

    /**
     * sentinel限流阈值类型为线程数的测试
     * 简单
     * @return
     */
    @GetMapping("/threadTest")
    public String threadTest(){
        return "threadTest";
    }

    /**
     * sentinel有三种流控模式
     * 1.直接：接口达到限流条件后，直接限流
     * 2.关联：当关联的资源达到限流调价时，开启限流
     *  eg：当为directMode设置规则为关联模式时，关联资源为relationMode,
     *  规则为qps为3,当relationMode资源的访问满足限流规则时,directMode
     *  进行限流
     *  一般用于应用让步
     * 3.链路：当从某个接口过来的资源达到限流时，开始限流
     * 链路流控模式指的是，当从摸个接口过来的资源达到限流条件时，开始限流。它的功能有点类似于针对来源配置项，
     * 区别在于：针对来源是针对上级微服务，而链路流控是针对上级接口，也是说它的粒度更细
     * eg: /flowRule/directMode 和flowRule/relationMode 都调用message方法，当为message设置规则为链路模式时，流控模式为链路，
     * 入口资源设置为/flowRule/directMode,规则为qps 为1
     * 当访问directMode的qps超过规则时，触发限流，而relationMode因为没有设置规则，不限流
     * @return
     */
    @GetMapping("/directMode")
    public String directMode(){
        sentinelService.message();
        return "directMode";
    }

    /**
     * sentinel的三种流控效果
     * 1.快速失败:直接失败,抛出异常，不做任何额外的处理，是最简单的效果
     * 2.warm up：它从开始阈值到最大QPS阈值会有一个缓冲阶段，一开始的阈值是最大阈值的1/3，然后慢慢增长，直到最大阈值，适用于将突然增大的
     * 流量装换成缓步增长的场景
     * 3.排队等待：让请求以均匀的速度通过，单机阈值为每秒通过数量，其余的排队等待；它还会让设置一个超时时间，当请求超过超时时间还未处理，
     * 则会被丢弃
     * @return
     */
    @GetMapping("/relationMode")
    public String relationMode(){
        sentinelService.message();
        return "relationMode";
    }

    /**
     * 针对来源进行流量控制
     * @param serviceName
     * @return
     */
    @GetMapping("/limitForSource")
    public String limitForSource(@RequestParam("serviceName") String serviceName){
        return serviceName+":limitForSource";
    }
}
