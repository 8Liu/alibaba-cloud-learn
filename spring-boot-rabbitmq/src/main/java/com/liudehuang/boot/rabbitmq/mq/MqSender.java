package com.liudehuang.boot.rabbitmq.mq;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/3 13:51
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/3 13:51
 * @UpdateRemark:
 * @Version:
 */
@Slf4j
@Component
public class MqSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     *
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if(!ack){
            log.error("mq发送没有到达目的地，correlationId:{},cause:{}",correlationData.getId(),cause);
        }else {
            log.info("mq成功发送到达目的地，correlationId:{}",correlationData.getId());
        }
    }

    /**
     *
     * @param message 消息
     * @param replyCode 返回码
     * @param replyText 错误消息
     * @param exchange 交换机
     * @param routingKey 路由键
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        String messageId = message.getMessageProperties().getMessageId();
        log.info("messageId:{}",messageId);
    }


    /**
     *
     * @param message
     * @param exchange
     * @param routingKey
     */
    public CorrelationData sendMsg(Object message, String exchange, String routingKey){
        log.info("生产者发送消息,date:{},message:{}",new Date(), JSONObject.toJSONString(message));
        String messageId = UUID.randomUUID().toString().replaceAll("-","");
        log.info("sendMsg方法中，messageId:{}",messageId);
        CorrelationData correlationId = new CorrelationData(messageId);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(this);
        return correlationId;
    }

    /**
     * 发送普通消息
     * @param message
     * @param exchange
     * @param routingKey
     */
    public void sendOrdinaryMsg(Object message, String exchange, String routingKey){
        String msg = JSONObject.toJSONString(message);
        CorrelationData correlationData = sendMsg(message, exchange, routingKey);
        rabbitTemplate.convertAndSend(exchange, routingKey, msg, correlationData);
    }

    /**
     * 通过死信队列发延时消息
     * @param message
     * @param exchange
     * @param routingKey
     */
    public void sendDelayMsgByDeadLetter(Object message, String exchange, String routingKey, Integer expireTime){
        String msg = JSONObject.toJSONString(message);
        CorrelationData correlationData = sendMsg(message, exchange, routingKey);
        rabbitTemplate.convertAndSend(exchange, routingKey, msg,
                a->{a.getMessageProperties().setExpiration(String.valueOf(expireTime));
                return a;}, correlationData);
    }

    /**
     * 通过rabbitmq插件发送延时消息
     * @param message
     * @param exchange
     * @param routingKey
     * @param delayTime 延时时间（毫秒做单位） 注意：不能超过24天，因为24天的毫秒值，超过了Integer.max
     */
    public void sendDelayMsgByPulgin(Object message, String exchange, String routingKey, Integer delayTime){
        String msg = JSONObject.toJSONString(message);
        CorrelationData correlationData = sendMsg(message, exchange, routingKey);
        rabbitTemplate.convertAndSend(exchange, routingKey, msg,
                a->{a.getMessageProperties().setDelay(delayTime);
                    return a;}, correlationData);
    }

}
