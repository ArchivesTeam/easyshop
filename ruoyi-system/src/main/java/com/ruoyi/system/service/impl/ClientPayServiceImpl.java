package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClientPayMapper;
import com.ruoyi.system.domain.ClientPay;
import com.ruoyi.system.service.IClientPayService;
import com.ruoyi.common.core.text.Convert;

/**
 * 支付记录 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Service
public class ClientPayServiceImpl implements IClientPayService 
{
	@Autowired
	private ClientPayMapper clientPayMapper;

	/**
     * 查询支付记录信息
     * 
     * @param payId 支付记录ID
     * @return 支付记录信息
     */
    @Override
	public ClientPay selectClientPayById(String payId)
	{
	    return clientPayMapper.selectClientPayById(payId);
	}
	
	/**
     * 查询支付记录列表
     * 
     * @param clientPay 支付记录信息
     * @return 支付记录集合
     */
	@Override
	public List<ClientPay> selectClientPayList(ClientPay clientPay)
	{
	    return clientPayMapper.selectClientPayList(clientPay);
	}
	
    /**
     * 新增支付记录
     * 
     * @param clientPay 支付记录信息
     * @return 结果
     */
	@Override
	public int insertClientPay(ClientPay clientPay)
	{
	    return clientPayMapper.insertClientPay(clientPay);
	}
	
	/**
     * 修改支付记录
     * 
     * @param clientPay 支付记录信息
     * @return 结果
     */
	@Override
	public int updateClientPay(ClientPay clientPay)
	{
	    return clientPayMapper.updateClientPay(clientPay);
	}

	/**
     * 删除支付记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteClientPayByIds(String ids)
	{
		return clientPayMapper.deleteClientPayByIds(Convert.toStrArray(ids));
	}
	
}
