package com.yunos.killproject.service.model;

import java.math.BigDecimal;

/**
 * 订单交易模型
 *
 * @Author: Qin HaiJiang
 * @Date: 2019/3/14 15:52
 */
public class OrderModel {

    //订单id 20190314000012526
    private String id;
    //用户id
    private Integer userId;

    //商品id
    private Integer itemId;

    // 商品价格
    private BigDecimal itemPrice;

    //购买数量
    private Integer amount;

    //秒杀活动id
    private Integer promoId;

    //购买金额
    private BigDecimal orderAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }
}
