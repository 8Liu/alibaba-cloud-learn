package com.liudehuang.boot.security.jwttoken.mapper;

import com.liudehuang.boot.security.jwttoken.model.domain.BaseRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseRoleMapper {

    int deleteByPrimaryKey(String id);

    int insert(BaseRole record);

    int insertSelective(BaseRole record);

    int updateByPrimaryKeySelective(BaseRole record);

    int updateByPrimaryKey(BaseRole record);

    BaseRole selectByPrimaryKey(String id);

    /**
     * 根据userId查询对应的角色
     * @param userId
     * @return
     */
    BaseRole selectByUserId(String userId);
}