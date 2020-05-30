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
 * @UpdateRemark:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/degradeRule")
public class DegradeRuleController {

    private Integer i = 0;

    /**
     * 降级策略
     * 1.rt(平均响应时间)：当资源的平均响应时间超过阈值（以ms为单位）后，资源进入准降级状态，如果接下来1s内持续进入
     * 5个请求，它们的rt都持续超过这个阈值，在接下来的时间窗口（以s做单位）之内，就会对这个方法进行服务降级
     * 注意：sentinel默认统计的rt上限是4900ms,超过此阈值的都会被算作4900秒杀，若需要变更此上限可以通过启动配置项
     * -Dcsp.sentinel.statistic.max.rt=xx配置
     * eg:为/degreaderRule/rtTest设置降级规则，降级策略为rt，rt时间为5ms，时间窗口设置为5s，
     * 当/degreaderRule/rtTest的平均响应时间超过5ms时，在接下来的5s内，该接口会被降级，5s之后恢复正常
     *
     * 2.异常比例：资源每秒的异常总数占通过量的比值。当资源每秒的异常总数占通过量的比值超过阈值时，资源进入降级状态，即在接下来的时间窗口内，
     * 对这个方法的调用都会自动的返回，异常比率的阈值范围为[0,1.0].
     * eg:为/degradeRule/exceptionRatio设置降级规则，降级策略为异常比例，异常比例设置为0.25，时间窗口设置为5s，同时设置/degradeRule/excetionRatio
     * 没三次请求就有异常跑异常，异常比例为0.333，访问该接口时，当异常比例超过降级规则设置的异常比例时，在时间窗口5之内，会进行降级，5s之后恢复正常，
     * 调用原来接口
     *
     * 3.异常数：当资源近1分钟数目超过阈值之后会进行服务降级。注意：由于统计时间窗口是分钟级别的，若时间窗口小于60s，则结束熔断状态
     * 后仍然可能再进入熔断状态（时间窗口>60）
     * eg:为/degradeRule/exceptionCount设置降级规则,降级策略为异常数,异常数设置为3,时间窗口设置为80s,同时设置/degradeRule/excetionRatio
     *    没三次请求就有异常跑异常，异常比例为0.333,访问改接口时，当一分钟的异常数超过设置的异常 数时,在时间窗口内，会进行降级，80s后恢复
     */
    @GetMapping("/rtTest")
    public String rtTest(){
        return "rtTest";
    }


    @GetMapping("/exceptionRatio")
    public String exceptionRatio(){
        i++;
        //异常比例为0.3333
        if(i%3==0){
            throw new RuntimeException("服务降级");
        }
        return "exceptionRatio";
    }

    @GetMapping("/exceptionCount")
    public String exceptionCount(){
        i++;
        //异常比例为0.3333
        if(i%3==0){
            throw new RuntimeException("服务降级");
        }
        return "exceptionCount";
    }
}
