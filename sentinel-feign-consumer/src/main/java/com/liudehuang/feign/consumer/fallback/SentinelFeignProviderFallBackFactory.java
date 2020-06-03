package com.liudehuang.feign.consumer.fallback;

import com.liudehuang.feign.consumer.service.SentinelFeignProviderService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Component
public class SentinelFeignProviderFallBackFactory implements FallbackFactory<SentinelFeignProviderService> {
    @Override
    public SentinelFeignProviderService create(Throwable throwable) {
        return new SentinelFeignProviderService() {
            @Override
            public String provider() {
                log.error(throwable.getMessage());
                return "provider-fallback";
            }
        };
    }
}
