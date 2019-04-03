package com.ruoyi.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单明细表 shop_order_item
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Data
public class ShopOrderItem extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 明细ID */
	private String orderItemId;
	/** 订单ID */
	private String orderId;
	/** 服务项目ID */
	private String shopItemId;
	/** 数量 */
	private Integer itemNum;
	/** 单价 */
	private BigDecimal itemPrice;

}
