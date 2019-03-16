package com.yunos.killproject.service.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * 秒杀活动模型
 *
 * @Author: Qin HaiJiang
 * @Date: 2019/3/16 15:45
 */
public class PromoModel {
    // 主键
    private Integer id;
    //秒杀活动名称
    private String promoName;
    //秒杀商品id
    private Integer itemId;
    // 秒杀价格
    private BigDecimal promoPrice;
    //秒杀开始时间
    private DateTime startTime;


    public PromoModel(Integer id, String promoName, Integer itemId, BigDecimal promoPrice, DateTime startTime) {
        this.id = id;
        this.promoName = promoName;
        this.itemId = itemId;
        this.promoPrice = promoPrice;
        this.startTime = startTime;
    }
}
