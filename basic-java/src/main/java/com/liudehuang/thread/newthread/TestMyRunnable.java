package com.liudehuang.thread.newthread;

public class TestMyRunnable {

    public static void main(String[] args) {
        Runnable runnable1 = new MyRunnable("runnable-1");
        Thread thread1 = new Thread(runnable1);
        thread1.start();

        Runnable runnable2 = new MyRunnable("runnable-2");
        Thread thread2 = new Thread(runnable2);
        thread2.start();
    }
}
