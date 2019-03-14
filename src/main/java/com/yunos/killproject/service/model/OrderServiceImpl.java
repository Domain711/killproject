package com.yunos.killproject.service.model;

import com.yunos.killproject.service.ItemService;
import com.yunos.killproject.service.OrderService;
import com.yunos.killproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Qin HaiJiang
 * @Date: 2019/3/14 16:52
 */
@Service
public class OrderServiceImpl implements OrderService {


    private final ItemService itemService;

    private final UserService userService;

    @Autowired
    public OrderServiceImpl(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;
    }


    @Override
    @Transactional
    public OrderModel createOrder(OrderModel orderModel) {
        //1 校验订单状态 ，校验用户是否存在，校验商品是否存在，校验数量是否合法


        //2 下单减库存


        //3 订单入库


        //4 前端反馈

        return null;
    }

    @Override
    public List<OrderModel> listOrder() {
        return null;
    }
}
