package com.liudehuang.feign.consumer.service;

import com.liudehuang.feign.consumer.fallback.SentinelFeignProviderFallBackFactory;
import com.liudehuang.feign.consumer.fallback.SentinelFeignProviderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-02
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-02
 * @UpdateRemark:
 * @Version: 1.0
 */
@FeignClient(value = "sentinel-feign-provider", path = "/sentinelFeignProvider",
        fallbackFactory = SentinelFeignProviderFallBackFactory.class)
public interface SentinelFeignProviderService {
    @GetMapping("/provider")
    String provider();
}
