package com.liudehuang.thread.communication.basic;

import java.util.concurrent.CyclicBarrier;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 15:53
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 15:53
 * @UpdateRemark:
 * CyclicBarrier 中文名叫做屏障或者是栅栏，也可以用于线程间通信。
 * 它可以等待 N 个线程都达到某个状态后继续运行的效果。
 * 1.首先初始化线程参与者。
 * 2.调用 await() 将会在所有参与者线程都调用之前等待。
 * 3.直到所有参与者都调用了 await() 后，所有线程从 await() 返回继续后续逻辑。
 * @Version:
 */
public class CyclicBarrierExample {

    public static void main(String[] args) throws Exception {
        cyclicBarrier();
    }

    private static void cyclicBarrier() throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3) ;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run");
                try {
                    cyclicBarrier.await() ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" thread end do something");
            }
        }, "A线程").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run");
                try {
                    cyclicBarrier.await() ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" thread end do something");
            }
        }, "B线程").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run");
                try {
                    cyclicBarrier.await() ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" thread end do something");
            }
        },"C线程").start();
        System.out.println("main thread");
    }
}
