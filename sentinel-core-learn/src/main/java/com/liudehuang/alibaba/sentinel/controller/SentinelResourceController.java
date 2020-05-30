package com.liudehuang.alibaba.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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
 */
@RestController
@RequestMapping("/sentinelResource")
public class SentinelResourceController {
    //@SentinelResource定义一个资源
    //定义当前资源内部发生异常的时候的处理逻辑
    //blockHandler 定义单个资源内部发生了BlockException的异常处理逻辑（捕获的是sentinel定义的异常）
    //fallback 定义当资源内部发生了Throwable应该进入的方法
    //blockHandlerClass
    //
    @GetMapping("/message")
    @SentinelResource(value = "sentinelResourceTest", blockHandler = "blockHandler",fallback = "fallback")
    public String sentinelResourceTest(@RequestParam("name") String name){
        return "sentinelResourceTest:"+name;
    }

    //1.当前方法返回值和参数要和原方法一致
    //2.但是允许参数列表的最后加入一个参数BlockException,用来接收原方法中发生的异常
    public String blockHandler(String name, BlockException e){
        //自定义处理异常逻辑
        System.out.println(String.format("触发率BlockException,param:{}",name));
        return "blockHandler:"+name;
    }

    //1.当前方法返回值和参数要和原方法一致
    //2.但是允许参数列表的最后加入一个参数Throwable,用来接收原方法中发生的异常
    public String fallback(String name, Throwable e){
        //自定义处理异常逻辑
        System.out.println(String.format("触发率Throwable,param:{}",name));
        System.out.println("Throwable:"+name);
        return "Throwable:"+name;
    }
}
