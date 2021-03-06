package com.project.po;

public class Item {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.id
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.item_name
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    private String itemName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.price
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    private Float price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.detail
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    private String detail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.user_id
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.id
     *
     * @return the value of item.id
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.id
     *
     * @param id the value for item.id
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.item_name
     *
     * @return the value of item.item_name
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.item_name
     *
     * @param itemName the value for item.item_name
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.price
     *
     * @return the value of item.price
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    public Float getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.price
     *
     * @param price the value for item.price
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.detail
     *
     * @return the value of item.detail
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.detail
     *
     * @param detail the value for item.detail
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.user_id
     *
     * @return the value of item.user_id
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.user_id
     *
     * @param userId the value for item.user_id
     *
     * @mbggenerated Wed Jun 07 08:54:59 CST 2017
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}