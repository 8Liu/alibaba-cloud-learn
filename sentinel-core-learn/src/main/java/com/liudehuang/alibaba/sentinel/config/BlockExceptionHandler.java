package com.liudehuang.alibaba.sentinel.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-05-28
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-05-28
 * @UpdateRemark:异常处理页面（处理流量控制、熔断降级、热点数据限流规则限流后返回的页面一样无法区分什么规则引起的）
 * @Version: 1.0
 */
@Component
public class BlockExceptionHandler implements UrlBlockHandler {
    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException e) throws IOException {
        //BlockException 异常接口，包含sentinel的五个异常
        //FlowException 限流异常
        //DegradeException 降级异常
        //ParamFlowException 热点参数限流异常
        //AuthorityException 黑白名单异常
        //SystemBlockException 系统负载异常
        response.setContentType("application/json;charset=utf-8");
        String responseData = null;
        if(e instanceof FlowException){
            responseData = "流量控制限流：接口被限流了";
        }else if(e instanceof DegradeException){
            responseData = "熔断降级限流：接口被降级了";
        }else if(e instanceof ParamFlowException){
            responseData = "热点参数限流：接口根据参数被限流了";
        }else if(e instanceof AuthorityException){
            responseData = "黑白名单限流：接口被黑白名单限流了";
        }
        response.getWriter().write(JSONObject.toJSONString(responseData));
    }
}
