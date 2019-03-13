package com.yunos.killproject.dao;

import com.yunos.killproject.dataobject.ItemStockDo;

public interface ItemStockDoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ItemStockDo record);

    int insertSelective(ItemStockDo record);

    ItemStockDo selectByPrimaryKey(Integer id);

    /**
     * 根据商品id查询到库存信息
     *
     * @param itemId 商品id
     * @return ItemStockDo
     */
    ItemStockDo selectByItemId(Integer itemId);


    int updateByPrimaryKeySelective(ItemStockDo record);


    int updateByPrimaryKey(ItemStockDo record);
}