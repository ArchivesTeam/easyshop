package com.easyshop.system.service;

import com.easyshop.system.domain.ShopItem;
import java.util.List;

/**
 * 消费项目 服务层
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
public interface IShopItemService 
{
	/**
     * 查询消费项目信息
     * 
     * @param itemId 消费项目ID
     * @return 消费项目信息
     */
	public ShopItem selectShopItemById(String itemId);
	
	/**
     * 查询消费项目列表
     * 
     * @param shopItem 消费项目信息
     * @return 消费项目集合
     */
	public List<ShopItem> selectShopItemList(ShopItem shopItem);
	
	/**
     * 新增消费项目
     * 
     * @param shopItem 消费项目信息
     * @return 结果
     */
	public int insertShopItem(ShopItem shopItem);
	
	/**
     * 修改消费项目
     * 
     * @param shopItem 消费项目信息
     * @return 结果
     */
	public int updateShopItem(ShopItem shopItem);
		
	/**
     * 删除消费项目信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteShopItemByIds(String ids);

}
