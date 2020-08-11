package com.liudehuang.thread.communication.basic;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 15:15
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 15:15
 * @UpdateRemark: join方法 ,例如：假如A线程内调用B线程的b.join(),则A线程处于阻塞状态，等待B线程完全执行完
 * @Version:
 */
public class JoinExample {

    public static void join1() throws InterruptedException {
        Thread threadA = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+":running");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "threadA");

        Thread threadB = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+":running");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "threadB");
        threadA.start();
        threadB.start();
        //阻塞当前线程，等待线程A执行完
        threadA.join();
        //阻塞当前线程，等待线程B执行完
        threadB.join();
        System.out.println("main函数结束");
    }

    public static void join2() throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+":running");
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A线程");
        t1.start();
        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":running");
            for(int i=0;i<8;i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B线程");
        t2.start();
        t2.join();
        System.out.println("main函数结束");
    }

    public static void main(String[] args) throws InterruptedException {
        join2();
    }


}
