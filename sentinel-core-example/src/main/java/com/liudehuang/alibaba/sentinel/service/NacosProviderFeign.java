package com.liudehuang.alibaba.sentinel.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-05-27
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-05-27
 * @UpdateRemark:
 * @Version: 1.0
 */
@FeignClient(value = "nacos-discovery-provider",path = "/nacosProvider",fallback = NacosProviderServiceFallBackImpl.class)
public interface NacosProviderFeign {
    @GetMapping("/provider")
    String provider();
}
