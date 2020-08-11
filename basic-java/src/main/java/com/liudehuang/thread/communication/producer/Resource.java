package com.liudehuang.thread.communication.producer;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 14:07
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 14:07
 * @UpdateRemark:
 * @Version:
 */
public class Resource {
    /**
     * 当前资源数量
     */
    private Integer num = 0;
    /**
     * 最大资源数量
     */
    private Integer size = 10;


    public synchronized void add(){
        if(num<size){
            num++;
            System.out.println("生产者--" + Thread.currentThread().getName()
                    +"--生产一件资源，当前资源池有"+num+"个");
            notifyAll();
        }else {
            try {
                wait();
                System.out.println("生产者--"+Thread.currentThread().getName()+"进入等待状态，等待通知");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void remove(){
        if (num > 0){
            num--;
            System.out.println("消费者--" + Thread.currentThread().getName() +
                    "--消耗一件资源，" + "当前线程池有" + num + "个");
            notifyAll();
        }else{
            try {
                wait();
                System.out.println("消费者--" + Thread.currentThread().getName() + "进入等待状态，等待通知");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
