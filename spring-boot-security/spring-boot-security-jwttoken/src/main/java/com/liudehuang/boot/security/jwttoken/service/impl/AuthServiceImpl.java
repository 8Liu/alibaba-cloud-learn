package com.liudehuang.boot.security.jwttoken.service.impl;
import com.liudehuang.boot.security.jwttoken.exceptions.BusinessException;
import com.liudehuang.boot.security.jwttoken.model.domain.BaseUser;
import com.liudehuang.boot.security.jwttoken.model.request.UserLoginRequest;
import com.liudehuang.boot.security.jwttoken.model.request.UserRegisterRequest;
import com.liudehuang.boot.security.jwttoken.model.response.ResponseToken;
import com.liudehuang.boot.security.jwttoken.service.AuthService;
import com.liudehuang.boot.security.jwttoken.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public BaseUser register(UserRegisterRequest param) {
        return null;
    }

    @Override
    public ResponseToken login(UserLoginRequest param) {
        Authentication authentication = authenticate(param.getUserName(), param.getPassword());
        //存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        BaseUser user = (BaseUser)authentication.getPrincipal();
        String token = jwtUtil.generateAccessToken(user);
        jwtUtil.putToken(param.getUserName(),token);
        return new ResponseToken(token, user);
    }

    @Override
    public BaseUser getUserByToken(String token) {
        return null;
    }

    @Override
    public ResponseToken refresh(String token) {
        return null;
    }

    @Override
    public void logout(String token) {

    }

    /**
     * 验证账号密码
     * @param username
     * @param password
     * @return
     */
    private Authentication authenticate(String username, String password) {
        try {
            //该方法会去调用userDetailsService.loadUserByUsername()去验证用户名和密码，如果正确，则存储该用户名密码到“security 的 context中”
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException | BadCredentialsException e) {
            throw new BusinessException(e.getMessage());
        } catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }
}
