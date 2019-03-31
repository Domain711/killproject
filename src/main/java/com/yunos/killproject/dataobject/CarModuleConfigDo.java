package com.yunos.killproject.dataobject;

/**
 * 车型模块的具体配置
 */
public class CarModuleConfigDo {

    private Integer id;
    /*车型id*/
    private Integer carId;
    /*模块id*/
    private Integer moduleId;
    /*图片地址*/
    private String imgUrl;
    /*状态 0 有效 1无效*/
    private Integer status;
    /*图片上的配置说明，简单的文字介绍*/
    private String description;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getCarId() {
        return carId;
    }


    public void setCarId(Integer carId) {
        this.carId = carId;
    }


    public Integer getModuleId() {
        return moduleId;
    }


    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getImgUrl() {
        return imgUrl;
    }


    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }


    public Integer getStatus() {
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}