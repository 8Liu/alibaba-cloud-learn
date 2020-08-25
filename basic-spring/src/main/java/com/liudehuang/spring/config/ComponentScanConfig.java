package com.liudehuang.spring.config;

import com.liudehuang.spring.custom.LdhComponentTypeFilter;
import com.liudehuang.spring.custom.MyTypeFilter;
import com.liudehuang.spring.entity.SubBook;
import com.liudehuang.spring.entity.User;
import com.liudehuang.spring.service.UseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @Description:
 * @Author: liudh
 * @CreateDate: 2020/8/11 19:51
 * @UpdateUser: liudh
 * @UpdateDate: 2020/8/11 19:51
 * @UpdateRemark:
 * @Version:
 * @ComponentScan 扫描该类所在的包以及子包下的类
 *  includeFilters：
 *  {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = xxxx.class)} 根据注解进行过滤(被该注解标注的组件都被加载到spring容器中)
 *  {@ComponentScan.Filter(type = FilterType.ASPECTJ, classes = xxxx.class)} 根据ASPECTJ表达式进行过滤
 *  {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = xxxx.class)} 按照自定义规则进行过滤，自定义规则的时候，定义规则的类必须是org.springframework.core.type.filter.TypeFilter接口的实现类
 *  {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = UserService.class)} 根据指定的类型进行过滤，按照给定类型只包含UserService的接口或者子类（实现类或子接口）的组件
 *  {@ComponentScan.Filter(type = FilterType.REGEX, classes = xxxx.class)} 根据正则表达式过滤
 */
@Configuration
/*@ComponentScan(value = "com.liudehuang.spring", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class)},
        useDefaultFilters = false)*/
/*@ComponentScan(value = "com.liudehuang.spring",includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = UseService.class)},
        useDefaultFilters = false)*/
/*@ComponentScan(value = "com.liudehuang.spring",includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)},
        useDefaultFilters = false)*/
/*@ComponentScan(value = "com.liudehuang.spring",includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = LdhComponentTypeFilter.class)},
        useDefaultFilters = false)*/
public class ComponentScanConfig {
    @Bean
    public User user(){
        User user = new User();
        user.setUserName("dddd");
        user.setAge(50);
        return user;
    }

}
