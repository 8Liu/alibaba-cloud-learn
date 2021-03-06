package com.liudehuang.boot.security.jwttoken.filter;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 实现AbstractSecurityInterceptor, 访问url时，会被AbstractSecurityInterceptor拦截器拦截，
 * 然后调用FilterInvocationSecurityMetadataSource的方法来获取被拦截url所需的全部权限，
 * 再调用授权管理器AccessDecisionManager鉴权。（自定义权限验证管理器）
 */
@Component
public class CustomSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {
    private FilterInvocationSecurityMetadataSource securityMetadataSource;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation(request, response, chain);
        invoke(fi);
    }
    @Override
    public void destroy() {
    }
    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }
    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }
    public void invoke(FilterInvocation fi) throws IOException {
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } catch (ServletException e) {
            super.afterInvocation(token, null);
        }
    }
    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
        return securityMetadataSource;
    }

    public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
        this.securityMetadataSource = securityMetadataSource;
    }
}