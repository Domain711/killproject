package com.yunos.killproject.dao;

import com.yunos.killproject.dataobject.ItemStockDo;

public interface ItemStockDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Mar 13 09:04:02 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Mar 13 09:04:02 CST 2019
     */
    int insert(ItemStockDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Mar 13 09:04:02 CST 2019
     */
    int insertSelective(ItemStockDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Mar 13 09:04:02 CST 2019
     */
    ItemStockDo selectByPrimaryKey(Integer id);

    /**
     * 根据商品id查询到库存信息
     * @param itemId
     * @return
     */
    ItemStockDo selectByItemId(Integer itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Mar 13 09:04:02 CST 2019
     */
    int updateByPrimaryKeySelective(ItemStockDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbg.generated Wed Mar 13 09:04:02 CST 2019
     */
    int updateByPrimaryKey(ItemStockDo record);
}