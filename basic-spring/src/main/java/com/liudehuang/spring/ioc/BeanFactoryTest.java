package com.liudehuang.spring.ioc;

import com.liudehuang.spring.SpringApp;
import com.liudehuang.spring.config.BookConfiguration;
import com.liudehuang.spring.entity.Book;
import com.liudehuang.spring.entity.Business;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 19:29
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 19:29
 * @UpdateRemark:
 * @Version:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringApp.class)
public class BeanFactoryTest {
    /**
     * 模拟BeanFactory
     */
    @Test
    public void moniBeanFactory(){
        //BeanDefinitionRegistry 抽象出bean的注册逻辑
        //BeanFactory 抽象出bean的管理逻辑
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        // 根据业务对象构造相应的BeanDefinition
        AbstractBeanDefinition definition = new RootBeanDefinition(Business.class);
        // 将bean定义注册到容器中
        beanRegistry.registerBeanDefinition("beanName",definition);
        // 如果有多个bean，还可以指定各个bean之间的依赖关系
        // ........

        // 然后可以从容器中获取这个bean的实例
        // 注意：这里的beanRegistry其实实现了BeanFactory接口，所以可以强转，
        // 单纯的BeanDefinitionRegistry是无法强制转换到BeanFactory类型的
        BeanFactory container = (BeanFactory)beanRegistry;
        Business business = (Business)container.getBean("beanName");
        System.out.println(business);
    }

    @Test
    public void testBeanLifecyle(){
        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfiguration.class);
        Book book = context.getBean("book", Book.class);
        System.out.println("Book name = "+book.getBookName());
        ((AnnotationConfigApplicationContext)context).destroy();
    }
}
