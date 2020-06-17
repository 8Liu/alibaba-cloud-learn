package com.liudehuang.boot.druid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.liudehuang.boot.druid.mapper")
public class DruidApp {
    public static void main(String[] args) {
        SpringApplication.run(DruidApp.class,args);
    }
}
