package com.liudehuang.spring.entity;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 21:04
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 21:04
 * @UpdateRemark:
 * @Version:
 */
public class SubBook extends Book implements BeanClassLoaderAware,
        EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware,
        ApplicationEventPublisherAware, MessageSourceAware {

    private String bookSystem;

    public String getBookSystem() {
        return bookSystem;
    }

    public void setBookSystem(String bookSystem) {
        System.out.println("设置BookSystem 的属性值");
        this.bookSystem = bookSystem;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("subBook.setBeanClassLoader()方法被调用了");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("subBook.setApplicationEventPublisher()方法被调用了");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        System.out.println("subBook.setEmbeddedValueResolver()方法被调用了");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("subBook.setEnvironment()方法被调用了");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("subBook.setMessageSource()方法被调用了");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("subBook.setResourceLoader()方法被调用了");
    }
}
