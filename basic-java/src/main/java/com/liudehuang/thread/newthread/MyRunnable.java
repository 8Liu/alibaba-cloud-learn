package com.liudehuang.thread.newthread;

public class MyRunnable implements Runnable {

    private String threadName;

    MyRunnable(String threadName){
        this.threadName = threadName;
        System.out.println("creating:"+this.threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " +  threadName );
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


}
