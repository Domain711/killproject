package com.yunos.killproject.dao;

import com.yunos.killproject.dataobject.ItemDO;
import com.yunos.killproject.service.model.ItemModel;

import java.util.List;

public interface ItemDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Wed Mar 13 09:04:02 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Wed Mar 13 09:04:02 CST 2019
     */
    int insert(ItemDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Wed Mar 13 09:04:02 CST 2019
     */
    int insertSelective(ItemDO record);


    /**
     * 商品列表
     * @return
     */
    List<ItemDO> listItem();
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Wed Mar 13 09:04:02 CST 2019
     */
    ItemDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Wed Mar 13 09:04:02 CST 2019
     */
    int updateByPrimaryKeySelective(ItemDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item
     *
     * @mbg.generated Wed Mar 13 09:04:02 CST 2019
     */
    int updateByPrimaryKey(ItemDO record);
}