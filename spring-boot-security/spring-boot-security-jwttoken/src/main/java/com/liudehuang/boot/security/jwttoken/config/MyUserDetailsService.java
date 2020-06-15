package com.liudehuang.boot.security.jwttoken.config;

import com.liudehuang.boot.security.jwttoken.mapper.BaseRoleMapper;
import com.liudehuang.boot.security.jwttoken.mapper.BaseUserMapper;
import com.liudehuang.boot.security.jwttoken.model.domain.BaseRole;
import com.liudehuang.boot.security.jwttoken.model.domain.BaseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private BaseUserMapper userMapper;
    @Autowired
    private BaseRoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BaseUser user = userMapper.selectByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No userDetail found with username '%s'.", username));
        }
        BaseRole role = roleMapper.selectByUserId(user.getId());
        user.setRole(role);
        return user;
    }
}
