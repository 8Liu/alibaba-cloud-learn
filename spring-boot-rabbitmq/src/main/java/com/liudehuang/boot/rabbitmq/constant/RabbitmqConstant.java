package com.liudehuang.boot.rabbitmq.constant;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/3 11:17
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/3 11:17
 * @UpdateRemark:
 * @Version:
 */
public class RabbitmqConstant {
    /**********************************************延时mq配置*************************************************************/
    /**
     * 延时队列名称
     */
    public static final String DELAY_QUEUE_NAME = "delay.queue.business.name";
    /**
     * 延时交换机名称
     */
    public static final String DELAY_EXCHANGE_NAME = "delay.exchange.business.name";

    /**
     * 绑定延时队列和延时交换机的路由key
     */
    public static final String DELAY_ROUTING_KEY = "delay.routingkey.business.name";

    /**************************************************死信mq配置*****************************************************************/

    /**
     * 死信队列名称
     */
    public static final String DEAD_LETTER_QUEUE_NAME = "dead.letter.queue.name";

    /**
     * 死信交换机名称
     */
    public static final String DEAD_LETTER_EXCHANGE_NAME = "dead.letter.exchange.name";

    /**
     * 绑定死信交换机和死信路由器的路由key
     */
    public static final String DEAD_LETTER_ROUTING_KEY = "dead.letter.routingkey.name";

    /***************************************************业务mq配置************************************************************************/

    /**
     * 取消订单队列名称
     */
    public static final String CANCEL_ORDER_QUEUE_NAME = "cancel.order.queue.name";
    /**
     * 取消订单交换机名称
     */
    public static final String CANCEL_ORDER_EXCHANGE_NAME = "cancel.order.exchange.name";
    /**
     * 绑定取消订单交换机和取消订单队列的路由键
     */
    public static final String CANCEL_ORDER_ROUTING_KEY = "cancel.order.routingkey.name";
}
