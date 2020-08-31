package com.liudehuang.boot.rabbitmq.config;

import com.liudehuang.boot.rabbitmq.constant.RabbitmqConstant;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/3 11:23
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/3 11:23
 * @UpdateRemark:
 * @Version:
 */
@Configuration
public class RabbitmqConfig {
    /*****************************************************死信mq配置**************************************************************/

    /**
     * 死信队列名
     * @return
     */
    @Bean("deadLetterQueue")
    public Queue deadLetterQueue(){
        return new Queue(RabbitmqConstant.DEAD_LETTER_QUEUE_NAME);
    }

    /**
     * 死信交换机名
     * @return
     */
    @Bean("deadLetterExchange")
    public DirectExchange deadLetterExchange(){
        return new DirectExchange(RabbitmqConstant.DEAD_LETTER_EXCHANGE_NAME);
    }

    /**
     * 绑定死信交换机和死信队列的路由键
     * @param deadLetterQueue
     * @param deadLetterExchange
     * @return
     */
    @Bean("deadLetterBinding")
    public Binding deadLetterBinding(@Qualifier("deadLetterQueue") Queue deadLetterQueue,
                                        @Qualifier("deadLetterExchange") DirectExchange deadLetterExchange){
        return BindingBuilder.bind(deadLetterQueue)
                .to(deadLetterExchange)
                .with(RabbitmqConstant.DEAD_LETTER_ROUTING_KEY);
    }

    /*************************************************************业务mq配置*************************************************************/

    /**
     * 取消订单队列名称
     * @return
     */
    @Bean("cancelOrderQueue")
    public Queue cancelOrderQueue(){
        Map<String, Object> args = new HashMap<>(3);
      /*  // x-dead-letter-exchange    这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", RabbitmqConstant.DEAD_LETTER_EXCHANGE_NAME);
        // x-dead-letter-routing-key  这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", RabbitmqConstant.DEAD_LETTER_ROUTING_KEY);
        // x-message-ttl  声明队列的TTL 消息的过期时间 设置队列的ttl 6s
        args.put("x-message-ttl", 6000);*/
        return QueueBuilder.durable(RabbitmqConstant.CANCEL_ORDER_QUEUE_NAME).withArguments(args).build();
    }

    /**
     * 取消订单交换机名称
     * @return
     */
    @Bean("cancelOrderExchange")
    public DirectExchange cancelOrderExchange(){
        return new DirectExchange(RabbitmqConstant.CANCEL_ORDER_EXCHANGE_NAME);
    }

    /**
     * 取消订单路由键
     * @param cancelOrderQueue
     * @param cancelOrderExchange
     * @return
     */
    @Bean("cancelOrderBinding")
    public Binding cancelOrderBinding(@Qualifier("cancelOrderQueue") Queue cancelOrderQueue,
                                      @Qualifier("cancelOrderExchange") DirectExchange cancelOrderExchange){
        return BindingBuilder.bind(cancelOrderQueue)
                .to(cancelOrderExchange)
                .with(RabbitmqConstant.CANCEL_ORDER_ROUTING_KEY);
    }

    /******************************************************延时mq配置**************************************************************/

    /**
     * 延时队列
     * @return
     */
    @Bean("delayMsgQueue")
    public Queue delayMsgQueue(){
        return new Queue(RabbitmqConstant.DELAY_QUEUE_NAME);
    }

    /**
     * 延时交换机
     * @return
     */
    @Bean("delayMsgExchange")
    public CustomExchange delayMsgExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(RabbitmqConstant.DELAY_EXCHANGE_NAME, "x-delayed-message",
                true, false, args);
    }

    /**
     * 绑定延时队列和延时交换机的路由键
     * @param delayMsgQueue
     * @param delayMsgExchange
     * @return
     */
    @Bean
    public Binding delayMsgBinding(@Qualifier("delayMsgQueue") Queue delayMsgQueue,
                                 @Qualifier("delayMsgExchange") CustomExchange delayMsgExchange) {
        return BindingBuilder.bind(delayMsgQueue).to(delayMsgExchange)
                .with(RabbitmqConstant.DELAY_ROUTING_KEY).noargs();
    }

    /***********************************************************************************************************************/

    /**
     * rabbitmq 监听者容器
     * @param configurer
     * @param connectionFactory
     * @return
     */
    @Bean("customContainerFactory")
    public SimpleRabbitListenerContainerFactory containerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConcurrentConsumers(3);  //设置线程数
        factory.setMaxConcurrentConsumers(10); //最大线程数
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);//设置为手动确认acks
        configurer.configure(factory, connectionFactory);
        return factory;
    }

}
