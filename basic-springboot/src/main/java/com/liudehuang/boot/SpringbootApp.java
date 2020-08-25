package com.liudehuang.boot;

import com.liudehuang.boot.config.Config;
import com.liudehuang.boot.entity.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/12 17:31
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/12 17:31
 * @UpdateRemark:
 * @Version:
 */
@SpringBootApplication
public class SpringbootApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UserEntity userEntity = context.getBean("userEntity", UserEntity.class);
        System.out.println(userEntity);
    }
}
