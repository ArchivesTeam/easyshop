package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ShopOrderItem;
import com.ruoyi.system.service.IShopOrderItemService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 订单明细 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Controller
@RequestMapping("/system/shopOrderItem")
public class ShopOrderItemController extends BaseController
{
    private String prefix = "system/shopOrderItem";
	
	@Autowired
	private IShopOrderItemService shopOrderItemService;
	
	@RequiresPermissions("system:shopOrderItem:view")
	@GetMapping()
	public String shopOrderItem()
	{
	    return prefix + "/shopOrderItem";
	}
	
	/**
	 * 查询订单明细列表
	 */
	@RequiresPermissions("system:shopOrderItem:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ShopOrderItem shopOrderItem)
	{
		startPage();
        List<ShopOrderItem> list = shopOrderItemService.selectShopOrderItemList(shopOrderItem);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出订单明细列表
	 */
	@RequiresPermissions("system:shopOrderItem:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShopOrderItem shopOrderItem)
    {
    	List<ShopOrderItem> list = shopOrderItemService.selectShopOrderItemList(shopOrderItem);
        ExcelUtil<ShopOrderItem> util = new ExcelUtil<ShopOrderItem>(ShopOrderItem.class);
        return util.exportExcel(list, "shopOrderItem");
    }
	
	/**
	 * 新增订单明细
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存订单明细
	 */
	@RequiresPermissions("system:shopOrderItem:add")
	@Log(title = "订单明细", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ShopOrderItem shopOrderItem)
	{		
		shopOrderItem.setOrderItemId(UUID.randomUUID().toString());
		return toAjax(shopOrderItemService.insertShopOrderItem(shopOrderItem));
	}

	/**
	 * 修改订单明细
	 */
	@GetMapping("/edit/{orderItemId}")
	public String edit(@PathVariable("orderItemId") String orderItemId, ModelMap mmap)
	{
		ShopOrderItem shopOrderItem = shopOrderItemService.selectShopOrderItemById(orderItemId);
		mmap.put("shopOrderItem", shopOrderItem);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单明细
	 */
	@RequiresPermissions("system:shopOrderItem:edit")
	@Log(title = "订单明细", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ShopOrderItem shopOrderItem)
	{		
		return toAjax(shopOrderItemService.updateShopOrderItem(shopOrderItem));
	}
	
	/**
	 * 删除订单明细
	 */
	@RequiresPermissions("system:shopOrderItem:remove")
	@Log(title = "订单明细", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(shopOrderItemService.deleteShopOrderItemByIds(ids));
	}
	
}
