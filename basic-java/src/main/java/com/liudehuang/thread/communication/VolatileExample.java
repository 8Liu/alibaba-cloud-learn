package com.liudehuang.thread.communication;


import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 9:05
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 9:05
 * @UpdateRemark:
 * @Version:
 */
public class VolatileExample implements Runnable {

    private static volatile boolean flag = true;

    @Override
    public void run() {
        while (flag){
            System.out.println(Thread.currentThread().getName() + "正在运行。。。");
        }
        System.out.println(Thread.currentThread().getName() +"执行完毕");
    }

    public static void main(String[] args) {
        VolatileExample aVolatile = new VolatileExample();
        new Thread(aVolatile,"thread A").start();
        new Thread(()->{
            System.out.println("threadB 正在运行.....");
            flag = false;
        }).start();
        System.out.println("main 线程正在运行") ;
        try {
            TimeUnit.MILLISECONDS.sleep(100) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
