package com.yunos.killproject.service.model;

import java.math.BigDecimal;

/**
 * 车型模型(长安汽车小程序)
 *
 * @Author: Qin HaiJiang
 * @Date: 2019/3/28 10:24
 */
public class CarModel {

    /* 车型id */
    private Integer id;
    /* 车型名称 */
    private String carName;
    /* 官方指导价最低价 */
    private BigDecimal minPrice;
    /* 官方指导价最高价 */
    private BigDecimal maxPrice;
    /* 车型封面图 */
    private String carImgUrl;
    /* 车型的长度 */
    private Integer carLength;
    /* 车型的宽度 */
    private Integer carWidth;
    /* 车型的高度 */
    private Integer carHeight;
    /* 轴距 */
    private Integer carWheelbase;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getCarImgUrl() {
        return carImgUrl;
    }

    public void setCarImgUrl(String carImgUrl) {
        this.carImgUrl = carImgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarLength() {
        return carLength;
    }

    public void setCarLength(Integer carLength) {
        this.carLength = carLength;
    }

    public Integer getCarWidth() {
        return carWidth;
    }

    public void setCarWidth(Integer carWidth) {
        this.carWidth = carWidth;
    }

    public Integer getCarHeight() {
        return carHeight;
    }

    public void setCarHeight(Integer carHeight) {
        this.carHeight = carHeight;
    }

    public Integer getCarWheelbase() {
        return carWheelbase;
    }

    public void setCarWheelbase(Integer carWheelbase) {
        this.carWheelbase = carWheelbase;
    }
}
