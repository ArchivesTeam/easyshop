package com.ruoyi.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户表 sys_client
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Data
public class Client extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 客户编号 */
	private String clientId;
	/** 会员卡号 */
	private String clientCard;
	/** 姓名 */
	private String clientName;
	/** 会员电话 */
	private String clientPhone;
	/** 会员性别 */
	private Integer clientSex;
	/** 会员年龄 */
	private Integer clientAge;
	/** 生日 */
	@DateTimeFormat(pattern="dd-MMM-YYYY")
	private Date clientBirthday;
	/** 地址 */
	private String clientAddress;
	/** 省 */
	private String clientProvince;
	/** 市 */
	private String clientCity;
	/** 县 */
	private String clientCountry;
	/** 单位 */
	private String clientCompany;
	/** 余额 */
	private BigDecimal clientBalance;
	/** 状态 */
	private Integer clientStatus;
	/** 门店 */
	private Long deptId;

}
