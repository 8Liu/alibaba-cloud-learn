package com.liudehuang.boot.security.jwttoken.model.domain;

public class BaseRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_role.ID
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_role.ROLE_CODE
     *
     * @mbggenerated
     */
    private String roleCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_role.ROLE_NAME
     *
     * @mbggenerated
     */
    private String roleName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_role.ID
     *
     * @return the value of base_role.ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_role.ID
     *
     * @param id the value for base_role.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_role.ROLE_CODE
     *
     * @return the value of base_role.ROLE_CODE
     *
     * @mbggenerated
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_role.ROLE_CODE
     *
     * @param roleCode the value for base_role.ROLE_CODE
     *
     * @mbggenerated
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_role.ROLE_NAME
     *
     * @return the value of base_role.ROLE_NAME
     *
     * @mbggenerated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_role.ROLE_NAME
     *
     * @param roleName the value for base_role.ROLE_NAME
     *
     * @mbggenerated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}