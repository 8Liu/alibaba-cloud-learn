package com.liudehuang.thread.communication.basic;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 11:00
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 11:00
 * @UpdateRemark:
 * @Version:
 */
public class WaitExample{

    private volatile boolean flag = false;


    private synchronized void printA(){
        try {
            while (flag){
                this.wait();
            }
            System.out.println("A");
            flag = true;
            //唤醒在等待的线程
            this.notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private synchronized void printB(){
        try {
            while (!flag){
                this.wait();
            }
            System.out.println("B");
            flag = false;
            this.notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WaitExample waitExample = new WaitExample();
        for(int i=0;i<300;i++){
            new Thread(()->{
                waitExample.printA();
            }).start();
            new Thread(()->{
                waitExample.printB();
            }).start();
        }
    }
}
