package com.liudehuang.boot.security.jwttoken.mapper;

import com.liudehuang.boot.security.jwttoken.model.domain.BaseUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseUserMapper {

    int deleteByPrimaryKey(String id);


    int insert(BaseUser record);


    int insertSelective(BaseUser record);

    int updateByPrimaryKeySelective(BaseUser record);

    int updateByPrimaryKey(BaseUser record);

    BaseUser selectByPrimaryKey(String id);

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    BaseUser selectByUserName(String userName);
}