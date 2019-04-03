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
import com.ruoyi.system.domain.ClientPay;
import com.ruoyi.system.service.IClientPayService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 支付记录 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Controller
@RequestMapping("/system/clientPay")
public class ClientPayController extends BaseController
{
    private String prefix = "system/clientPay";
	
	@Autowired
	private IClientPayService clientPayService;
	
	@RequiresPermissions("system:clientPay:view")
	@GetMapping()
	public String clientPay()
	{
	    return prefix + "/clientPay";
	}
	
	/**
	 * 查询支付记录列表
	 */
	@RequiresPermissions("system:clientPay:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ClientPay clientPay)
	{
		startPage();
        List<ClientPay> list = clientPayService.selectClientPayList(clientPay);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出支付记录列表
	 */
	@RequiresPermissions("system:clientPay:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ClientPay clientPay)
    {
    	List<ClientPay> list = clientPayService.selectClientPayList(clientPay);
        ExcelUtil<ClientPay> util = new ExcelUtil<ClientPay>(ClientPay.class);
        return util.exportExcel(list, "clientPay");
    }
	
	/**
	 * 新增支付记录
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存支付记录
	 */
	@RequiresPermissions("system:clientPay:add")
	@Log(title = "支付记录", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ClientPay clientPay)
	{		
		clientPay.setPayId(UUID.randomUUID().toString());
		clientPay.setCreateBy(ShiroUtils.getLoginName());
		clientPay.setDeptId(ShiroUtils.getSysUser().getDeptId());
		clientPay.setPaySn("P" + SequenceUtils.getSequenceStringForYearMonthDay("P"));
		return toAjax(clientPayService.insertClientPay(clientPay));
	}

	/**
	 * 修改支付记录
	 */
	@GetMapping("/edit/{payId}")
	public String edit(@PathVariable("payId") String payId, ModelMap mmap)
	{
		ClientPay clientPay = clientPayService.selectClientPayById(payId);
		mmap.put("clientPay", clientPay);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存支付记录
	 */
	@RequiresPermissions("system:clientPay:edit")
	@Log(title = "支付记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ClientPay clientPay)
	{		
		return toAjax(clientPayService.updateClientPay(clientPay));
	}
	
	/**
	 * 删除支付记录
	 */
	@RequiresPermissions("system:clientPay:remove")
	@Log(title = "支付记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(clientPayService.deleteClientPayByIds(ids));
	}
	
}
