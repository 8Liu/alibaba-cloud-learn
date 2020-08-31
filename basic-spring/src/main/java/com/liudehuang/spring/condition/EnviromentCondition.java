package com.liudehuang.spring.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 按条件注入bean
 */
public class EnviromentCondition implements Condition {
    /**
     *
     * @param conditionContext spring的应用上下文
     * @param annotatedTypeMetadata 获取当前注解的信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        Environment environment = conditionContext.getEnvironment();
        //win7
        String osName = environment.getProperty("os.name");
        if(osName.equals("Windows 10")){
            //满足条件可以注册bean
            return true;
        }
        return false;
    }
}
