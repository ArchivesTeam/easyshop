package com.ruoyi.system.domain;

import java.math.BigDecimal;

/**
 * 消费项目
 * @Author majingyuan
 * @Date Create in 2019/4/2 16:13
 */
public class ShopItem {

    /**
     * id
     */
    private String itemId;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 速记码
     */
    private String itemShortName;

    /**
     * 介绍
     */
    private String itemInfo;

    /**
     * 单价
     */
    private BigDecimal itemPrice;

    /**
     * 状态
     */
    private String status;
}
