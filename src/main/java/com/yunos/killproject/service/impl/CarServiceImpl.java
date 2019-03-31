package com.yunos.killproject.service.impl;

import com.yunos.killproject.dao.CarDoMapper;
import com.yunos.killproject.dao.CarModuleConfigDoMapper;
import com.yunos.killproject.dao.CarModuleDoMapper;
import com.yunos.killproject.dataobject.CarDo;
import com.yunos.killproject.dataobject.CarModuleConfigDo;
import com.yunos.killproject.dataobject.CarModuleDo;
import com.yunos.killproject.service.CarService;
import com.yunos.killproject.service.model.CarDetailModel;
import com.yunos.killproject.service.model.CarModel;
import com.yunos.killproject.service.model.CarModuleConfigModel;
import com.yunos.killproject.service.model.CarModuleModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Qin HaiJiang
 * @Date: 2019/3/28 10:31
 */

@Service
public class CarServiceImpl implements CarService {
    private final CarDoMapper carDoMapper;
    private final CarModuleDoMapper carModuleDoMapper;
    private final CarModuleConfigDoMapper carModuleConfigDoMapper;

    @Autowired
    public CarServiceImpl(CarDoMapper carDoMapper, CarModuleDoMapper carModuleDoMapper, CarModuleConfigDoMapper carModuleConfigDoMapper) {
        this.carDoMapper = carDoMapper;
        this.carModuleDoMapper = carModuleDoMapper;
        this.carModuleConfigDoMapper = carModuleConfigDoMapper;
    }

    @Override
    public List<CarModel> listCar() {
        return carDoMapper.listCar().stream().map(this::convertCarModelFromCarDo).collect(Collectors.toList());
    }

    @Override
    public CarDetailModel getCarDetailById(Integer carId) {
        CarDetailModel carDetailModel = new CarDetailModel();
        //获取该车型的所有模块配置并且转化成model
        List<CarModuleConfigDo> configList = carModuleConfigDoMapper.getModuleConfigByCarId(carId);

        // 获取该车型的所有模块
        List<CarModuleDo> carModuleDoList = carModuleDoMapper.getCarDetailById(carId);
        Map<Integer, List<CarModuleDo>> carModule = carModuleDoList.stream().collect(Collectors.groupingBy(CarModuleDo::getModuleType));


        // 1 获取封面
        List<CarModuleModel> cover = relatedModuleAndModuleConfig(carModule.get(0), configList);
        carDetailModel.setCovers(null != cover ? cover.get(0) : null);

        // 2 获取整体预览
        List<CarModuleModel> wholePreview = relatedModuleAndModuleConfig(carModule.get(1), configList);
        carDetailModel.setCarDetailWholes(null != wholePreview ? wholePreview.get(0) : null);

        // 3 设置模块的详情
        carDetailModel.setCarDetailModels(relatedModuleAndModuleConfig(carModule.get(2), configList));

        return carDetailModel;
    }

    /**
     * ps:为避免频繁的访问DB,并且数据量很小，所有每个车型的详情模块全部在内存中进行关联
     * 关联模块跟模块配置
     *
     * @return
     */
    private List<CarModuleModel> relatedModuleAndModuleConfig(List<CarModuleDo> module, List<CarModuleConfigDo> configList) {
        if (null == module) {
            return null;
        }
        if (null == configList) {
            return null;
        }
        List<CarModuleModel> relatedList = module.stream().map(carModuleDo -> {
            return this.converCarModuleFromCarModuleDo(carModuleDo, configList);
        }).collect(Collectors.toList());
        return relatedList;
    }

    /**
     * 车型详情的模块do->model
     *
     * @param carModuleDo 车型模块do
     * @return CarModuleModel
     */
    private CarModuleModel converCarModuleFromCarModuleDo(CarModuleDo carModuleDo, List<CarModuleConfigDo> configModelList) {
        if (null == carModuleDo) {
            return null;
        }
        CarModuleModel carModuleModel = new CarModuleModel();
        BeanUtils.copyProperties(carModuleDo, carModuleModel);
        //获取模块的模块详情
        List<CarModuleConfigDo> moduleConfig = configModelList.stream().filter(carModuleConfig -> carModuleConfig.getModuleId() == carModuleDo.getId()).collect(Collectors.toList());
        if (null != moduleConfig && !moduleConfig.isEmpty()) {
            /*  do->model */
            List<CarModuleConfigModel> configModels = moduleConfig.stream().map(this::convertCarModuleConfigModelFromCarModuleConfigDo).collect(Collectors.toList());
            /* 设置模块具体详情 */
            carModuleModel.setCarDetailModels(configModels);
        }
        return carModuleModel;
    }

    /**
     * 车型详情的模块配置 do->model
     *
     * @param carModuleConfigDo
     * @return
     */
    private CarModuleConfigModel convertCarModuleConfigModelFromCarModuleConfigDo(CarModuleConfigDo carModuleConfigDo) {
        if (null == carModuleConfigDo) {
            return null;
        }
        CarModuleConfigModel carModuleConfigModel = new CarModuleConfigModel();
        BeanUtils.copyProperties(carModuleConfigDo, carModuleConfigModel);
        return carModuleConfigModel;
    }

    /**
     * do-model
     *
     * @param carDo 车型do
     * @return CarModel
     */
    private CarModel convertCarModelFromCarDo(CarDo carDo) {
        if (null == carDo) {
            return null;
        }
        CarModel carModel = new CarModel();
        BeanUtils.copyProperties(carDo, carModel);
        carModel.setMinPrice(new BigDecimal(carDo.getMinPrice()));
        carModel.setMaxPrice(new BigDecimal(carDo.getMaxPrice()));
        return carModel;
    }
}
