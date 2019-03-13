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

/**
 * 商品controller
 *
 * @auth Qin HaiJiang
 * @date 2019/3/13 9:53
 */
@Controller("item")
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ItemController extends BaseController {
    @Autowired
    private ItemService itemService;


    /**
     * 创建商品
     *
     * @param title
     * @param price
     * @param stock
     * @param description
     * @param imgUrl
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/createItem", method = RequestMethod.POST, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType createItem(@RequestParam("title") String title,
                                       @RequestParam("price") BigDecimal price,
                                       @RequestParam("stock") Integer stock,
                                       @RequestParam("description") String description,
                                       @RequestParam("imgUrl") String imgUrl
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

    private ItemVo convertItemVoFromItemModel(ItemModel itemModel) {

        if (null == itemModel) {
            return null;
        }
        ItemVo itemVo = new ItemVo();
        BeanUtils.copyProperties(itemModel, itemVo);
        return itemVo;
    }
}
