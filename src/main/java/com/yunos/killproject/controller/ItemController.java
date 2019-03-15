package com.yunos.killproject.controller;

import com.yunos.killproject.controller.viewobject.ItemVo;
import com.yunos.killproject.error.BusinessException;
import com.yunos.killproject.response.CommonReturnType;
import com.yunos.killproject.service.ItemService;
import com.yunos.killproject.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品controller
 *
 * @author Qin HaiJiang
 * @date 2019/3/13 9:53
 */
@Controller("item")
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ItemController extends BaseController {

    private final ItemService itemService;


    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    /**
     * 商品列表
     *
     * @return CommonReturnType
     */
    @RequestMapping(value = "/listItem", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType listItem() {
        List<ItemModel> listItemModel = itemService.listItem();
        //model -vo
        List<ItemVo> itemVoList = listItemModel.stream().map(this::convertItemVoFromItemModel).collect(Collectors.toList());
        return CommonReturnType.create(itemVoList);
    }

    /**
     * 创建商品
     *
     * @param title       商品名称
     * @param price       商品价格
     * @param stock       商品库存
     * @param description 商品描述
     * @param imgUrl      商品图片
     * @return CommonReturnType
     */
    @RequestMapping(value = "/createItem", method = RequestMethod.POST, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType createItem(@RequestParam(name = "title") String title,
                                       @RequestParam(name = "price") BigDecimal price,
                                       @RequestParam(name = "stock") Integer stock,
                                       @RequestParam(name = "description") String description,
                                       @RequestParam(name = "imgUrl") String imgUrl
    ) throws BusinessException {
        ItemModel itemModel = new ItemModel();
        itemModel.setPrice(price);
        itemModel.setStock(stock);
        itemModel.setDescription(description);
        itemModel.setTitle(title);
        itemModel.setImgUrl(imgUrl);
        ItemModel item = itemService.createItem(itemModel);

        //itemmodel - > vo
        ItemVo itemVo = convertItemVoFromItemModel(item);
        return CommonReturnType.create(itemVo);
    }


    /**
     * 获取商品详情
     *
     * @param id 商品id
     * @return CommonReturnType
     */
    @RequestMapping(value = "/getItem", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getItem(@RequestParam(name = "id") Integer id) {
        ItemModel item = itemService.getItemById(id);
        ItemVo itemVo = convertItemVoFromItemModel(item);
        return CommonReturnType.create(itemVo);
    }

    private ItemVo convertItemVoFromItemModel(ItemModel itemModel) {

        if (null == itemModel) {
            return null;
        }
        ItemVo itemVo = new ItemVo();
        BeanUtils.copyProperties(itemModel, itemVo);
        return itemVo;
    }
}
