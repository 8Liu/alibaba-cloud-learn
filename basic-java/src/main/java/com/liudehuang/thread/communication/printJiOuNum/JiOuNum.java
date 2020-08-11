package com.liudehuang.thread.communication.printJiOuNum;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 15:00
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 15:00
 * @UpdateRemark:
 * @Version:
 */
public class JiOuNum {

    private AtomicInteger start = new AtomicInteger(1);

    private boolean flag = false;

    public AtomicInteger getStart() {
        return start;
    }

    public void setStart(AtomicInteger start) {
        this.start = start;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
