package com.liudehuang.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 17:28
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 17:28
 * @UpdateRemark:
 * @Version:
 */

/**
 * 线程池的几个参数
 * ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
 * TimeUnit unit,BlockingQueue<Runnable> workQueue)
 * corePoolSize:核心线程数
 * maximumPoolSize：最大线程数
 * keepAliveTime：线程空闲时间
 * BlockingQueue是双缓冲队列。BlockingQueue内部使用两条队列，允许两个线程同时向队列一个存储，一个取出操作。在保证并发安全的同时，提高了队列的存取效率。
 * <p>
 * 配置默认的线程池
 * 注意：该线程池被所有的异步任务共享，而不属于某一个异步任务
 * 描述：配置异步任务的线程池
 * 当一个任务通过execute(Runnable)方法欲添加到线程池时：
 * 如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。
 * 如果此时线程池中的数量等于 corePoolSize，但是缓冲队列 workQueue未满，那么任务被放入缓冲队列。
 * 如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maximumPoolSize，建新的线程来处理被添加的任务。
 * 如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，那么通过 handler所指定的策略来处理此任务。
 * 也就是：处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、最大线程 maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
 * 当线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。
 */
public class NewCacheThreadPoolExample {
    public static void main(String[] args) {
        /**
         * 创建一个可缓存线程池
         * ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
         * 可缓存线程池，先查看池中有没有以前建立的线程，如果有，则直接使用。
         **/

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            try {
                // sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    // 打印正在执行的缓存线程信息
                    System.out.println(Thread.currentThread().getName()
                            + "正在被执行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
