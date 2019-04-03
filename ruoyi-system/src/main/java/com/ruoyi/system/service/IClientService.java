package com.ruoyi.system.service;

import com.ruoyi.system.domain.Client;
import java.util.List;

/**
 * 客户 服务层
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
public interface IClientService 
{
	/**
     * 查询客户信息
     * 
     * @param clientId 客户ID
     * @return 客户信息
     */
	public Client selectClientById(String clientId);
	
	/**
     * 查询客户列表
     * 
     * @param client 客户信息
     * @return 客户集合
     */
	public List<Client> selectClientList(Client client);
	
	/**
     * 新增客户
     * 
     * @param client 客户信息
     * @return 结果
     */
	public int insertClient(Client client);
	
	/**
     * 修改客户
     * 
     * @param client 客户信息
     * @return 结果
     */
	public int updateClient(Client client);
		
	/**
     * 删除客户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteClientByIds(String ids);
	
}
