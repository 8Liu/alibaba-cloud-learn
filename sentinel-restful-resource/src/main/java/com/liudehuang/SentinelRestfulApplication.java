package com.liudehuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-03
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-03
 * @UpdateRemark:
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelRestfulApplication.class,args);
    }
}
