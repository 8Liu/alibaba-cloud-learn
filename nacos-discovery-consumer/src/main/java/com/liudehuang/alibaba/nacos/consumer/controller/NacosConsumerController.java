package com.liudehuang.alibaba.nacos.consumer.controller;

import com.alibaba.cloud.nacos.ribbon.NacosServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-05-27
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-05-27
 * @UpdateRemark:
 * @Version: 1.0
 */
@RefreshScope
@RestController
@RequestMapping("/nacosConsumer")
public class NacosConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/test")
    public String test() {
        RibbonLoadBalancerClient.RibbonServer ribbonServer = (RibbonLoadBalancerClient.RibbonServer)
                loadBalancerClient.choose("nacos-discovery-provider");
        NacosServer nacosServer = (NacosServer) ribbonServer.getServer();
        System.out.println("-->" + nacosServer.getMetadata());
        return restTemplate.getForObject( "http://nacos-discovery-provider/nacosProvider/provider", String.class);
    }
}
