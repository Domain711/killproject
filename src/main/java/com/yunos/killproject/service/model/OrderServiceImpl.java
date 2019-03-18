package com.yunos.killproject.service.model;

import com.yunos.killproject.dao.OrderDoMapper;
import com.yunos.killproject.dao.SequenceDoMapper;
import com.yunos.killproject.dataobject.OrderInfoDo;
import com.yunos.killproject.dataobject.SequenceDo;
import com.yunos.killproject.error.BusinessException;
import com.yunos.killproject.error.EmBusinessError;
import com.yunos.killproject.service.ItemService;
import com.yunos.killproject.service.OrderService;
import com.yunos.killproject.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @Author: Qin HaiJiang
 * @Date: 2019/3/14 16:52
 */
@Service
public class OrderServiceImpl implements OrderService {


    private final ItemService itemService;

    private final UserService userService;

    private final OrderDoMapper orderDoMapper;
    private final SequenceDoMapper sequenceDoMapper;

    @Autowired
    public OrderServiceImpl(ItemService itemService, UserService userService, OrderDoMapper orderDoMapper, SequenceDoMapper sequenceDoMapper) {
        this.itemService = itemService;
        this.userService = userService;
        this.orderDoMapper = orderDoMapper;
        this.sequenceDoMapper = sequenceDoMapper;
    }


    @Override
    @Transactional
    public OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer itemAmount) throws BusinessException {
        //1 校验订单状态 ，校验用户是否存在，校验商品是否存在，校验数量是否合法
        UserModel user = userService.getUserById(userId);
        if (null == user) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "用户信息不存在");
        }

        ItemModel item = itemService.getItemById(itemId);
        if (null == item) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "商品信息不存在");
        }
        if (0 > itemAmount || 150 < itemAmount) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "数量信息不合法");
        }
        //校验秒杀活动信息
        if (null != promoId) {
            // 校验是否适用于当前商品
            if (promoId != item.getPromoModel().getId()) {
                throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "商品秒杀的活动信息不存在");
            } else if (item.getPromoModel().getStatus().intValue() != 2) {
                throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "商品秒杀的活动尚未开始");
            }
        }

        //2 下单减库存
        boolean result = itemService.decreaseStock(itemId, itemAmount);
        if (!result) {
            throw new BusinessException(EmBusinessError.STOCK_ERROR, "库存不足");
        }

        //3 订单入库
        OrderModel order = new OrderModel();
        order.setUserId(userId);
        order.setItemId(itemId);
        if (null != promoId) {//存在秒杀活动，去秒杀价格
            order.setItemPrice(item.getPromoModel().getPromoPrice());
        } else {
            order.setItemPrice(item.getPrice());
        }
        order.setAmount(itemAmount);
        order.setPromoId(promoId);
        order.setOrderAmount(order.getItemPrice().multiply(new BigDecimal(itemAmount)));

        //model - dataobject
        //生成交易流水号
        order.setId(generatorOrderNo());
        OrderInfoDo orderDo = convertOderDoFromOrderModel(order);
        orderDoMapper.insertSelective(orderDo);

        //商品销量增加
        itemService.increaseSales(itemId, itemAmount);

        //4 前端反馈
        return order;
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf(format);
    }


    /**
     * 序列要保证唯一性，所以不管订单生成成功或者失败，序列生成后，事务必须提交掉
     *
     * @return String
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    String generatorOrderNo() {
        StringBuilder stringBuilder = new StringBuilder();
        //订单号规则  共16位  前8位为时间信息 年月日
        LocalDateTime now = LocalDateTime.now();
        String nowDate = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        stringBuilder.append(nowDate);


        // 中间6位为自增序列
        SequenceDo sequenceDo = sequenceDoMapper.selectByName("order_info");
        Integer sequence = sequenceDo.getCurrentValue();
        sequenceDo.setCurrentValue(sequence + sequenceDo.getStep());
        //更新序列
        sequenceDoMapper.updateByPrimaryKeySelective(sequenceDo);

        String sequenceStr = String.valueOf(sequence);

        //中间缺的位数补0
        for (int i = 0; i < 6 - sequenceStr.length(); i++) {
            stringBuilder.append(0);
        }
        stringBuilder.append(sequenceStr);

        // 最后2位为分库分表位
        stringBuilder.append("00");

        return stringBuilder.toString();
    }

    @Override
    public List<OrderModel> listOrder() {
        return null;
    }

    private OrderInfoDo convertOderDoFromOrderModel(OrderModel orderModel) {
        if (null == orderModel) {
            return null;
        }
        OrderInfoDo orderDo = new OrderInfoDo();
        BeanUtils.copyProperties(orderModel, orderDo);
        orderDo.setItemPrice(orderModel.getItemPrice().doubleValue());
        orderDo.setOrderAmount(orderModel.getOrderAmount().doubleValue());

        return orderDo;
    }
}
