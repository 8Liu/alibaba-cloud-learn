package com.liudehuang.thread.communication.printABC;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 10:33
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 10:33
 * @UpdateRemark:
 * @Version:
 */
public class WaitNotifyApp extends Thread {

    private String name;

    private Object prev;

    private Object self;

    public WaitNotifyApp(String name, Object prev, Object self){
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    /**
     * wait()与notify/notifyAll()是Object类的方法，在执行这两个方法时，都要先获得锁
     * 当线程执行wait()方法时，会把当前的锁释放，然后让出cpu，进入等待状态
     * 当执行notify/notifyAll()方法时，会唤醒一个处于等待该对象锁的线程，
     * 然后继续往下执行，直到执行完退出对象锁的区域（synchronized的代码块）后再释放锁
     * 从这里可以看出，notify/notifyAll()执行后，并不立即释放锁，而是要等到执行完临界区中代码后，再释放。
     * 所以在实际编程中，我们应该尽量在线程调用notify/notifyAll()后，立即退出临界区。即不要在notify/notifyAll()后面再写一些耗时的代码
     *
     */
    @Override
    public void run() {
        int count = 10;
        while (count > 0){
            synchronized (prev){
                synchronized (self){
                    System.out.println(name);
                    count-- ;
                    self.notifyAll();   // 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。
                }
                try {
                    if (count == 0){    // 如果count==0,表示这是最后一次打印操作，通过notifyAll操作释放对象锁。
                        prev.notifyAll();
                    }else{              // 立即释放 prev锁，当前线程休眠，等待唤醒
                        prev.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        Thread A = new WaitNotifyApp("A",c,a);
        Thread B = new WaitNotifyApp("B",a,b);
        Thread C = new WaitNotifyApp("C",b,c);

        A.start();
        Thread.sleep(10);
        B.start();
        Thread.sleep(10);
        C.start();
    }
}
