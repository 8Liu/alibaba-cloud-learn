package com.liudehuang.boot.security.jwttoken.hander;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        //验证为未登陆状态会进入此方法，认证错误
        System.out.println("认证失败：" + e.getMessage());
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        Map<String, Object> map = new HashMap<>();
        map.put("code",401);
        map.put("message","认证失败");
        map.put("data",e.getMessage());
        String body = JSONObject.toJSONString(map);
        printWriter.write(body);
        printWriter.flush();
    }
}
