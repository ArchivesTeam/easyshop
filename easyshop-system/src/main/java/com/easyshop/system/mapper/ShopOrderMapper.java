package com.easyshop.system.mapper;

import com.easyshop.system.domain.ShopOrder;
import java.util.List;	

/**
 * 订单 数据层
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
public interface ShopOrderMapper 
{
	/**
     * 查询订单信息
     * 
     * @param orderId 订单ID
     * @return 订单信息
     */
	public ShopOrder selectShopOrderById(String orderId);
	
	/**
     * 查询订单列表
     * 
     * @param shopOrder 订单信息
     * @return 订单集合
     */
	public List<ShopOrder> selectShopOrderList(ShopOrder shopOrder);
	
	/**
     * 新增订单
     * 
     * @param shopOrder 订单信息
     * @return 结果
     */
	public int insertShopOrder(ShopOrder shopOrder);
	
	/**
     * 修改订单
     * 
     * @param shopOrder 订单信息
     * @return 结果
     */
	public int updateShopOrder(ShopOrder shopOrder);
	
	/**
     * 删除订单
     * 
     * @param orderId 订单ID
     * @return 结果
     */
	public int deleteShopOrderById(String orderId);
	
	/**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteShopOrderByIds(String[] orderIds);
	
}