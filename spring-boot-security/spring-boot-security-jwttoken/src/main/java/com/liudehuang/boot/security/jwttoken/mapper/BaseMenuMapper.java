package com.liudehuang.boot.security.jwttoken.mapper;

import com.liudehuang.boot.security.jwttoken.model.domain.BaseMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BaseMenuMapper {

    int deleteByPrimaryKey(String id);


    int insert(BaseMenu record);


    int insertSelective(BaseMenu record);


    BaseMenu selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(BaseMenu record);


    int updateByPrimaryKey(BaseMenu record);

    /**
     * 根据roleId查询资源信息
     * @param roleId
     * @return
     */
    List<BaseMenu> selectByRoleId(@Param("roleId") String roleId);

    List<BaseMenu> selectByUserId(@Param("userId") String userId);
}