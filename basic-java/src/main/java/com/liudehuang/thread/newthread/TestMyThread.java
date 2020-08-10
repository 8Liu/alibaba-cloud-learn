package com.liudehuang.thread.newthread;

public class TestMyThread {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("thread-1");
        myThread1.start();
        MyThread myThread2 = new MyThread("thread-2");
        myThread2.start();
    }
}
