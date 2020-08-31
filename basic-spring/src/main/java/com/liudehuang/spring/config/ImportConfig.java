package com.liudehuang.spring.config;

import com.liudehuang.spring.entity.Win10Entity;
import com.liudehuang.spring.imports.importBeanDefinitionRegistrar.MyImportBeanDefinitionRegistrar;
import com.liudehuang.spring.imports.importselecor.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Import的作用是将外部的jar包注入到springioc容器中，
 * 但@Import注入bean的id是该类的全路径类名
 * @Import里的类可以是普通类名、ImportSelector的实现类、ImportBeanDefinitionRegistrar的实现类
 */
@Configuration
@ComponentScan(value = "com.liudehuang.spring")
@Import({
        Win10Entity.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class
})
public class ImportConfig {

    @Bean
    public MyFactoryBean myFactoryBean(){
        return new MyFactoryBean();
    }
}
