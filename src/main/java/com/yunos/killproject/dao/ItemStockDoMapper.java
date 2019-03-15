package com.yunos.killproject.dao;

import com.yunos.killproject.dataobject.ItemStockDo;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 减库存
     *
     * @param itemId 商品id
     * @param amount 商品数量
     * @return int
     */
    int decreaseStock(@Param("itemId") Integer itemId, @Param("amount") Integer amount);


    int updateByPrimaryKeySelective(ItemStockDo record);


    int updateByPrimaryKey(ItemStockDo record);
}