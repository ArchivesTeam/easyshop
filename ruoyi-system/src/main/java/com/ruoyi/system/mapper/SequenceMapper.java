package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Sequence;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 流水号存储 数据层
 * @Author majingyuan
 * @Date Create in 2019/4/3 23:48
 */
@Repository("sequenceMapper")
public interface SequenceMapper {
    /**
     * 查询流水号存储信息
     *
     * @param sequenceCode 流水号存储ID
     * @return 流水号存储信息
     */
    public Sequence selectSequenceById(String sequenceCode);

    /**
     * 查询流水号存储列表
     *
     * @param sequence 流水号存储信息
     * @return 流水号存储集合
     */
    public List<Sequence> selectSequenceList(Sequence sequence);

    /**
     * 新增流水号存储
     *
     * @param sequence 流水号存储信息
     * @return 结果
     */
    public int insertSequence(Sequence sequence);

    /**
     * 修改流水号存储
     *
     * @param sequence 流水号存储信息
     * @return 结果
     */
    public int updateSequence(Sequence sequence);

    /**
     * 删除流水号存储
     *
     * @param sequenceCode 流水号存储ID
     * @return 结果
     */
    public int deleteSequenceById(String sequenceCode);

    /**
     * 批量删除流水号存储
     *
     * @param sequenceCodes 需要删除的数据ID
     * @return 结果
     */
    public int deleteSequenceByIds(String[] sequenceCodes);

    /**
     * 根据code和年份查询
     *
     * @param sequenceCode
     * @param sequenceYear
     * @return
     */
    Sequence getSysSequenceValueByYear(@Param("sequenceCode") String sequenceCode, @Param("sequenceYear") String sequenceYear);

    /**
     * 按日期进行查询
     *
     * @param sequenceCode
     * @param year
     * @param month
     * @param day
     * @return
     */
    Sequence getSysSequenceValueByYearMonthDay(@Param("sequenceCode") String sequenceCode, @Param("year") String year, @Param("month") String month, @Param("day") String day);

}
