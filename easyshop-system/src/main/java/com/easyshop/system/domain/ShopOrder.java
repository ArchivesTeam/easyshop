package com.easyshop.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.easyshop.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单表 shop_order
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Data
public class ShopOrder extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private String orderId;
	/** 流水号 */
	private String orderSn;
	/** 付款人 */
	private String payBy;
	/** 付款时间 */
	private Date payDate;
	/** 状态 */
	private Integer status;
	/** 金额 */
	private BigDecimal orderAmount;
	/** 折扣 */
	private BigDecimal orderDiscount;
	/** 会员 */
	private String clientId;
	/** 门店 */
	private Long deptId;

	private List<Client> clients;
	private List<ShopOrderItem> shopOrderItems;
	private String shopOrderItemsStr;

}
