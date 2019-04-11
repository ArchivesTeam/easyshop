package com.easyshop.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.easyshop.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 消费项目表 shop_item
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Data
public class ShopItem extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private String itemId;
	/** 项目名称 */
	private String itemName;
	/** 速记码 */
	private String itemShort;
	/** 介绍 */
	private String itemInfo;
	/** 单价 */
	private BigDecimal itemPrice;
	/** 状态 */
	private Integer status;

}
