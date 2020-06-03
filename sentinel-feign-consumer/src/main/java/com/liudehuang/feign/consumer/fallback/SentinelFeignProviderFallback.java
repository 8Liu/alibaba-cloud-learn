package com.liudehuang.feign.consumer.fallback;

import com.liudehuang.feign.consumer.service.SentinelFeignProviderService;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-02
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-02
 * @UpdateRemark:
 * @Version: 1.0
 */
@Component
public class SentinelFeignProviderFallback implements SentinelFeignProviderService {
    @Override
    public String provider() {
        return "provider-fallBack";
    }
}
