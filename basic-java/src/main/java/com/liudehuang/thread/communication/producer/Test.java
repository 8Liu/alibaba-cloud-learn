package com.liudehuang.thread.communication.producer;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 14:34
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 14:34
 * @UpdateRemark:
 * @Version:
 */
public class Test {

    public static void main(String[] args) {
        Resource resource = new Resource();

        //创建3个生产者线程
        Thread t1 = new Thread(new Producer(resource),"生产线程1");
        Thread t2 = new Thread(new Producer(resource),"生产线程2");
        Thread t3 = new Thread(new Producer(resource),"生产线程3");

        //创建2个消费者线程
        Thread t4 = new Thread(new Consumer(resource),"消费线程1");
        Thread t5 = new Thread(new Consumer(resource),"消费线程2");

        //生产者线程启动
        t1.start();
        t2.start();
        t3.start();
        //消费者线程启动
        t4.start();
        t5.start();
    }
}
