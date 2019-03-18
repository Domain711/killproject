package com.yunos.killproject.service.impl;

import com.yunos.killproject.dao.ItemDOMapper;
import com.yunos.killproject.dao.ItemStockDoMapper;
import com.yunos.killproject.dao.PromoDoMapper;
import com.yunos.killproject.dataobject.ItemDO;
import com.yunos.killproject.dataobject.ItemStockDo;
import com.yunos.killproject.dataobject.PromoDo;
import com.yunos.killproject.error.BusinessException;
import com.yunos.killproject.error.EmBusinessError;
import com.yunos.killproject.service.ItemService;
import com.yunos.killproject.service.PromoService;
import com.yunos.killproject.service.model.ItemModel;
import com.yunos.killproject.service.model.PromoModel;
import com.yunos.killproject.validation.ValidationResult;
import com.yunos.killproject.validation.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Qin HaiJiang
 * @date 2019/3/13 9:12
 */
@Service
public class ItemServiceImpl implements ItemService {
    private final ValidatorImpl validator;

    private final ItemDOMapper itemDOMapper;

    private final ItemStockDoMapper itemStockDoMapper;


    private final PromoService promoService;


    @Autowired
    public ItemServiceImpl(ValidatorImpl validator, ItemDOMapper itemDOMapper, ItemStockDoMapper itemStockDoMapper, PromoService promoService) {
        this.validator = validator;
        this.itemDOMapper = itemDOMapper;
        this.itemStockDoMapper = itemStockDoMapper;
        this.promoService = promoService;
    }


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
        List<ItemDO> listItem = itemDOMapper.listItem();
        return listItem.stream().map(itemDO -> {
            ItemStockDo itemStockDo = itemStockDoMapper.selectByItemId(itemDO.getId());
            return this.convertItemModelFromDataObject(itemDO, itemStockDo);

        }).collect(Collectors.toList());
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

        //获取秒杀信息
        PromoModel promoModel = promoService.getPromoByItemId(id);
        if (null != promoModel && 3 != promoModel.getStatus().intValue()) {
            //获取配置了秒杀信息，并且秒杀活动还未结束的商品信息
            itemModel.setPromoModel(promoModel);
        }

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

    @Override
    @Transactional
    public boolean decreaseStock(Integer itemId, Integer itemAmount) {
        int affectRow = itemStockDoMapper.decreaseStock(itemId, itemAmount);
        if (0 < affectRow) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void increaseSales(Integer itemId, Integer amount) {
        itemDOMapper.increaseSales(itemId, amount);
    }
}
