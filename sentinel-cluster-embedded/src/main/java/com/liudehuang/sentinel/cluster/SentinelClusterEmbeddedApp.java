package com.liudehuang.sentinel.cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class SentinelClusterEmbeddedApp {
    public static void main(String[] args) {
        SpringApplication.run(SentinelClusterEmbeddedApp.class, args);
    }
}
