package com.liudehuang.boot.security.permission.config;

import com.liudehuang.boot.security.permission.handler.MyAuthenticationAccessDeniedHandler;
import com.liudehuang.boot.security.permission.handler.MyAuthenticationFailureHandler;
import com.liudehuang.boot.security.permission.handler.MyAuthenticationSucessHandler;
import com.liudehuang.boot.security.permission.handler.MyLogOutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {


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
    @Autowired
    private MyLogOutSuccessHandler logOutSuccessHandler;
    @Autowired
    private MyAuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler)
                .and()
                .formLogin() // 表单登录
                // http.httpBasic() // HTTP Basic
                .loginPage("/login.html")//设置登录界面
                .loginProcessingUrl("/login")//登录界面发起的请求
                .successHandler(authenticationSucessHandler)//登录验证成功需要处理的事情
                .failureHandler(authenticationFailureHandler)//登录验证失败需要处理的事情
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers("/css/login.css", "/login.html", "/session/invalid"    ).permitAll()//对/login.html请求不拦截
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
                .and()
                .logout()
                .logoutUrl("/signout")//自定义退出登录url
                //.logoutSuccessUrl("/signout/success")//自定义退出登录处理URL
                .logoutSuccessHandler(logOutSuccessHandler)
                .deleteCookies("JSESSIONID")//退出成功后删除名称为JSESSIONID的cookie
                .and().csrf().disable();//关闭csrf攻击防御
    }
}
