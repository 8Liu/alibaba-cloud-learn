package com.liudehuang.alibaba.nacos.consumer.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.liudehuang")
@EnableDiscoveryClient
@EnableFeignClients
public class NacosDiscoveryConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryConsumerFeignApplication.class, args);
    }

}
