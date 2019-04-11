package com.easyshop.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.easyshop.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付记录表 client_pay
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Data
public class ClientPay extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 支付id */
	private String payId;
	/** 支付流水号 */
	private String paySn;
	/** 支付人 */
	private String payMan;
	/** 支付时间 */
	private Date payDate;
	/** 支付金额 */
	private BigDecimal payAmount;
	/** 支付类型 */
	private Integer payType;
	/** 门店 */
	private Long deptId;

}
