package com.ruoyi.system.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 客户
 * @author majingyuan
 * @date Create in 2019/4/2 15:47
 */
@Data
public class SysClient {

    /**
     * id
     */
    private String clientId;

    /**
     * 会员卡号
     */
    private String clientCard;

    /**
     * 姓名
     */
    private String clientName;

    /**
     * 会员电话
     */
    private String clientPhone;

    /**
     * 会员性别
     */
    private String clientSex;

    /**
     * 会员年龄
     */
    private String clientAge;

    /**
     * 生日
     */
    private String clientBirthDay;

    /**
     * 地址
     */
    private String clientAddress;

    /**
     * 省
     */
    private String clientProvince;

    /**
     * 市
     */
    private String clientCity;

    /**
     * 县
     */
    private String clientCountry;

    /**
     * 单位
     */
    private String clientCompany;

    /**
     * 余额
     */
    private BigDecimal clientBalance;

    /**
     * 状态
     */
    private String clientStatus;

}
