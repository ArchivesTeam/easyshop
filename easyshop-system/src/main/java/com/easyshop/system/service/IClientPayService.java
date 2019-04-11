package com.easyshop.system.service;

import com.easyshop.system.domain.ClientPay;
import java.util.List;

/**
 * 支付记录 服务层
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
public interface IClientPayService 
{
	/**
     * 查询支付记录信息
     * 
     * @param payId 支付记录ID
     * @return 支付记录信息
     */
	public ClientPay selectClientPayById(String payId);
	
	/**
     * 查询支付记录列表
     * 
     * @param clientPay 支付记录信息
     * @return 支付记录集合
     */
	public List<ClientPay> selectClientPayList(ClientPay clientPay);
	
	/**
     * 新增支付记录
     * 
     * @param clientPay 支付记录信息
     * @return 结果
     */
	public int insertClientPay(ClientPay clientPay);
	
	/**
     * 修改支付记录
     * 
     * @param clientPay 支付记录信息
     * @return 结果
     */
	public int updateClientPay(ClientPay clientPay);
		
	/**
     * 删除支付记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteClientPayByIds(String ids);
	
}
