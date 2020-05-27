package com.liudehuang.alibaba.nacos.consumer.feign.service;

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
@FeignClient(value = "nacos-discovery-provider",path = "/nacosProvider")
public interface NacosProviderService {

    @GetMapping("/provider")
    String provider();
}
