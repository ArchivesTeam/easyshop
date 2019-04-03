package com.ruoyi.system.domain;

import lombok.Data;

import java.util.Date;

/**
 * 流水号存储表 sys_sequence
 * @Author majingyuan
 * @Date Create in 2019/4/3 23:47
 */
@Data
public class Sequence {
    private static final long serialVersionUID = 1L;

    /**
     * 生成的类型
     */
    private String sequenceCode;
    /**
     * 年
     */
    private Integer sequenceYear;
    /**
     * 月
     */
    private Integer sequenceMonth;
    /**
     * 日
     */
    private Integer sequenceDay;
    /**
     * 值
     */
    private Integer sequenceValue;
    /**
     * 可用标志
     */
    private String activeFlag;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdDate;
    /**
     * 最后更新人
     */
    private String lastUpdBy;
    /**
     * 最后更新时间
     */
    private Date lastUpdDate;
    /**
     * 版本
     */
    private Integer version;
}
