package com.liudehuang.alibaba.sentinel.service;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-05-27
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-05-27
 * @UpdateRemark:
 * @Version: 1.0
 */
@Component
public class NacosProviderServiceFallBackImpl implements NacosProviderFeign {
    @Override
    public String provider() {
        return "服务降级处理";
    }
}
