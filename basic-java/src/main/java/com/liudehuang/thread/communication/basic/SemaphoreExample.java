package com.liudehuang.thread.communication.basic;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 16:03
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 16:03
 * @UpdateRemark:信号量，控制同时访问特定资源的线程数量
 * semaphore.acquire()获得许可信号量
 * semaphore.release();释放信号量
 * @Version:
 */
public class SemaphoreExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        //信号量，只允许 3个线程同时访问
        Semaphore semaphore = new Semaphore(3);

        for (int i=0;i<10;i++){
            final long num = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可
                        semaphore.acquire();
                        //执行
                        System.out.println("Accessing: " + num);
                        Thread.sleep(new Random().nextInt(5000)); // 模拟随机执行时长
                        //释放
                        semaphore.release();
                        System.out.println("Release..." + num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
    }
}
