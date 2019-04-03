package com.ruoyi.system.service;

import com.ruoyi.system.domain.ShopOrderItem;
import java.util.List;

/**
 * 订单明细 服务层
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
public interface IShopOrderItemService 
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
     * 删除订单明细信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteShopOrderItemByIds(String ids);
	
}
