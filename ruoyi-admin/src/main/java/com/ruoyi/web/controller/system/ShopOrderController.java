package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.UUID;

import com.ruoyi.framework.util.ShiroUtils;
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
	public String add()
	{
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
		shopOrder.setOrderId(UUID.randomUUID().toString());
		shopOrder.setCreateBy(ShiroUtils.getLoginName());
		shopOrder.setDeptId(ShiroUtils.getSysUser().getDeptId());
		shopOrder.setOrderSn("XF" + SequenceUtils.getSequenceStringForYearMonthDay("XF"));
		return toAjax(shopOrderService.insertShopOrder(shopOrder));
	}

	/**
	 * 修改订单
	 */
	@GetMapping("/edit/{orderId}")
	public String edit(@PathVariable("orderId") String orderId, ModelMap mmap)
	{
		ShopOrder shopOrder = shopOrderService.selectShopOrderById(orderId);
		mmap.put("shopOrder", shopOrder);
	    return prefix + "/edit";
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
	
}
