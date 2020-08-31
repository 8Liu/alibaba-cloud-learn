package com.liudehuang.boot.rabbitmq.controller;

import com.liudehuang.boot.rabbitmq.constant.RabbitmqConstant;
import com.liudehuang.boot.rabbitmq.mq.MqSender;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

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

    @Autowired
    private RabbitTemplate rabbitTemplate;

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

    /**
     * mq的拉模式，主动从队列中拉取消息
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/getMessage")
    public String getMessage() throws UnsupportedEncodingException {
        Message message = rabbitTemplate.receive(RabbitmqConstant.CANCEL_ORDER_QUEUE_NAME);
        byte[] body = message.getBody();
        return new String(body, "UTF-8");
    }
}
