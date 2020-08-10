package com.liudehuang.thread.threadbasic;

/**
 * public final void setPriority(int priority) 更改线程的优先级
 */
public class PriorityThread2 extends Thread {

    private String threadName;

    public PriorityThread2(String name){
        this.threadName = name;
        System.out.println("creating:"+this.threadName);
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            try {
                System.out.println(this.threadName+"_"+i+" running:"+"goodbye");
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
