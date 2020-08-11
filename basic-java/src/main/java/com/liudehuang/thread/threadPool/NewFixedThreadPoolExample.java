package com.liudehuang.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 17:39
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 17:39
 * @UpdateRemark:
 * @Version:
 * 创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程。（定长线程池）
 * 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
 */
public class NewFixedThreadPoolExample {

    public static void main(String[] args) {
        //创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程。(定长线程数)
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        // 打印正在执行的缓存线程信息
                        System.out.println(Thread.currentThread().getName()
                                + "正在被执行");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
