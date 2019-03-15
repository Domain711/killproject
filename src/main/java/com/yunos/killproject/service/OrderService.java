package com.yunos.killproject.service;

import com.yunos.killproject.error.BusinessException;
import com.yunos.killproject.service.model.OrderModel;

import java.util.List;

/**
 * 交易订单service
 *
 * @Author: Qin HaiJiang
 * @Date: 2019/3/14 15:56
 */
public interface OrderService {

    /**
     * 创建交易订单
     *
     * @param userId     用户id
     * @param itemId     商品id
     * @param itemAmount 商品数量
     * @return orderModel
     * @throws BusinessException
     */
    OrderModel createOrder(Integer userId, Integer itemId, Integer itemAmount) throws BusinessException;

    // 查询交易订单
    List<OrderModel> listOrder();
}
