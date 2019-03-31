package com.yunos.killproject.dataobject;

/**
 * 每款车型的模块do
 */
public class CarModuleDo {

    /* id主键 */
    private Integer id;

    /* 车型id */
    private Integer carId;

    /* 模块标题 */
    private String title;

    /* 模块标题描述 */
    private String description;

    /* 模块状态 */
    private Integer status;
    /* 模块类型 0 封面 1 整体预览 2 模块的具体配置 */
    private Integer moduleType;


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

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getModuleType() {
        return moduleType;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }
}