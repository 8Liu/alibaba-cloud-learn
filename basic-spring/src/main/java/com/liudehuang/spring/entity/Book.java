package com.liudehuang.spring.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 19:52
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 19:52
 * @UpdateRemark:
 * @Version:
 */
public class Book implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String bookName;

    public Book(){
        System.out.println("Book的构造方法正在执行......");
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
        System.out.println("setBookName: Book name has set.");
    }

    /**
     * BeanFactoryAware
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Book.setBeanFactory invoke");
    }

    /**
     * BeanNameAware
     * @param beanName
     */
    @Override
    public void setBeanName(String beanName) {
        System.out.println("Book.setBeanName invoke");
    }

    /**
     * DisposableBean
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("Book.destory invoke");
    }

    /**
     * InitializingBean
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Book.afterPropertiesSet invoke");
    }

    /**
     * ApplicationContextAware
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        System.out.println("Book.setApplicationContext invoke");
    }

    // 自定义初始化方法
    @PostConstruct
    public void springPostConstruct(){
        System.out.println("@PostConstruct");
    }


    public void initMethod(){
        System.out.println("init-method");
    }

    // 自定义销毁方法
    @PreDestroy
    public void springPreDestory(){
        System.out.println("@PreDestory");
    }
}
