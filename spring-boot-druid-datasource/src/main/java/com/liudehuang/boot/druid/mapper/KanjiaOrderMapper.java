package com.liudehuang.boot.druid.mapper;

import com.liudehuang.boot.druid.entity.KanjiaOrder;

public interface KanjiaOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kanjia_order
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kanjia_order
     *
     * @mbggenerated
     */
    int insert(KanjiaOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kanjia_order
     *
     * @mbggenerated
     */
    int insertSelective(KanjiaOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kanjia_order
     *
     * @mbggenerated
     */
    KanjiaOrder selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kanjia_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(KanjiaOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kanjia_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(KanjiaOrder record);
}