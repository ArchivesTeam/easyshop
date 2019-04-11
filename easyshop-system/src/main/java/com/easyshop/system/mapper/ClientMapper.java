package com.easyshop.system.mapper;

import com.easyshop.system.domain.Client;
import java.util.List;	

/**
 * 客户 数据层
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
public interface ClientMapper 
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
     * 删除客户
     * 
     * @param clientId 客户ID
     * @return 结果
     */
	public int deleteClientById(String clientId);
	
	/**
     * 批量删除客户
     * 
     * @param clientIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteClientByIds(String[] clientIds);
	
}