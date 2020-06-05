package com.liudehuang.boot.security.authentication.config;

import com.liudehuang.boot.security.authentication.smsConfig.SmsAuthenticationConfig;
import com.liudehuang.boot.security.authentication.smsConfig.SmsCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-04
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-04
 * @UpdateRemark:
 * @Version: 1.0
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * PasswordEncoder是一个密码加密接口
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private MyAuthenticationSucessHandler authenticationSucessHandler;

    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private SmsCodeFilter smsCodeFilter;

    @Autowired
    private SmsAuthenticationConfig smsAuthenticationConfig;

    /**
     * 持久化token的bean
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.formLogin() // 表单登录
                // http.httpBasic() // HTTP Basic
                .loginPage("/login.html") // 登录跳转 URL
                .loginProcessingUrl("/login") // 处理表单登录 URL
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/css/**","/login.html").permitAll() // 静态资源和login.html不需要权限验证
                .anyRequest()  // 所有请求
                .authenticated() // 都需要认证
                .and().csrf().disable();*/
      /*  http.formLogin() // 表单登录
                // http.httpBasic() // HTTP Basic
                .loginPage("/authentication/require") // 登录跳转 URL
                .loginProcessingUrl("/login") // 处理表单登录 URL
                .successHandler(authenticationSucessHandler)
                .failureHandler(authenticationFailureHandler)
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/css/**","/authentication/require", "/login.html").permitAll() // 登录跳转 URL 无需认证
                .anyRequest()  // 所有请求
                .authenticated() // 都需要认证
                .and().csrf().disable();*/
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)//添加验证码过滤器到用户名密码过滤器前面
                .addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)//添加短信验证码过滤器
                .formLogin() // 表单登录
                // http.httpBasic() // HTTP Basic
                .loginPage("/authentication/require") // 登录跳转 URL
                .loginProcessingUrl("/login") // 处理表单登录 URL
                .successHandler(authenticationSucessHandler) // 处理登录成功
                .failureHandler(authenticationFailureHandler) // 处理登录失败
                .and()
                .rememberMe()//记住我功能
                .tokenRepository(persistentTokenRepository()) // 配置 token 持久化仓库
                .tokenValiditySeconds(3600) // remember 过期时间，单为秒
                .userDetailsService(userDetailService) // 处理自动登录逻辑
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/authentication/require","/css/**",
                        "/login.html","/code/sms",
                        "/code/image").permitAll() // 无需认证的请求路径
                .anyRequest()  // 所有请求
                .authenticated() // 都需要认证
                .and().csrf().disable()
                .apply(smsAuthenticationConfig);
    }
}
