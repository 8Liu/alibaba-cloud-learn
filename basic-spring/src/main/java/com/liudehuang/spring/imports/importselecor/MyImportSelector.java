package com.liudehuang.spring.imports.importselecor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
@Slf4j
public class MyImportSelector implements ImportSelector {
    /**
     *
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        log.info("MyImportSelector>>>>>>>>>>>>>>:{}",annotationMetadata.getClassName());
        return new String[]{"com.liudehuang.spring.entity.ImportEntity"};

    }
}
