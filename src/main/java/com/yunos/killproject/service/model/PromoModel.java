package com.yunos.killproject.service.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * 秒杀活动模型
 *
 * @Author: Qin HaiJiang
 * @Date: 2019/3/16 15:45
 */
public class PromoModel {
    // 主键
    private Integer id;

    //秒杀活动状态 1 未开始 2进行中 3结束
    private Integer status;

    //秒杀活动名称
    private String promoName;

    //秒杀商品id
    private Integer itemId;

    // 秒杀价格
    private BigDecimal promoPrice;

    //秒杀开始时间
    private DateTime startTime;

    // 秒杀结束时间
    private DateTime endTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(BigDecimal promoPrice) {
        this.promoPrice = promoPrice;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
