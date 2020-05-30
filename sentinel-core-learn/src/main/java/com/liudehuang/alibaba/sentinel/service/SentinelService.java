package com.liudehuang.alibaba.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-05-28
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-05-28
 * @UpdateRemark:
 * @Version: 1.0
 */
@Service
public class SentinelService {
    //@SentinelResource定义一个资源
    //定义当前资源内部发生异常的时候的处理逻辑
    //blockHandler 定义单个资源内部发生了BlockException的异常处理逻辑（捕获的是sentinel定义的异常）
    //fallback 定义当资源内部发生了Throwable应该进入的方法
    @SentinelResource("message")
    public String message(){
        return "message";
    }
}
