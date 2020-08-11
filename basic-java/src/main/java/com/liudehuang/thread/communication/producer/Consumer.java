package com.liudehuang.thread.communication.producer;

import java.io.Serializable;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 14:19
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 14:19
 * @UpdateRemark:
 * @Version:
 */
public class Consumer implements Runnable {
    //共享资源对象
    private Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            resource.remove();
        }
    }
}
