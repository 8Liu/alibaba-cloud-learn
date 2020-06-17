package com.liudehuang.boot.security.jwttoken.model.domain;

public class BaseMenu {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_menu.ID
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_menu.MENU_URL
     *
     * @mbggenerated
     */
    private String menuUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_menu.MENU_SEQ
     *
     * @mbggenerated
     */
    private String menuSeq;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_menu.MENU_PARENT_ID
     *
     * @mbggenerated
     */
    private Integer menuParentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_menu.MENU_NAME
     *
     * @mbggenerated
     */
    private String menuName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_menu.MENU_ICON
     *
     * @mbggenerated
     */
    private String menuIcon;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_menu.MENU_ORDER
     *
     * @mbggenerated
     */
    private String menuOrder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_menu.IS_LEAF
     *
     * @mbggenerated
     */
    private String isLeaf;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_menu.ID
     *
     * @return the value of base_menu.ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_menu.ID
     *
     * @param id the value for base_menu.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_menu.MENU_URL
     *
     * @return the value of base_menu.MENU_URL
     *
     * @mbggenerated
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_menu.MENU_URL
     *
     * @param menuUrl the value for base_menu.MENU_URL
     *
     * @mbggenerated
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_menu.MENU_SEQ
     *
     * @return the value of base_menu.MENU_SEQ
     *
     * @mbggenerated
     */
    public String getMenuSeq() {
        return menuSeq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_menu.MENU_SEQ
     *
     * @param menuSeq the value for base_menu.MENU_SEQ
     *
     * @mbggenerated
     */
    public void setMenuSeq(String menuSeq) {
        this.menuSeq = menuSeq == null ? null : menuSeq.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_menu.MENU_PARENT_ID
     *
     * @return the value of base_menu.MENU_PARENT_ID
     *
     * @mbggenerated
     */
    public Integer getMenuParentId() {
        return menuParentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_menu.MENU_PARENT_ID
     *
     * @param menuParentId the value for base_menu.MENU_PARENT_ID
     *
     * @mbggenerated
     */
    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_menu.MENU_NAME
     *
     * @return the value of base_menu.MENU_NAME
     *
     * @mbggenerated
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_menu.MENU_NAME
     *
     * @param menuName the value for base_menu.MENU_NAME
     *
     * @mbggenerated
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_menu.MENU_ICON
     *
     * @return the value of base_menu.MENU_ICON
     *
     * @mbggenerated
     */
    public String getMenuIcon() {
        return menuIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_menu.MENU_ICON
     *
     * @param menuIcon the value for base_menu.MENU_ICON
     *
     * @mbggenerated
     */
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_menu.MENU_ORDER
     *
     * @return the value of base_menu.MENU_ORDER
     *
     * @mbggenerated
     */
    public String getMenuOrder() {
        return menuOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_menu.MENU_ORDER
     *
     * @param menuOrder the value for base_menu.MENU_ORDER
     *
     * @mbggenerated
     */
    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder == null ? null : menuOrder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_menu.IS_LEAF
     *
     * @return the value of base_menu.IS_LEAF
     *
     * @mbggenerated
     */
    public String getIsLeaf() {
        return isLeaf;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_menu.IS_LEAF
     *
     * @param isLeaf the value for base_menu.IS_LEAF
     *
     * @mbggenerated
     */
    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf == null ? null : isLeaf.trim();
    }
}