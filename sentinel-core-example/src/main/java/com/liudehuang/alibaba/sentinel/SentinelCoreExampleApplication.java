package com.liudehuang.alibaba.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.liudehuang.alibaba")
@EnableDiscoveryClient
@EnableFeignClients
public class SentinelCoreExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelCoreExampleApplication.class, args);
    }

}
