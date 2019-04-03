package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClientMapper;
import com.ruoyi.system.domain.Client;
import com.ruoyi.system.service.IClientService;
import com.ruoyi.common.core.text.Convert;

/**
 * 客户 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Service
public class ClientServiceImpl implements IClientService 
{
	@Autowired
	private ClientMapper clientMapper;

	/**
     * 查询客户信息
     * 
     * @param clientId 客户ID
     * @return 客户信息
     */
    @Override
	public Client selectClientById(String clientId)
	{
	    return clientMapper.selectClientById(clientId);
	}
	
	/**
     * 查询客户列表
     * 
     * @param client 客户信息
     * @return 客户集合
     */
	@Override
	public List<Client> selectClientList(Client client)
	{
	    return clientMapper.selectClientList(client);
	}
	
    /**
     * 新增客户
     * 
     * @param client 客户信息
     * @return 结果
     */
	@Override
	public int insertClient(Client client)
	{
	    return clientMapper.insertClient(client);
	}
	
	/**
     * 修改客户
     * 
     * @param client 客户信息
     * @return 结果
     */
	@Override
	public int updateClient(Client client)
	{
	    return clientMapper.updateClient(client);
	}

	/**
     * 删除客户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteClientByIds(String ids)
	{
		return clientMapper.deleteClientByIds(Convert.toStrArray(ids));
	}
	
}
