package com.liudehuang.alibaba.sentinel.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-05-28
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-05-28
 * @UpdateRemark:Sentinel提供了RequestOriginParser接口来处理来源
 * (所有sentinel规则所用到的来源都是用此接口配置的)
 * @Version: 1.0
 */
@Component
public class RequestOriginParserDefinition implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        String serviceName = request.getParameter("serviceName");
        if(StringUtils.isEmpty(serviceName)){
            throw new RuntimeException("serviceName must not empty");
        }
        return serviceName;
    }
}
