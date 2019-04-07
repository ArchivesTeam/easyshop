package com.ruoyi.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.ruoyi.framework.util.ShiroUtils;
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
import com.ruoyi.system.domain.ShopItem;
import com.ruoyi.system.service.IShopItemService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 消费项目 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Controller
@RequestMapping("/system/shopItem")
public class ShopItemController extends BaseController
{
    private String prefix = "system/shopItem";
	
	@Autowired
	private IShopItemService shopItemService;
	
	@RequiresPermissions("system:shopItem:view")
	@GetMapping()
	public String shopItem()
	{
	    return prefix + "/shopItem";
	}
	
	/**
	 * 查询消费项目列表
	 */
	@RequiresPermissions("system:shopItem:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ShopItem shopItem)
	{
		startPage();
        List<ShopItem> list = shopItemService.selectShopItemList(shopItem);
		return getDataTable(list);
	}

	/**
	 * ajax查询客户
	 */
	@PostMapping("/ajaxList")
	@ResponseBody
	public AjaxResult ajaxClientList(String searchValue)
	{
		ShopItem shopItem = new ShopItem();
		shopItem.setSearchValue(searchValue);
		Map<String, Object> map = new HashMap<>(16);
		map.put("items", shopItemService.selectShopItemList(shopItem));
		return AjaxResult.success("成功", map);
	}
	
	/**
	 * 导出消费项目列表
	 */
	@RequiresPermissions("system:shopItem:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShopItem shopItem)
    {
    	List<ShopItem> list = shopItemService.selectShopItemList(shopItem);
        ExcelUtil<ShopItem> util = new ExcelUtil<ShopItem>(ShopItem.class);
        return util.exportExcel(list, "shopItem");
    }
	
	/**
	 * 新增消费项目
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存消费项目
	 */
	@RequiresPermissions("system:shopItem:add")
	@Log(title = "消费项目", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ShopItem shopItem)
	{
		shopItem.setItemId(UUID.randomUUID().toString());
		shopItem.setCreateBy(ShiroUtils.getLoginName());
		try {
			shopItem.setItemShort(PinyinHelper.getShortPinyin(shopItem.getItemName()));
		} catch (PinyinException e) {
			e.printStackTrace();
		}
		return toAjax(shopItemService.insertShopItem(shopItem));
	}

	/**
	 * 修改消费项目
	 */
	@GetMapping("/edit/{itemId}")
	public String edit(@PathVariable("itemId") String itemId, ModelMap mmap)
	{
		ShopItem shopItem = shopItemService.selectShopItemById(itemId);
		mmap.put("shopItem", shopItem);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存消费项目
	 */
	@RequiresPermissions("system:shopItem:edit")
	@Log(title = "消费项目", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ShopItem shopItem)
	{
		try {
			shopItem.setItemShort(PinyinHelper.getShortPinyin(shopItem.getItemName()));
		} catch (PinyinException e) {
			e.printStackTrace();
		}
		return toAjax(shopItemService.updateShopItem(shopItem));
	}
	
	/**
	 * 删除消费项目
	 */
	@RequiresPermissions("system:shopItem:remove")
	@Log(title = "消费项目", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(shopItemService.deleteShopItemByIds(ids));
	}
	
}
