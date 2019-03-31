package com.yunos.killproject.service;

import com.yunos.killproject.service.model.CarDetailModel;
import com.yunos.killproject.service.model.CarModel;
import com.yunos.killproject.service.model.CarModuleModel;

import java.util.List;

/**
 * 车型service
 *
 * @Author: Qin HaiJiang
 * @Date: 2019/3/28 10:30
 */
public interface CarService {

    /**
     * 获取车型list
     *
     * @return List<CarModel>
     */
    List<CarModel> listCar();

    /**
     * 根据车型获取车型的详细信息
     *
     * @param carId 车型id
     * @return List<CarModuleModel>
     */
    CarDetailModel getCarDetailById(Integer carId);
}
