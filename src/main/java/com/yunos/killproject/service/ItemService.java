package com.yunos.killproject.service;

import com.yunos.killproject.error.BusinessException;
import com.yunos.killproject.service.model.ItemModel;

import java.util.List;

/**
 * 商品service
 *
 * @auth Qin HaiJiang
 * @date 2019/3/13 9:08
 */
public interface ItemService {

    //创建商品
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    //商品列表
    List<ItemModel> listItem();

    //商品详情
    ItemModel getItemById(Integer id);

    // 库存扣减
    boolean decreaseStock(Integer itemId,Integer itemAmount);
}
