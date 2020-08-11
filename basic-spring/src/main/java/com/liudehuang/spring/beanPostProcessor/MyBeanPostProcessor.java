package com.liudehuang.spring.beanPostProcessor;

import com.liudehuang.spring.entity.Book;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 20:19
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 20:19
 * @UpdateRemark:
 * @Version:
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 容器加载的时候会加载一些其他的bean，会调用初始化前和初始化后方法
    // 这次只关注book(bean)的生命周期
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Book){
            Book bookBean = (Book) bean;
            System.out.println("book的名称："+bookBean.getBookName());
            System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Book){
            System.out.println("MyBeanPostProcessor.postProcessAfterInitialization");
        }
        return bean;
    }
}
