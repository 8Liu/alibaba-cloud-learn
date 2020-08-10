package com.liudehuang.thread.threadbasic;

public class TestPriority {
    public static void main(String[] args) {
        PriorityThread1 p1 = new PriorityThread1("thread-p1");
        p1.setPriority(Thread.MAX_PRIORITY);
        p1.start();
        PriorityThread2 p2 = new PriorityThread2("thread-p2");
        p2.setPriority(Thread.MIN_PRIORITY);
        p2.start();
    }
}
