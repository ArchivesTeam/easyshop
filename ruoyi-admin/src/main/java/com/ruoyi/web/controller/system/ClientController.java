package com.ruoyi.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.ruoyi.system.domain.Client;
import com.ruoyi.system.service.IClientService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 客户 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Controller
@RequestMapping("/system/client")
public class ClientController extends BaseController
{
    private String prefix = "system/client";
	
	@Autowired
	private IClientService clientService;
	
	@RequiresPermissions("system:client:view")
	@GetMapping()
	public String client()
	{
	    return prefix + "/client";
	}
	
	/**
	 * 查询客户列表
	 */
	@RequiresPermissions("system:client:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Client client)
	{
		startPage();
        List<Client> list = clientService.selectClientList(client);
		return getDataTable(list);
	}

	/**
	 * ajax查询客户
	 */
	@PostMapping("/ajaxClientList")
	@ResponseBody
	public AjaxResult ajaxClientList(String searchValue)
	{
		Client client = new Client();
		client.setSearchValue(searchValue);
		Map<String, Object> map = new HashMap<>(16);
		map.put("clients", clientService.selectClientList(client));
		return AjaxResult.success("成功", map);
	}
	
	
	/**
	 * 导出客户列表
	 */
	@RequiresPermissions("system:client:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Client client)
    {
    	List<Client> list = clientService.selectClientList(client);
        ExcelUtil<Client> util = new ExcelUtil<Client>(Client.class);
        return util.exportExcel(list, "client");
    }
	
	/**
	 * 新增客户
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存客户
	 */
	@RequiresPermissions("system:client:add")
	@Log(title = "客户", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Client client)
	{		
		client.setClientId(UUID.randomUUID().toString());
		client.setCreateBy(ShiroUtils.getLoginName());
		client.setDeptId(ShiroUtils.getSysUser().getDeptId());
		return toAjax(clientService.insertClient(client));
	}

	/**
	 * 修改客户
	 */
	@GetMapping("/edit/{clientId}")
	public String edit(@PathVariable("clientId") String clientId, ModelMap mmap)
	{
		Client client = clientService.selectClientById(clientId);
		mmap.put("client", client);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存客户
	 */
	@RequiresPermissions("system:client:edit")
	@Log(title = "客户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Client client)
	{		
		return toAjax(clientService.updateClient(client));
	}
	
	/**
	 * 删除客户
	 */
	@RequiresPermissions("system:client:remove")
	@Log(title = "客户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(clientService.deleteClientByIds(ids));
	}
	
}
