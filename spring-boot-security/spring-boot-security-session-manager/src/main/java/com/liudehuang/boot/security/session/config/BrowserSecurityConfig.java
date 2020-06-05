package com.liudehuang.boot.security.session.config;

import com.liudehuang.boot.security.session.handler.MyAuthenticationFailureHandler;
import com.liudehuang.boot.security.session.handler.MyAuthenticationSucessHandler;
import com.liudehuang.boot.security.session.sessionConfig.MySessionExpiredStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-05
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-05
 * @UpdateRemark:
 * @Version: 1.0
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl();
    }

    @Autowired
    private MyAuthenticationSucessHandler authenticationSucessHandler;
    @Autowired
    private MyAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private MySessionExpiredStrategy sessionExpiredStrategy;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin() // 表单登录
                // http.httpBasic() // HTTP Basic
                .loginPage("/login.html")//设置登录界面
                .loginProcessingUrl("/login")//登录界面发起的请求
                .successHandler(authenticationSucessHandler)//登录验证成功需要处理的事情
                .failureHandler(authenticationFailureHandler)//登录验证失败需要处理的事情
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/css/login.css", "/login.html", "/session/invalid").permitAll()//对/login.html请求不拦截
                .anyRequest()  // 所有请求
                .authenticated()// 都需要认证
                .and()
                .sessionManagement() // 添加 Session管理器
                .invalidSessionUrl("/session/invalid") // Session失效后跳转到这个链接
                .maximumSessions(1)//session并发控制数为1,即如果同时登录数超过这个值，
                // 会把前面的人踢出（注意：session并发控制只对账号密码登录有效，对手机短信登录和第三方授权登录不启作用）
                .expiredSessionStrategy(sessionExpiredStrategy)//设置踢出人的提示
                //.maxSessionsPreventsLogin(true)//如果设置了此值，当session并发控制超过设置数值时,则不可以登录了
                .and()
                .and().csrf().disable();//关闭csrf攻击防御
    }
}
