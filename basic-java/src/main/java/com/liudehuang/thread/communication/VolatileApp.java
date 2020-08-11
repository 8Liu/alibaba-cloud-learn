package com.liudehuang.thread.communication;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 10:24
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 10:24
 * @UpdateRemark:
 * @Version:
 */
public class VolatileApp {

    private static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(()->{
            while (flag){
                for(int i=0; i<5; i++){
                    System.out.println("threadA:"+ i);
                    if(i==4){
                        flag = false;
                    }
                }
            }
        },"threadA").start();
        new Thread(()->{
            while (!flag){
                for(int i=0; i<5; i++){
                    System.out.println("threadB:"+ i);
                    if(i==4){
                        flag = true;
                    }
                }
            }
        },"threadB").start();
    }
}
