package com.ruoyi.web.core.utils;

import com.ruoyi.common.utils.SpringContextUtils;
import com.ruoyi.system.domain.Sequence;
import com.ruoyi.system.mapper.SequenceMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;

/**
 * 序列号获取
 * @Author majingyuan
 * @Date Create in 2019/4/3 23:53
 */
public class SequenceUtils {
    /**
     * 按年份进行编码
     *
     * @param sequenceCode
     * @return
     */
    public static String getSequenceByYear(String sequenceCode) {
        SequenceMapper sequenceMapper = (SequenceMapper) SpringContextUtils.getApplicationContext().getBean("sequenceMapper");

        //根据当前年份查询value值
        Sequence sequence = sequenceMapper.getSysSequenceValueByYear(sequenceCode, String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        if (sequence == null) {
            sequence = new Sequence();
            sequence.setSequenceCode(sequenceCode);
            sequence.setSequenceYear(Calendar.getInstance().get(Calendar.YEAR));
            sequence.setSequenceValue(1);
        }
        String currentSequenceValue = org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(sequence.getSequenceValue()), 4, '0');
        sequence.setSequenceValue(1 + sequence.getSequenceValue());
        if (sequenceMapper.selectSequenceById(sequence.getSequenceCode()) == null) {
            sequenceMapper.insertSequence(sequence);
        } else {
            sequenceMapper.updateSequence(sequence);
        }
        return sequence.getSequenceYear() + "-" + currentSequenceValue;
    }

