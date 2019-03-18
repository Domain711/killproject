package com.yunos.killproject.service.impl;

import com.yunos.killproject.dao.PromoDoMapper;
import com.yunos.killproject.dataobject.PromoDo;
import com.yunos.killproject.service.PromoService;
import com.yunos.killproject.service.model.PromoModel;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: Qin HaiJiang
 * @Date: 2019/3/18 9:02
 */
@Service
public class PromoServiceImpl implements PromoService {
    private final PromoDoMapper promoDoMapper;

    @Autowired
    public PromoServiceImpl(PromoDoMapper promoDoMapper) {
        this.promoDoMapper = promoDoMapper;
    }

    @Override
    public PromoModel getPromoByItemId(Integer itemId) {
        //获取秒杀活动信息
        PromoDo promoDo = promoDoMapper.selectByItemId(itemId);

        //dataobject -> model
        PromoModel promoModel = converPromoModelFromPromoDo(promoDo);
        if (null == promoModel) {
            return null;
        }

        //判断当前时间是否在秒杀活动时间内或即将开始
        if (promoModel.getStartTime().isAfterNow()) {
            //秒杀活动还未开始
            promoModel.setStatus(1);
        } else if (promoModel.getEndTime().isBeforeNow()) {
            //秒杀活动已结束
            promoModel.setStatus(3);
        } else {
            //秒杀活动进行中
            promoModel.setStatus(2);
        }
        return promoModel;
    }

    private PromoModel converPromoModelFromPromoDo(PromoDo promoDo) {
        if (null == promoDo) {
            return null;
        }
        PromoModel promoModel = new PromoModel();
        BeanUtils.copyProperties(promoDo, promoModel);
        promoModel.setPromoPrice(new BigDecimal(promoDo.getPromoPrice()));
        promoModel.setStartTime(new DateTime(promoDo.getStartTime()));
        promoModel.setEndTime(new DateTime(promoDo.getEndTime()));

        return promoModel;

    }
}
