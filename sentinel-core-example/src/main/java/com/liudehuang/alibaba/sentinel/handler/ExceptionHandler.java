package com.liudehuang.alibaba.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-05-27
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-05-27
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ExceptionHandler {

    /**
     * 当限流报异常时，异常处理
     * @param exception
     * @return
     */
    public static String exHandler(BlockException exception){
        return "exHandler error";
    }
}
