package com.liudehuang.spring.config;

import com.liudehuang.spring.condition.EnviromentCondition;
import com.liudehuang.spring.entity.Win10Entity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.liudehuang.spring")
public class ConditionConfig {


    @Conditional(EnviromentCondition.class)
    @Bean
    public Win10Entity win10Entity(){
        return new Win10Entity();
    }
}
