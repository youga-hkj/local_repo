package com.project.po;

import java.util.Date;

public class SUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_user.user_id
     *
     * @mbg.generated Mon May 15 21:52:59 CST 2017
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_user.user_name
     *
     * @mbg.generated Mon May 15 21:52:59 CST 2017
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_user.user_birthday
     *
     * @mbg.generated Mon May 15 21:52:59 CST 2017
     */
    private Date userBirthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_user.user_salary
     *
     * @mbg.generated Mon May 15 21:52:59 CST 2017
     */
    private Double userSalary;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_user.user_id
     *
     * @return the value of s_user.user_id
     *
     * @mbg.generated Mon May 15 21:52:59 CST 2017
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_user.user_id
     *
     * @param userId the value for s_user.user_id
     *
     * @mbg.generated Mon May 15 21:52:59 CST 2017
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_user.user_name
     *
     * @return the value of s_user.user_name
     *
     * @mbg.generated Mon May 15 21:52:59 CST 2017
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_user.user_name
     *
     * @param userName the value for s_user.user_name
     *
     * @mbg.generated Mon May 15 21:52:59 CST 2017
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_user.user_birthday
     *
     * @return the value of s_user.user_birthday
     *
     * @mbg.generated Mon May 15 21:52:59 CST 2017
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_user.user_birthday
     *
     * @param userBirthday the value for s_user.user_birthday
     *
     * @mbg.generated Mon May 15 21:52:59 CST 2017
     */
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_user.user_salary
     *
     * @return the value of s_user.user_salary
     *
     * @mbg.generated Mon May 15 21:52:59 CST 2017
     */
    public Double getUserSalary() {
        return userSalary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_user.user_salary
     *
     * @param userSalary the value for s_user.user_salary
     *
     * @mbg.generated Mon May 15 21:52:59 CST 2017
     */
    public void setUserSalary(Double userSalary) {
        this.userSalary = userSalary;
    }
}