package com.liudehuang.thread.communication.basic;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 15:45
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 15:45
 * @UpdateRemark:
 * CountDownLatch
 * countDownLatch是一个计数器，线程完成一个记录一个，计数器递减，只能只用一次
 * 适用于等待所有线程执行完后完成一些操作
 * @Version:
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws Exception {
        countDownLatch();
    }

    public static void countDownLatch() throws Exception{
        int thread = 3 ;
        long start = System.currentTimeMillis();
        final CountDownLatch countDown = new CountDownLatch(thread);
        for (int i= 0 ;i<thread ; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"开始");
                    try {
                        Thread.sleep(2000);
                        countDown.countDown();
                        System.out.println(Thread.currentThread().getName()+"结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "thread_"+i).start();
        }
        countDown.await();
        long stop = System.currentTimeMillis();
        System.out.println("main over total time="+(stop-start));
    }
}
