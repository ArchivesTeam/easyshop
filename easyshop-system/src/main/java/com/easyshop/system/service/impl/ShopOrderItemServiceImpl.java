package com.easyshop.system.service.impl;

import java.util.List;

import com.easyshop.system.domain.ShopOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easyshop.system.mapper.ShopOrderItemMapper;
import com.easyshop.system.domain.ShopOrderItem;
import com.easyshop.system.service.IShopOrderItemService;
import com.easyshop.common.core.text.Convert;

/**
 * 订单明细 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Service
public class ShopOrderItemServiceImpl implements IShopOrderItemService 
{
	@Autowired
	private ShopOrderItemMapper shopOrderItemMapper;

	/**
     * 查询订单明细信息
     * 
     * @param orderItemId 订单明细ID
     * @return 订单明细信息
     */
    @Override
	public ShopOrderItem selectShopOrderItemById(String orderItemId)
	{
	    return shopOrderItemMapper.selectShopOrderItemById(orderItemId);
	}
	
	/**
     * 查询订单明细列表
     * 
     * @param shopOrderItem 订单明细信息
     * @return 订单明细集合
     */
	@Override
	public List<ShopOrderItem> selectShopOrderItemList(ShopOrderItem shopOrderItem)
	{
	    return shopOrderItemMapper.selectShopOrderItemList(shopOrderItem);
	}

	@Override
	public List<ShopOrderItem> selectShopOrderItemListByOrderId(String orderId) {
		ShopOrderItem shopOrderItem = new ShopOrderItem();
		shopOrderItem.setOrderId(orderId);
		return shopOrderItemMapper.selectShopOrderItemList(shopOrderItem);
	}

	/**
     * 新增订单明细
     * 
     * @param shopOrderItem 订单明细信息
     * @return 结果
     */
	@Override
	public int insertShopOrderItem(ShopOrderItem shopOrderItem)
	{
	    return shopOrderItemMapper.insertShopOrderItem(shopOrderItem);
	}
	
	/**
     * 修改订单明细
     * 
     * @param shopOrderItem 订单明细信息
     * @return 结果
     */
	@Override
	public int updateShopOrderItem(ShopOrderItem shopOrderItem)
	{
	    return shopOrderItemMapper.updateShopOrderItem(shopOrderItem);
	}

	/**
     * 删除订单明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteShopOrderItemByIds(String ids)
	{
		return shopOrderItemMapper.deleteShopOrderItemByIds(Convert.toStrArray(ids));
	}
	
}
