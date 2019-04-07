package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.UUID;

import com.ruoyi.system.domain.ShopOrderItem;
import com.ruoyi.system.mapper.ShopOrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ShopOrderMapper;
import com.ruoyi.system.domain.ShopOrder;
import com.ruoyi.system.service.IShopOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 订单 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Service
public class ShopOrderServiceImpl implements IShopOrderService 
{
	@Autowired
	private ShopOrderMapper shopOrderMapper;

	@Autowired
	private ShopOrderItemMapper shopOrderItemMapper;

	/**
     * 查询订单信息
     * 
     * @param orderId 订单ID
     * @return 订单信息
     */
    @Override
	public ShopOrder selectShopOrderById(String orderId)
	{
	    return shopOrderMapper.selectShopOrderById(orderId);
	}
	
	/**
     * 查询订单列表
     * 
     * @param shopOrder 订单信息
     * @return 订单集合
     */
	@Override
	public List<ShopOrder> selectShopOrderList(ShopOrder shopOrder)
	{
	    return shopOrderMapper.selectShopOrderList(shopOrder);
	}
	
    /**
     * 新增订单
     * 
     * @param shopOrder 订单信息
     * @return 结果
     */
	@Override
	public int insertShopOrder(ShopOrder shopOrder)
	{
		if (shopOrderMapper.insertShopOrder(shopOrder) > 0){
			insertOrderItem(shopOrder);
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
     * 修改订单
     * 
     * @param shopOrder 订单信息
     * @return 结果
     */
	@Override
	public int updateShopOrder(ShopOrder shopOrder)
	{
		shopOrderItemMapper.deleteShopOrderItemByOrderId(shopOrder.getOrderId());
		insertOrderItem(shopOrder);
		return shopOrderMapper.updateShopOrder(shopOrder);
	}

	/**
     * 删除订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteShopOrderByIds(String ids)
	{
		return shopOrderMapper.deleteShopOrderByIds(Convert.toStrArray(ids));
	}

	/**
	 * 写入订单明细
	 * @param shopOrder
	 */
	private void insertOrderItem(ShopOrder shopOrder){
		for (ShopOrderItem item : shopOrder.getShopOrderItems()){
			item.setOrderItemId(UUID.randomUUID().toString());
			item.setOrderId(shopOrder.getOrderId());
			item.setCreateBy(shopOrder.getCreateBy());
			shopOrderItemMapper.insertShopOrderItem(item);
		}
	}
}
