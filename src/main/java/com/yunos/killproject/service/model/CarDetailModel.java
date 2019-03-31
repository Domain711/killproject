package com.yunos.killproject.service.model;

import java.util.List;

/**
 * 汽车详情信息Model
 */
public class CarDetailModel {

    /* 1 封面部分 */
    private CarModuleModel covers;

    /* 2 车型总体部分 */
    private CarModuleModel carDetailWholes;

    /* 3模块内容详情，主要是图片 */
    private List<CarModuleModel> carDetailModels;


    public List<CarModuleModel> getCarDetailModels() {
        return carDetailModels;
    }

    public void setCarDetailModels(List<CarModuleModel> carDetailModels) {
        this.carDetailModels = carDetailModels;
    }

    public CarModuleModel getCovers() {
        return covers;
    }

    public void setCovers(CarModuleModel covers) {
        this.covers = covers;
    }

    public CarModuleModel getCarDetailWholes() {
        return carDetailWholes;
    }

    public void setCarDetailWholes(CarModuleModel carDetailWholes) {
        this.carDetailWholes = carDetailWholes;
    }
}
