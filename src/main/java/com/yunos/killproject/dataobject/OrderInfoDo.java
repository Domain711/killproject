package com.yunos.killproject.dataobject;

/**
 * 订单dataobject
 */
public class OrderInfoDo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.id
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.user_id
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.item_id
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    private Integer itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.item_price
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    private Double itemPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.amount
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    private Integer amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.order_amount
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    private Double orderAmount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.id
     *
     * @return the value of order.id
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.id
     *
     * @param id the value for order.id
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.user_id
     *
     * @return the value of order.user_id
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.user_id
     *
     * @param userId the value for order.user_id
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.item_id
     *
     * @return the value of order.item_id
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.item_id
     *
     * @param itemId the value for order.item_id
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.item_price
     *
     * @return the value of order.item_price
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    public Double getItemPrice() {
        return itemPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.item_price
     *
     * @param itemPrice the value for order.item_price
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.amount
     *
     * @return the value of order.amount
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.amount
     *
     * @param amount the value for order.amount
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.order_amount
     *
     * @return the value of order.order_amount
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    public Double getOrderAmount() {
        return orderAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.order_amount
     *
     * @param orderAmount the value for order.order_amount
     *
     * @mbg.generated Thu Mar 14 16:41:36 CST 2019
     */
    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }
}