    /**
     * 按日期进行编码
     *
     * @param sequenceCode
     * @return
     */
    public static String getSequenceByMonthDay(String sequenceCode) {
        SequenceMapper sequenceMapper = (SequenceMapper) SpringContextUtils.getApplicationContext().getBean("sequenceMapper");

        //根据当前年份、月份、天、查询value值
        Sequence sequence = sequenceMapper.getSysSequenceValueByYearMonthDay(sequenceCode,
                String.valueOf(Calendar.getInstance().get(Calendar.YEAR)),
                org.apache.commons.lang3.StringUtils.leftPad(String.valueOf((Calendar.getInstance().get(Calendar.MONTH) + 1)), 2, '0'),
                org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)), 2, '0'));

        if (sequence == null) {
            sequence = new Sequence();
            sequence.setSequenceCode(sequenceCode);
            sequence.setSequenceYear(Calendar.getInstance().get(Calendar.YEAR));
            sequence.setSequenceMonth(Integer.parseInt(org.apache.commons.lang3.StringUtils.leftPad(String.valueOf((Calendar.getInstance().get(Calendar.MONTH) + 1)), 2, '0')));
            sequence.setSequenceDay(Integer.parseInt(org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)), 2, '0')));
            sequence.setSequenceValue(1);

        }
        String currentSequenceValue = org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(sequence.getSequenceValue()), 4, '0');
        sequence.setSequenceValue(1 + sequence.getSequenceValue());

        if (sequenceMapper.selectSequenceById(sequence.getSequenceCode()) == null) {
            sequenceMapper.insertSequence(sequence);
        } else {
            sequenceMapper.updateSequence(sequence);
        }
        return sequence.getSequenceYear() + sequence.getSequenceMonth() + sequence.getSequenceDay() + currentSequenceValue;
    }
    /**
     * 只要currentSequenceValue
     *
     * @param sequenceCode
     * @return
     */
    public static String getSequenceString(String sequenceCode) {
        SequenceMapper sequenceMapper = (SequenceMapper) SpringContextUtils.getApplicationContext().getBean("sequenceMapper");

        //根据当前年份、月份、天、查询value值
        Sequence sequence = sequenceMapper.getSysSequenceValueByYearMonthDay(sequenceCode,
                String.valueOf(Calendar.getInstance().get(Calendar.YEAR)),
                org.apache.commons.lang3.StringUtils.leftPad(String.valueOf((Calendar.getInstance().get(Calendar.MONTH) + 1)), 2, '0'),
                org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)), 2, '0'));

        if (sequence == null) {
            sequence = new Sequence();
            sequence.setSequenceCode(sequenceCode);
            sequence.setSequenceYear(Calendar.getInstance().get(Calendar.YEAR));
            sequence.setSequenceMonth(Integer.parseInt(org.apache.commons.lang3.StringUtils.leftPad(String.valueOf((Calendar.getInstance().get(Calendar.MONTH) + 1)), 2, '0')));
            sequence.setSequenceDay(Integer.parseInt(org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)), 2, '0')));
            sequence.setSequenceValue(1);

        }
        String currentSequenceValue = org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(sequence.getSequenceValue()), 4, '0');
        sequence.setSequenceValue(1 + sequence.getSequenceValue());

        if (sequenceMapper.selectSequenceById(sequence.getSequenceCode()) == null) {
            sequenceMapper.insertSequence(sequence);
        } else {
            sequenceMapper.updateSequence(sequence);
        }
        return currentSequenceValue;
    }

    /**
     * 按日期进行编码
     *
     * @param sequenceCode
     * @return
     */
    public static String getSequenceByYearMonthDay(String sequenceCode) {
        SequenceMapper sequenceMapper = (SequenceMapper) SpringContextUtils.getApplicationContext().getBean("sequenceMapper");

        //根据当前年份、月份、天、查询value值
        Sequence sequence = sequenceMapper.getSysSequenceValueByYearMonthDay(sequenceCode,
                String.valueOf(Calendar.getInstance().get(Calendar.YEAR)),
                org.apache.commons.lang3.StringUtils.leftPad(String.valueOf((Calendar.getInstance().get(Calendar.MONTH) + 1)), 2, '0'),
                org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)), 2, '0'));

        if (sequence == null) {
            sequence = new Sequence();
            sequence.setSequenceCode(sequenceCode);
            sequence.setSequenceYear(Calendar.getInstance().get(Calendar.YEAR));
            sequence.setSequenceMonth(Integer.parseInt(org.apache.commons.lang3.StringUtils.leftPad(String.valueOf((Calendar.getInstance().get(Calendar.MONTH) + 1)), 2, '0')));
            sequence.setSequenceDay(Integer.parseInt(org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)), 2, '0')));
            sequence.setSequenceValue(1);

        }
        String currentSequenceValue = org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(sequence.getSequenceValue()), 2, '0');
        sequence.setSequenceValue(1 + sequence.getSequenceValue());

        if (sequenceMapper.selectSequenceById(sequence.getSequenceCode()) == null) {
            sequenceMapper.insertSequence(sequence);
        } else {
            sequenceMapper.updateSequence(sequence);
        }
        return sequenceCode+sequence.getSequenceYear() + org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(sequence.getSequenceMonth()),2,"0") +  org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(sequence.getSequenceDay()),2,"0") + currentSequenceValue;
    }

    public static String getWmsSequenceStringForYearMonthDay(String sequenceCode) {
        SequenceMapper sequenceMapper = (SequenceMapper) SpringContextUtils.getApplicationContext().getBean("sequenceMapper");

        //根据当前年份、月份、天、查询value值
        Sequence sequence = sequenceMapper.getSysSequenceValueByYearMonthDay(sequenceCode,
                String.valueOf(Calendar.getInstance().get(Calendar.YEAR)),
                org.apache.commons.lang3.StringUtils.leftPad(String.valueOf((Calendar.getInstance().get(Calendar.MONTH) + 1)), 2, '0'),
                org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)), 2, '0'));

        if (sequence == null) {
            sequence = new Sequence();
            sequence.setSequenceCode(sequenceCode);
            sequence.setSequenceYear(Calendar.getInstance().get(Calendar.YEAR));
            sequence.setSequenceMonth(Integer.parseInt(org.apache.commons.lang3.StringUtils.leftPad(String.valueOf((Calendar.getInstance().get(Calendar.MONTH) + 1)), 2, '0')));
            sequence.setSequenceDay(Integer.parseInt(org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)), 2, '0')));
            sequence.setSequenceValue(1);

        }
        String currentSequenceValue = org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(sequence.getSequenceValue()), 6, '0');
        sequence.setSequenceValue(1 + sequence.getSequenceValue());

        if (sequenceMapper.selectSequenceById(sequence.getSequenceCode()) == null) {
            sequenceMapper.insertSequence(sequence);
        } else {
            sequenceMapper.updateSequence(sequence);
        }
        return sequenceCode+sequence.getSequenceYear() + org.apache.commons.lang3.StringUtils.leftPad(String.valueOf(sequence.getSequenceMonth()),2,"0") +  StringUtils.leftPad(String.valueOf(sequence.getSequenceDay()),2,"0") + currentSequenceValue;
    }
}
