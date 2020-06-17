package com.liudehuang.boot.security.jwttoken.config;

import com.liudehuang.boot.security.jwttoken.mapper.BaseMenuMapper;
import com.liudehuang.boot.security.jwttoken.mapper.BaseRoleMapper;
import com.liudehuang.boot.security.jwttoken.mapper.BaseUserMapper;
import com.liudehuang.boot.security.jwttoken.model.domain.BaseMenu;
import com.liudehuang.boot.security.jwttoken.model.domain.BaseRole;
import com.liudehuang.boot.security.jwttoken.model.domain.BaseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private BaseUserMapper userMapper;

    @Autowired
    private BaseRoleMapper roleMapper;

    @Autowired
    private BaseMenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BaseUser user = userMapper.selectByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No userDetail found with username '%s'.", username));
        }
        List<BaseRole> roleList = roleMapper.selectByUserId(user.getId());
        List<BaseMenu> menuList = menuMapper.selectByUserId(user.getId());
        user.setRoleList(roleList);
        user.setMenuList(menuList);
        return user;
    }
}
