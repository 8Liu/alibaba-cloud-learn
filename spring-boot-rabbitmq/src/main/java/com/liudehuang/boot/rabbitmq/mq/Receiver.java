package com.liudehuang.boot.rabbitmq.mq;

import com.alibaba.fastjson.JSONObject;
import com.liudehuang.boot.rabbitmq.constant.RabbitmqConstant;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/3 14:23
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/3 14:23
 * @UpdateRemark:
 * @Version:
 */
@Component
@Slf4j
public class Receiver {
    /**
     * 进入死信交换机的消息
     * 1.消息被拒绝，使用 channel.basicNack 或 channel.basicReject ，并且此时requeue 属性被设置为false
     * 2.消息在队列的存活时间超过设置的TTL时间。
     * 3.消息队列的消息数量已经超过最大队列长度
     * 监听死信队列的消息
     * @param message
     * @param deliveryTag
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = RabbitmqConstant.DEAD_LETTER_QUEUE_NAME, containerFactory = "customContainerFactory")
    public void receiveDeadLetterMsg(Message message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException{
        try{
            String msg = new String(message.getBody(), "UTF-8");
            log.info("监听死信队列mq消息：param:{},date:{}",msg, new Date());
            //deliveryTag：该消息的index multiple:是否批量.true:将一次性ack所有小于deliveryTag的消息
            channel.basicAck(deliveryTag, false);
        }catch (Exception e){
            // deliveryTag: 该消息的index
            // multiple:是否批量.true:将一次性拒绝所有小于deliveryTag的消息。
            // requeue:是否重入队列
            log.error("message:{} e:{}",e.getMessage(),e);
            channel.basicNack(deliveryTag, false, false);
            // deliveryTag: 该消息的index
            // requeue:是否重入队列
            //channel.basicReject(deliveryTag, false);
        }

    }

    /**
     * 监听取消订单队列
     * @param message
     * @param deliveryTag
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = RabbitmqConstant.CANCEL_ORDER_QUEUE_NAME, containerFactory = "customContainerFactory")
    public void receiveCancelOrderMsg(Message message, @Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag, Channel channel) throws IOException{
        try {
            String msg = new String(message.getBody(), "UTF-8");
            log.info("监听取消订单列mq消息：param:{},date:{}",msg, new Date());
        }catch (Exception e){
            log.error("message:{} e:{}",e.getMessage(),e);
            channel.basicNack(deliveryTag, false, false);
        }

    }
}
