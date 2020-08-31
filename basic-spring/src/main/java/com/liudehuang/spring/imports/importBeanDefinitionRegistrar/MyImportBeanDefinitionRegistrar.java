package com.liudehuang.spring.imports.importBeanDefinitionRegistrar;

import com.liudehuang.spring.entity.MyImportBeanDefinitionRegistrarEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
@Slf4j
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * 注册bean
     * @param annotationMetadata bean元信息
     * @param beanDefinitionRegistry bean注册
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        RootBeanDefinition definition = new RootBeanDefinition(MyImportBeanDefinitionRegistrarEntity.class);
        beanDefinitionRegistry.registerBeanDefinition("registrarEntity", definition);
    }
}
