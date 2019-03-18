package com.yunos.killproject.service;

import com.yunos.killproject.service.model.PromoModel;

/**
 * 商品秒杀service接口
 * @Author: Qin HaiJiang
 * @Date: 2019/3/18 8:55
 */
public interface PromoService {

    /**
     * 根据商品id获取秒杀商品（正在秒杀或者即将秒杀的商品）
     * @param itemId
     * @return
     */
    PromoModel getPromoByItemId(Integer itemId);
}
