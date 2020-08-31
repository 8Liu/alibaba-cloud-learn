package com.liudehuang.spring.imports;

import com.liudehuang.spring.SpringApp;
import com.liudehuang.spring.config.ImportConfig;
import com.liudehuang.spring.config.MyFactoryBean;
import com.liudehuang.spring.entity.Business;
import com.liudehuang.spring.entity.Win10Entity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringApp.class)
public class ImportTest {
    @Test
    public void testImport() throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ImportConfig.class);
        Business business = context.getBean("myFactoryBean", Business.class);
        System.out.println(business);
       /* String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String beanName:beanDefinitionNames){
            System.out.println(beanName);
        }*/
    }
}
