package com.liudehuang.boot.config;

import com.liudehuang.boot.entity.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserEntity userEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setName("liudehuang");
        userEntity.setAge(30);
        return userEntity;
    }
}
