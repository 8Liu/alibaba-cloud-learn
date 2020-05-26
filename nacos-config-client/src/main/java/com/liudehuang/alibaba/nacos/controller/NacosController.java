package com.liudehuang.alibaba.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-05-26
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-05-26
 * @UpdateRemark:
 * @Version: 1.0
 */
@RestController
@RefreshScope
@RequestMapping("/nacos")
public class NacosController {
    /**
     * 1.nacos的Data ID默认是${spring.cloud.nacos.config.prefix}-${spring.profile.active}.${spring.cloud.nacos.config.file-extension}
     * 2.spring.cloud.nacos.config.prefix的默认值为${spring.application.name}
     * 3.spring.cloud.nacos.config.file-extension的默认值为properties
     * 4.当spring.profiles.active未配置时，则匹配${spring.application.name}.properties
     * 5.若设置了spring.profiles.active而Nacos中存在${spring.application.name}.properties时，
     *   若还存在${spring.application.name}-${spring.profiles.active}.properties，则默认匹配后者，若不存在，则会自动匹配前者
     * 6.由于Nacos建议且默认用spring.application.name作为Data Id的前缀，若要在不同服务中共享项目统一配置，
     *   则可以通过配置spring.cloud.nacos.config.shared-dataids或spring.cloud.nacos.config.refreshable-dataids来添加共享配置，
     *   前者不支持自动刷新，后者支持
     *
     */
    @Value("${test:空str}")
    private String str;

    @GetMapping("/test")
    public String test(){
        return str;
    }
}
