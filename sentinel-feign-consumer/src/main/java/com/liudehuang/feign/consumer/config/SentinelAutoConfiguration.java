package com.liudehuang.feign.consumer.config;

import com.alibaba.cloud.sentinel.SentinelProperties;
import com.alibaba.cloud.sentinel.SentinelWebAutoConfiguration;
import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.*;

import static com.liudehuang.feign.consumer.config.SpringCommonFilter.HTTP_METHOD_SPECIFY;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-03
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-03
 * @UpdateRemark:
 * @Version: 1.0
 */
@Configuration
@EnableConfigurationProperties(SentinelProperties.class)
public class SentinelAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(SentinelWebAutoConfiguration.class);

    private static final String SKIP_LIST_KEY = "spring.cloud.sentinel.pathvariable.skip.list";

    private static final String EXCLUDE_URLS = "spring.cloud.sentinel.excludeUrls";

    @Bean
    @ConditionalOnProperty(name = {"spring.cloud.sentinel.filter.enabled"}, havingValue = "false")
    @ConditionalOnBean(SentinelProperties.class)
    public FilterRegistrationBean sentinelFilter(SentinelProperties properties, SpringCommonFilter springCommonFilter, ApplicationContext applicationContext) {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean();
        com.alibaba.cloud.sentinel.SentinelProperties.Filter filterConfig = properties.getFilter();
        if (filterConfig.getUrlPatterns() == null || filterConfig.getUrlPatterns().isEmpty()) {
            List<String> defaultPatterns = new ArrayList();
            defaultPatterns.add("/*");
            filterConfig.setUrlPatterns(defaultPatterns);
        }
        registration.addUrlPatterns((String[])filterConfig.getUrlPatterns().toArray(new String[0]));
        registration.setFilter(springCommonFilter);
        Map<String,String> parameters = new HashMap<>();
        parameters.put(HTTP_METHOD_SPECIFY,"false");
        parameters.put(EXCLUDE_URLS,applicationContext.getEnvironment().getProperty(EXCLUDE_URLS, ""));
        registration.setInitParameters(parameters);
        registration.setOrder(filterConfig.getOrder());
        log.info("[Sentinel Starter] register Sentinel with urlPatterns: {}.", filterConfig.getUrlPatterns());
        return registration;
    }

    @Bean
    public SpringCommonFilter springCommonFilter(ApplicationContext applicationContext) {

        return new SpringCommonFilter();
    }

    @Bean
    @ConditionalOnMissingBean
    public UrlCleaner urlCleaner(ApplicationContext applicationContext) {
        String[] skipList =
                applicationContext.getEnvironment().getProperty(SKIP_LIST_KEY, "")
                        .split(",");
        Set<String> skipSet = new HashSet<>();
        skipSet.addAll(Arrays.asList(skipList));
        return new RestfulUrlCleaner(skipSet);
    }
}
