package com.liudehuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-02
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-02
 * @UpdateRemark:
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelFeignProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(SentinelFeignProviderApp.class, args);
    }
}
