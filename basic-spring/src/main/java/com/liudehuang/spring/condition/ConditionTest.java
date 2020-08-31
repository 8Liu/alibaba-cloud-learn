package com.liudehuang.spring.condition;

import com.liudehuang.spring.SpringApp;
import com.liudehuang.spring.config.ConditionConfig;
import com.liudehuang.spring.entity.Win10Entity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringApp.class)
public class ConditionTest {
    @Test
    public void testCondition(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        Win10Entity win10Entity = context.getBean("win10Entity", Win10Entity.class);
        System.out.println(win10Entity);
    }
}
