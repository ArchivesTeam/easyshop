package com.easyshop.system.mapper;

import com.easyshop.system.domain.ShopOrderItem;
import java.util.List;	

/**
 * 订单明细 数据层
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
public interface ShopOrderItemMapper 
{
	/**
     * 查询订单明细信息
     * 
     * @param orderItemId 订单明细ID
     * @return 订单明细信息
     */
	public ShopOrderItem selectShopOrderItemById(String orderItemId);
	
	/**
     * 查询订单明细列表
     * 
     * @param shopOrderItem 订单明细信息
     * @return 订单明细集合
     */
	public List<ShopOrderItem> selectShopOrderItemList(ShopOrderItem shopOrderItem);
	
	/**
     * 新增订单明细
     * 
     * @param shopOrderItem 订单明细信息
     * @return 结果
     */
	public int insertShopOrderItem(ShopOrderItem shopOrderItem);
	
	/**
     * 修改订单明细
     * 
     * @param shopOrderItem 订单明细信息
     * @return 结果
     */
	public int updateShopOrderItem(ShopOrderItem shopOrderItem);
	
	/**
     * 删除订单明细
     * 
     * @param orderItemId 订单明细ID
     * @return 结果
     */
	public int deleteShopOrderItemById(String orderItemId);
	
	/**
     * 批量删除订单明细
     * 
     * @param orderItemIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteShopOrderItemByIds(String[] orderItemIds);

	public int deleteShopOrderItemByOrderId(String orderId);

}