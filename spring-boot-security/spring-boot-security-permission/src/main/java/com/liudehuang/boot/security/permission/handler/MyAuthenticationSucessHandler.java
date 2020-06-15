package com.liudehuang.boot.security.permission.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: liudehuang
 * @CreateDate: 2020-06-05
 * @UpdateUser: liudehuang
 * @UpdateDate: 2020-06-05
 * @UpdateRemark: 自定义登录成功逻辑
 * @Version: 1.0
 */
@Component
public class MyAuthenticationSucessHandler implements AuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();
    @Autowired
    private ObjectMapper mapper;
    /**
     * 重定向对象
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 登录成功后重定向到用户第一次访问的路径
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        redirectStrategy.sendRedirect(request, response, savedRequest.getRedirectUrl());
    }

    /**
     * 当账号密码验证正确时，打印authentication对象
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
/*    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();
        response.setContentType("application/json;charset=utf-8");
        writer.write(mapper.writeValueAsString(authentication));
    }*/


}
