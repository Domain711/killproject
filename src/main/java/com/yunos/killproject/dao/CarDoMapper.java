package com.yunos.killproject.dao;

import com.yunos.killproject.dataobject.CarDo;
import com.yunos.killproject.dataobject.CarModuleDo;
import com.yunos.killproject.service.model.CarModuleModel;

import java.util.List;

/**
 * 车型dao
 */
public interface CarDoMapper {


    /**
     * 获取车型信息
     * @return List<CarDo>
     */
    List<CarDo> listCar();



    int deleteByPrimaryKey(Integer id);

    int insert(CarDo record);

    int insertSelective(CarDo record);

    CarDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarDo record);

    int updateByPrimaryKey(CarDo record);
}