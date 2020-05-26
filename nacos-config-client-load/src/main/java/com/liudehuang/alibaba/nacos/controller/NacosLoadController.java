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
@RequestMapping("/nacosLoad")
public class NacosLoadController {
    /**
     * nacos的加载顺序：默认加载 SharedConfig共享配置，然后加载extConfig自定义配置，最后加载applicationConfig,
     * 因此最后加载的会覆盖掉之前的配置，因此当你读取应用名同名的配置时会读取不到(默认加载顺序：shared-dataids,ext-config,applicationConfig)
     *
     * 注意：当nacos中配置文件的名称改了，不重启程序的话读取的数据是上一次的数据，例：把common.name的名称改成common.namedd，
     * common.name的值是common.yml,此时如果改了名称且不重启服务的话，common.name的值还是common.yml
     */
    @Value("${common.name:空str}")
    private String str;

    @GetMapping("/test")
    public String test(){
        return str;
    }
}
