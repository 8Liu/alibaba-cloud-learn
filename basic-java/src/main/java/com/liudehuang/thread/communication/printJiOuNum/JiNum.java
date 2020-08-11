package com.liudehuang.thread.communication.printJiOuNum;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 15:01
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 15:01
 * @UpdateRemark:
 * @Version:
 */
public class JiNum implements Runnable {

    private JiOuNum jiOuNum;

    public JiNum(JiOuNum num){
        this.jiOuNum = num;
    }

    @Override
    public void run() {
        while (jiOuNum.getStart().get()<=100){
            synchronized (JiOuNum.class){
                //System.out.println("奇数线程抢到锁了");
                if(!this.jiOuNum.isFlag()){
                    System.out.println(Thread.currentThread().getName() + "+-+奇数" + jiOuNum.getStart().get());
                    jiOuNum.getStart().incrementAndGet();
                    jiOuNum.setFlag(true);
                    JiOuNum.class.notify();
                }else {
                    try {
                        JiOuNum.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
