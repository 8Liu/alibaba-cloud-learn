package com.liudehuang.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/3 17:12
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/3 17:12
 * @UpdateRemark:
 * @Version:
 */
@SpringBootApplication
public class RedisApp {

    public static void main(String[] args) {
        SpringApplication.run(RedisApp.class, args);
    }
}
