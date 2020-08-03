package com.liudehuang.boot.druid.entity;

import java.util.Date;

public class KanjiaRecord {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.merchant_id
     *
     * @mbggenerated
     */
    private Long merchantId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.kanjia_no
     *
     * @mbggenerated
     */
    private String kanjiaNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.type
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.amount
     *
     * @mbggenerated
     */
    private Integer amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.card_id
     *
     * @mbggenerated
     */
    private String cardId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.open_id
     *
     * @mbggenerated
     */
    private String openId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.wx_name
     *
     * @mbggenerated
     */
    private String wxName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.wx_img
     *
     * @mbggenerated
     */
    private String wxImg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.created_by
     *
     * @mbggenerated
     */
    private String createdBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.created_time
     *
     * @mbggenerated
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.updated_by
     *
     * @mbggenerated
     */
    private String updatedBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.updated_time
     *
     * @mbggenerated
     */
    private Date updatedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kanjia_record.deleted
     *
     * @mbggenerated
     */
    private Integer deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.id
     *
     * @return the value of kanjia_record.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.id
     *
     * @param id the value for kanjia_record.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.merchant_id
     *
     * @return the value of kanjia_record.merchant_id
     *
     * @mbggenerated
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.merchant_id
     *
     * @param merchantId the value for kanjia_record.merchant_id
     *
     * @mbggenerated
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.kanjia_no
     *
     * @return the value of kanjia_record.kanjia_no
     *
     * @mbggenerated
     */
    public String getKanjiaNo() {
        return kanjiaNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.kanjia_no
     *
     * @param kanjiaNo the value for kanjia_record.kanjia_no
     *
     * @mbggenerated
     */
    public void setKanjiaNo(String kanjiaNo) {
        this.kanjiaNo = kanjiaNo == null ? null : kanjiaNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.type
     *
     * @return the value of kanjia_record.type
     *
     * @mbggenerated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.type
     *
     * @param type the value for kanjia_record.type
     *
     * @mbggenerated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.amount
     *
     * @return the value of kanjia_record.amount
     *
     * @mbggenerated
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.amount
     *
     * @param amount the value for kanjia_record.amount
     *
     * @mbggenerated
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.card_id
     *
     * @return the value of kanjia_record.card_id
     *
     * @mbggenerated
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.card_id
     *
     * @param cardId the value for kanjia_record.card_id
     *
     * @mbggenerated
     */
    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.open_id
     *
     * @return the value of kanjia_record.open_id
     *
     * @mbggenerated
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.open_id
     *
     * @param openId the value for kanjia_record.open_id
     *
     * @mbggenerated
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.wx_name
     *
     * @return the value of kanjia_record.wx_name
     *
     * @mbggenerated
     */
    public String getWxName() {
        return wxName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.wx_name
     *
     * @param wxName the value for kanjia_record.wx_name
     *
     * @mbggenerated
     */
    public void setWxName(String wxName) {
        this.wxName = wxName == null ? null : wxName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.wx_img
     *
     * @return the value of kanjia_record.wx_img
     *
     * @mbggenerated
     */
    public String getWxImg() {
        return wxImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.wx_img
     *
     * @param wxImg the value for kanjia_record.wx_img
     *
     * @mbggenerated
     */
    public void setWxImg(String wxImg) {
        this.wxImg = wxImg == null ? null : wxImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.created_by
     *
     * @return the value of kanjia_record.created_by
     *
     * @mbggenerated
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.created_by
     *
     * @param createdBy the value for kanjia_record.created_by
     *
     * @mbggenerated
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.created_time
     *
     * @return the value of kanjia_record.created_time
     *
     * @mbggenerated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.created_time
     *
     * @param createdTime the value for kanjia_record.created_time
     *
     * @mbggenerated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.updated_by
     *
     * @return the value of kanjia_record.updated_by
     *
     * @mbggenerated
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.updated_by
     *
     * @param updatedBy the value for kanjia_record.updated_by
     *
     * @mbggenerated
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.updated_time
     *
     * @return the value of kanjia_record.updated_time
     *
     * @mbggenerated
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.updated_time
     *
     * @param updatedTime the value for kanjia_record.updated_time
     *
     * @mbggenerated
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.remark
     *
     * @return the value of kanjia_record.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.remark
     *
     * @param remark the value for kanjia_record.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kanjia_record.deleted
     *
     * @return the value of kanjia_record.deleted
     *
     * @mbggenerated
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kanjia_record.deleted
     *
     * @param deleted the value for kanjia_record.deleted
     *
     * @mbggenerated
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}