package com.yunos.killproject.service.model;

import java.util.List;

/**
 * 每个车型的配置模块model
 */
public class CarModuleModel {

    /* id 主键 */
    private Integer id;

    /* 车性id */
    private Integer carId;

    /* 模块名称 */
    private String title;

    /* 标题描述 */
    private String description;


    /* 3模块内容详情，主要是图片 */
    private List<CarModuleConfigModel> carDetailModels;

    /* 状态 0 有效 1失效 */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CarModuleConfigModel> getCarDetailModels() {
        return carDetailModels;
    }

    public void setCarDetailModels(List<CarModuleConfigModel> carDetailModels) {
        this.carDetailModels = carDetailModels;
    }

}
