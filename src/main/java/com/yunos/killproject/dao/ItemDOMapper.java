package com.yunos.killproject.dao;

import com.yunos.killproject.dataobject.ItemDO;

import java.util.List;

public interface ItemDOMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(ItemDO record);


    int insertSelective(ItemDO record);


    /**
     * 商品列表
     *
     * @return List<ItemDO>
     */
    List<ItemDO> listItem();

    ItemDO selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(ItemDO record);


    int updateByPrimaryKey(ItemDO record);
}