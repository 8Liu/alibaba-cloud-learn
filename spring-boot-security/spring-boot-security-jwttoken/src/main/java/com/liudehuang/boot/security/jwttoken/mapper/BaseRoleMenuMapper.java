package com.liudehuang.boot.security.jwttoken.mapper;

import com.liudehuang.boot.security.jwttoken.model.domain.BaseRoleMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseRoleMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_menu
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_menu
     *
     * @mbggenerated
     */
    int insert(BaseRoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_menu
     *
     * @mbggenerated
     */
    int insertSelective(BaseRoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_menu
     *
     * @mbggenerated
     */
    BaseRoleMenu selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BaseRoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_role_menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BaseRoleMenu record);
}