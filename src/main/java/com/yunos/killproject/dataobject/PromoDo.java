package com.yunos.killproject.dataobject;

import java.util.Date;

public class PromoDo {

    private Integer id;


    private String promoName;


    private Date startTime;

    /**
     * 秒杀结束时间
     */
    private Date endTime;


    private Integer itemId;


    private Double promoPrice;


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
        this.promoName = promoName == null ? null : promoName.trim();
    }


    public Date getStartTime() {
        return startTime;
    }


    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }


    public Integer getItemId() {
        return itemId;
    }


    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }


    public Double getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(Double promoPrice) {
        this.promoPrice = promoPrice;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}