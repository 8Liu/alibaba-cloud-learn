package com.liudehuang.thread.communication.printJiOuNum;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 15:08
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 15:08
 * @UpdateRemark:
 * @Version:
 */
public class TestJiOuNum {
    /**
     * 等待通知有着一个经典的范式：
     * 线程A作为消费者：
     * 1.获取对象的锁
     * 2.进入while(判断条件),并调用wait()方法
     * 3.当条件满足跳出循环执行具体处理逻辑。
     * 线程B作为生成者
     * 1.获取对象锁。
     * 2.更改与线程 A 共用的判断条件。
     * 3.调用 notify() 方法
     * @param args
     */
    public static void main(String[] args) {
        JiOuNum jiOuNum = new JiOuNum();
        Thread t1 = new Thread(new JiNum(jiOuNum));
        t1.setName("A线程");
        Thread t2 = new Thread(new OuNum(jiOuNum));
        t2.setName("B线程");
        t1.start();
        t2.start();
    }
}
