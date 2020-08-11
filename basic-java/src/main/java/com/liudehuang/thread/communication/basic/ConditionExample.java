package com.liudehuang.thread.communication.basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 14:19
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 14:19
 * @UpdateRemark:
 * @Version:
 */
public class ConditionExample {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private volatile boolean flag = false;

    private void printA(){
        lock.lock();
        try{
            while(flag){
                condition.await();
            }
            System.out.println("A");
            flag = true;
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private void printB(){
        lock.lock();
        try{
            while (!flag){
                condition.await();
            }
            System.out.println("B");
            flag = false;
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionExample conditionExample = new ConditionExample();
        for(int i=0;i<100;i++){
            new Thread(()->conditionExample.printA()).start();
            new Thread(()->conditionExample.printB()).start();
        }
    }
}
