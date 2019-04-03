package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ShopItemMapper;
import com.ruoyi.system.domain.ShopItem;
import com.ruoyi.system.service.IShopItemService;
import com.ruoyi.common.core.text.Convert;

/**
 * 消费项目 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Service
public class ShopItemServiceImpl implements IShopItemService 
{
	@Autowired
	private ShopItemMapper shopItemMapper;

	/**
     * 查询消费项目信息
     * 
     * @param itemId 消费项目ID
     * @return 消费项目信息
     */
    @Override
	public ShopItem selectShopItemById(String itemId)
	{
	    return shopItemMapper.selectShopItemById(itemId);
	}
	
	/**
     * 查询消费项目列表
     * 
     * @param shopItem 消费项目信息
     * @return 消费项目集合
     */
	@Override
	public List<ShopItem> selectShopItemList(ShopItem shopItem)
	{
	    return shopItemMapper.selectShopItemList(shopItem);
	}
	
    /**
     * 新增消费项目
     * 
     * @param shopItem 消费项目信息
     * @return 结果
     */
	@Override
	public int insertShopItem(ShopItem shopItem)
	{
	    return shopItemMapper.insertShopItem(shopItem);
	}
	
	/**
     * 修改消费项目
     * 
     * @param shopItem 消费项目信息
     * @return 结果
     */
	@Override
	public int updateShopItem(ShopItem shopItem)
	{
	    return shopItemMapper.updateShopItem(shopItem);
	}

	/**
     * 删除消费项目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteShopItemByIds(String ids)
	{
		return shopItemMapper.deleteShopItemByIds(Convert.toStrArray(ids));
	}
	
}
