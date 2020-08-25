package com.liudehuang.spring.config;

import com.liudehuang.spring.entity.Business;
import org.springframework.beans.factory.FactoryBean;

/**
 * factoryBean和beanFactory
 * factoryBean是往springIoc容器中注入对象的（本质是一个bean）
 * beanFactory是从容器中获取对象的（本质是一个factory）
 */
public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Business business = new Business();
        business.setMsg("服务器处理异常");
        business.setName("500");
        return business;
    }

    @Override
    public Class<?> getObjectType() {
        return Business.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
