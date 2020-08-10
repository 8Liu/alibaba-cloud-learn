package com.liudehuang.thread.newthread;

public class MyThread extends Thread {

    private String threadName;

    MyThread(String threadName){
        this.threadName = threadName;
        System.out.println("creating:"+this.threadName);
    }

    @Override
    public void run() {
        System.out.println("running:" + this.threadName);
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    @Override
    public synchronized void start() {
        System.out.println("Starting " +  threadName );
        super.start();
    }
}
