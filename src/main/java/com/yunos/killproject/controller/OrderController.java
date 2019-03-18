package com.yunos.killproject.controller;

import com.yunos.killproject.error.BusinessException;
import com.yunos.killproject.error.EmBusinessError;
import com.yunos.killproject.response.CommonReturnType;
import com.yunos.killproject.service.OrderService;
import com.yunos.killproject.service.model.OrderModel;
import com.yunos.killproject.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 交易订单conttoller
 *
 * @Author: Qin HaiJiang
 * @Date: 2019/3/15 10:34
 */
@Controller("order")
@RequestMapping("/order")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class OrderController extends BaseController {

    private final OrderService orderService;
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public OrderController(OrderService orderService, HttpServletRequest httpServletRequest) {
        this.orderService = orderService;
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * 创建订单
     *
     * @param itemId 商品id
     * @param amount 商品数量
     * @param promoId 秒杀活动id
     * @return
     */
    @RequestMapping(value = "/createOrder", method = RequestMethod.POST, consumes = CONTENT_TYPE_FORMED)
    @ResponseBody
    public CommonReturnType createOrder(@RequestParam(name = "itemId") Integer itemId, @RequestParam(name = "amount") Integer amount,
                                        @RequestParam(name="promoId")Integer promoId
    ) throws BusinessException {
        Boolean is_login = (Boolean) httpServletRequest.getSession().getAttribute("IS_LOGIN");
        if (null == is_login || !is_login) {
            throw new BusinessException(EmBusinessError.USER_NOT_LOGIN, "用户尚未登录");
        }
        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        OrderModel order = orderService.createOrder(userModel.getId(), itemId, promoId,amount);
        return CommonReturnType.create(null);
    }
}
