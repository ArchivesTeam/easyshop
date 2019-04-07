package com.ruoyi.framework.web.service;

import com.ruoyi.system.service.IShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author majingyuan
 * @Date Create in 2019/4/6 21:30
 */
@Service("shopItem")
public class ShopItemService {
    @Autowired
    private IShopItemService shopItemService;


    public String getLabel(String itemId)
    {
        return shopItemService.selectShopItemById(itemId).getItemName();
    }
}
