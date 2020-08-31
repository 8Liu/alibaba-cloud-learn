package com.liudehuang.spring.custom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.net.URL;

/**
 * 自定义TypeFilter
 * 如果不加以过滤，则包下的所有类都会当成组件，注册到spring容器中
 */
@Slf4j
public class MyTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader 读取到的当前正在扫描的类的信息
     * @param metadataReaderFactory 可以获取到其他任务类的信息
     * @return true 则把符合条件的组件注册到spring容器中，如果是false则不注册
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //1.获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        String annotationClassName = annotationMetadata.getClassName();
        log.info(">>>>>>>>>>>>>>>>>当前类的注解是:{}", annotationClassName);
        //2.获取当前正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        String className = classMetadata.getClassName();
        log.info(">>>>>>>>>>>>>>>>>当前类的信息:{}", className);
        //获取当前类的资源信息，例如：类的路径等信息
        Resource resource = metadataReader.getResource();
        URL url = resource.getURL();
        String path = url.getPath();
        log.info(">>>>>>>>>>>>>>>>>当前类的路径:{}", path);
        return className.contains("service");
    }
}
