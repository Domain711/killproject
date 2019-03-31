package com.yunos.killproject.controller;

import com.yunos.killproject.response.CommonReturnType;
import com.yunos.killproject.service.CarService;
import com.yunos.killproject.service.model.CarDetailModel;
import com.yunos.killproject.service.model.CarModel;
import com.yunos.killproject.service.model.CarModuleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Qin HaiJiang
 * @Date: 2019/3/28 10:23
 */
@Controller("car")
@RequestMapping("/car")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class CarController extends BaseController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    /**
     * 取车型list
     *
     * @return commonReturnType
     */
    @RequestMapping("/listCar")
    @ResponseBody
    public CommonReturnType listCar() {
        List<CarModel> list = carService.listCar();
        return CommonReturnType.create(list);
    }

    /**
     * 获取车型详情
     *
     * @return commonReturnType
     */
    @RequestMapping("/getCarDetailById")
    @ResponseBody
    public CommonReturnType getCarDetailById(@RequestParam(name = "carId") Integer carId) {
        CarDetailModel carDetailList = carService.getCarDetailById(carId);
        return CommonReturnType.create(carDetailList);
    }
}
