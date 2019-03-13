package com.yunos.killproject.service.impl;

import com.yunos.killproject.dao.ItemDOMapper;
import com.yunos.killproject.dao.ItemStockDoMapper;
import com.yunos.killproject.dataobject.ItemDO;
import com.yunos.killproject.dataobject.ItemStockDo;
import com.yunos.killproject.error.BusinessException;
import com.yunos.killproject.error.EmBusinessError;
import com.yunos.killproject.service.ItemService;
import com.yunos.killproject.service.model.ItemModel;
import com.yunos.killproject.validation.ValidationResult;
import com.yunos.killproject.validation.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @auth Qin HaiJiang
 * @date 2019/3/13 9:12
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ValidatorImpl validator;

    @Autowired
    private ItemDOMapper itemDOMapper;

    @Autowired
    private ItemStockDoMapper itemStockDoMapper;


    private ItemDO convertItemDoFromItemModel(ItemModel itemModel) {
        if (null == itemModel) {
            return null;
        }
        ItemDO itemDO = new ItemDO();
        BeanUtils.copyProperties(itemModel, itemDO);
        itemDO.setPrice(itemModel.getPrice().doubleValue());
        return itemDO;
    }

    private ItemStockDo convertItemStockDoFromItemModel(ItemModel itemModel) {
        if (null == itemModel) {
            return null;
        }
        ItemStockDo itemStockDo = new ItemStockDo();
        itemStockDo.setItemId(itemModel.getId());
        itemStockDo.setStock(itemModel.getStock());
        return itemStockDo;
    }

    @Override
    @Transactional
    public ItemModel createItem(ItemModel itemModel) throws BusinessException {
        //校验数据合法性
        ValidationResult result = validator.validate(itemModel);
        if (result.isHasError()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, result.getErrMsg());
        }
        //model ->dataobject
        ItemDO itemDO = convertItemDoFromItemModel(itemModel);
        //入库
        itemDOMapper.insertSelective(itemDO);

        itemModel.setId(itemDO.getId());

        ItemStockDo itemStockDo = convertItemStockDoFromItemModel(itemModel);
        itemStockDoMapper.insertSelective(itemStockDo);

        //返回转化后的实体
        return this.getItemById(itemDO.getId());
    }

    @Override
    public List<ItemModel> listItem() {
        return null;
    }

    @Override
    public ItemModel getItemById(Integer id) {

        //根据商品id获取商品do
        ItemDO itemDO = itemDOMapper.selectByPrimaryKey(id);
        if (null == itemDO) {
            return null;
        }
        //获取商品的库存
        ItemStockDo itemStockDo = itemStockDoMapper.selectByItemId(id);

        //dataobject->itemModel
        ItemModel itemModel = convertItemModelFromDataObject(itemDO, itemStockDo);
        return itemModel;
    }

    private ItemModel convertItemModelFromDataObject(ItemDO itemDO, ItemStockDo itemStockDo) {
        if (null == itemDO) {
            return null;
        }
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(itemDO, itemModel);
        itemModel.setPrice(new BigDecimal(itemDO.getPrice()));
        itemModel.setStock(itemStockDo.getStock());
        return itemModel;
    }
}
