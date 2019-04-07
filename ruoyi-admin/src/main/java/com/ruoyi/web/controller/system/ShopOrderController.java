package com.ruoyi.web.controller.system;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.Client;
import com.ruoyi.system.domain.ShopOrderItem;
import com.ruoyi.system.service.IClientService;
import com.ruoyi.system.service.IShopOrderItemService;
import com.ruoyi.web.core.utils.SequenceUtils;
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
import com.ruoyi.system.domain.ShopOrder;
import com.ruoyi.system.service.IShopOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 订单 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Controller
@RequestMapping("/system/shopOrder")
public class ShopOrderController extends BaseController
{
    private String prefix = "system/shopOrder";
	
	@Autowired
	private IShopOrderService shopOrderService;

	@Autowired
    private IClientService clientService;

	@Autowired
	private IShopOrderItemService shopOrderItemService;
	
	@RequiresPermissions("system:shopOrder:view")
	@GetMapping()
	public String shopOrder()
	{
	    return prefix + "/shopOrder";
	}
	
	/**
	 * 查询订单列表
	 */
	@RequiresPermissions("system:shopOrder:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ShopOrder shopOrder)
	{
		startPage();
        List<ShopOrder> list = shopOrderService.selectShopOrderList(shopOrder);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出订单列表
	 */
	@RequiresPermissions("system:shopOrder:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShopOrder shopOrder)
    {
    	List<ShopOrder> list = shopOrderService.selectShopOrderList(shopOrder);
        ExcelUtil<ShopOrder> util = new ExcelUtil<ShopOrder>(ShopOrder.class);
        return util.exportExcel(list, "shopOrder");
    }
	
	/**
	 * 新增订单
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		mmap.put("user", ShiroUtils.getSysUser());
        mmap.put("clients", clientService.selectClientList(null));
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存订单
	 */
	@RequiresPermissions("system:shopOrder:add")
	@Log(title = "订单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ShopOrder shopOrder)
	{
		shopOrder.setShopOrderItems(JSONArray.parseArray(shopOrder.getShopOrderItemsStr(), ShopOrderItem.class));
		shopOrder.setOrderId(UUID.randomUUID().toString());
		shopOrder.setCreateBy(ShiroUtils.getUserId().toString());
		shopOrder.setDeptId(ShiroUtils.getSysUser().getDeptId());
		shopOrder.setOrderSn("XF" + SequenceUtils.getSequenceByYearMonthDay("XF"));
		return toAjax(shopOrderService.insertShopOrder(shopOrder));
	}

	/**
	 * 修改订单
	 */
	@GetMapping("/edit/{orderId}")
	public String edit(@PathVariable("orderId") String orderId, ModelMap mmap)
	{
		ShopOrder shopOrder = shopOrderService.selectShopOrderById(orderId);
		shopOrder.setShopOrderItems(shopOrderItemService.selectShopOrderItemListByOrderId(orderId));
		mmap.put("shopOrder", shopOrder);
		mmap.put("user", ShiroUtils.getSysUser());
	    return prefix + "/edit";
	}

	/**
	 * 修改订单
	 */
	@GetMapping("/view/{orderId}")
	public String view(@PathVariable("orderId") String orderId, ModelMap mmap)
	{
		ShopOrder shopOrder = shopOrderService.selectShopOrderById(orderId);
		Client client = clientService.selectClientById(shopOrder.getClientId());
		mmap.put("shopOrder", shopOrder);
		mmap.put("client", client);
	    return prefix + "/view";
	}
	
	/**
	 * 修改保存订单
	 */
	@RequiresPermissions("system:shopOrder:edit")
	@Log(title = "订单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ShopOrder shopOrder)
	{
		shopOrder.setShopOrderItems(JSONArray.parseArray(shopOrder.getShopOrderItemsStr(), ShopOrderItem.class));
		return toAjax(shopOrderService.updateShopOrder(shopOrder));
	}
	
	/**
	 * 删除订单
	 */
	@RequiresPermissions("system:shopOrder:remove")
	@Log(title = "订单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(shopOrderService.deleteShopOrderByIds(ids));
	}

	/**
	 * 改变订单状态
	 */
	@RequiresPermissions("system:shopOrder:status")
	@Log(title = "订单", businessType = BusinessType.DELETE)
	@PostMapping( "/changeStatus")
	@ResponseBody
	public AjaxResult changeStatus(String orderId, int status)
	{
		ShopOrder shopOrder = new ShopOrder();
		shopOrder.setOrderId(orderId);
		shopOrder.setStatus(status);
		if (status == 1){
			shopOrder.setPayBy(ShiroUtils.getSysUser().getUserId().toString());
			shopOrder.setPayDate(new Date());
		}
		return toAjax(shopOrderService.updateShopOrder(shopOrder));
	}
	
}
