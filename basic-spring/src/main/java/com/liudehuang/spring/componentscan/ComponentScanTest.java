package com.liudehuang.spring.componentscan;

import com.liudehuang.spring.SpringApp;
import com.liudehuang.spring.config.ComponentScanConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ComponentScan源码主要看以下几个类：
 * ComponentScanAnnotationParser
 * ClassPathBeanDefinitionScanner
 * ClassPathScanningCandidateComponentProvider
 * protected void registerDefaultFilters() {
 *          //这里把Component的注解，添加到includeFilters里面来了，这就是@Component标注的类都注入到spring的ioc容器的原因
 *         this.includeFilters.add(new AnnotationTypeFilter(Component.class));
 *         ClassLoader cl = ClassPathScanningCandidateComponentProvider.class.getClassLoader();
 *
 *         try {
 *             this.includeFilters.add(new AnnotationTypeFilter(ClassUtils.forName("javax.annotation.ManagedBean", cl), false));
 *             this.logger.trace("JSR-250 'javax.annotation.ManagedBean' found and supported for component scanning");
 *         } catch (ClassNotFoundException var4) {
 *         }
 *
 *         try {
 *             this.includeFilters.add(new AnnotationTypeFilter(ClassUtils.forName("javax.inject.Named", cl), false));
 *             this.logger.trace("JSR-330 'javax.inject.Named' annotation found and supported for component scanning");
 *         } catch (ClassNotFoundException var3) {
 *         }
 *
 *     }
 * 此处会将@Component，JSR-250 'javax.annotation.ManagedBean', 'JSR-330' 'javax.inject.Named'的注解进行注册，所以难怪我们的自定义注解必须添加这些派生注解，
 * 换一个角度思考，他们这个地方进行类AnnotationTypeFilter的添加，我们也可以自定义AnnotationTypeFilter将自己定义规则的注解进行注入容器
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringApp.class)
public class ComponentScanTest {
    /**
     * 根据注解过滤,FilterType.ANNOTATION
     */
    @Test
    public void testAnnotation(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanName:beanDefinitionNames){
            System.out.println(beanName);
        }
    }

    /**
     * 根据指定的类型过滤,FilterType.ASSIGNABLE_TYPE
     */
    @Test
    public void testAssignableType(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanName:beanDefinitionNames){
            System.out.println(beanName);
        }
    }

    /**
     * 测试自定义TypeFilter,FilterType.CUSTOM
     */
    @Test
    public void testCustom(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanName:beanDefinitionNames){
            System.out.println(beanName);
        }
    }

    @Test
    public void testCustomForLdhComponent(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String beanName:beanDefinitionNames){
            System.out.println(beanName);
        }
    }
}
