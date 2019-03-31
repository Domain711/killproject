package com.yunos.killproject.dataobject;

/**
 * 车型dataObject
 */
public class CarDo {
    // 主键
    private Integer id;
    //  车型名称
    private String carName;
    //  售价最低价
    private Double minPrice;
    //  售价最高价
    private Double maxPrice;
    //  车型封面图片地址
    private String carImgUrl;
    // 状态 0有效 1无效
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }


    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }


    public Double getMinPrice() {
        return minPrice;
    }


    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }


    public Double getMaxPrice() {
        return maxPrice;
    }


    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }


    public String getCarImgUrl() {
        return carImgUrl;
    }

    public void setCarImgUrl(String carImgUrl) {
        this.carImgUrl = carImgUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}