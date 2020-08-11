package com.liudehuang.thread.communication.basic;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 15:44
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 15:44
 * @UpdateRemark:
 * 一、volatile关键字
 * 1.保证线程的可见性
 * 2.有序性，禁止指令重排序
 * volatile语义保证线程可见性有两个原则保证
 * 1)所有volatile修饰的变量一旦被某个线程更改，必须立即刷新到主内存
 * 2)所有volatile修饰的变量在使用之前必须重新读取主内存的值
 * @Version:
 */
public class VolatileExample implements Runnable{
    private static volatile boolean flag = true ;
    @Override
    public void run() {
        while (flag){
            System.out.println(Thread.currentThread().getName() + "正在运行。。。");
        }
        System.out.println(Thread.currentThread().getName() +"执行完毕");
    }
    public static void main(String[] args) throws InterruptedException {
        VolatileExample aVolatile = new VolatileExample();
        new Thread(aVolatile,"thread A").start();
        System.out.println("main 线程正在运行") ;
        TimeUnit.MILLISECONDS.sleep(100) ;
        aVolatile.stopThread();
    }
    private void stopThread(){
        flag = false ;
    }
}
