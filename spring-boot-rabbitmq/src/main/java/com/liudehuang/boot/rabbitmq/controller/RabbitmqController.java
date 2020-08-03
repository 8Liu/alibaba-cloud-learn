package com.liudehuang.boot.rabbitmq.controller;

import com.liudehuang.boot.rabbitmq.constant.RabbitmqConstant;
import com.liudehuang.boot.rabbitmq.mq.MqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/3 14:35
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/3 14:35
 * @UpdateRemark:
 * @Version:
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitmqController {
    @Autowired
    private MqSender mqSender;

    @GetMapping("/sendDeadMsg")
    public String sendDeadMsg(@RequestParam("msg") String msg){
        mqSender.sendOrdinaryMsg(msg, RabbitmqConstant.CANCEL_ORDER_EXCHANGE_NAME, RabbitmqConstant.CANCEL_ORDER_ROUTING_KEY);
        return "success";
    }

    @GetMapping("/sendDelayMsg")
    public String sendDelayMsg(@RequestParam("msg") String msg){
        mqSender.sendDelayMsgByPulgin(msg, RabbitmqConstant.DELAY_EXCHANGE_NAME, RabbitmqConstant.DELAY_ROUTING_KEY, 5000);
        return "success";
    }
}
