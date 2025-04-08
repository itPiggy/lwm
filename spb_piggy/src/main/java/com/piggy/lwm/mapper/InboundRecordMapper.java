package com.piggy.lwm.mapper;

import com.piggy.lwm.domain.InboundRecordEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (InboundRecord)表数据库访问层
 *
 * @author makejava
 * @since 2025-04-08 15:38:36
 */
public interface InboundRecordMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param recordId 主键
     * @return 实例对象
     */
    InboundRecordEntity queryById(String recordId);

    /**
     * 查询指定行数据
     *
     * @param inboundRecord 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<InboundRecordEntity> queryAllByLimit(@Param("inboundRecord") InboundRecordEntity inboundRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param inboundRecord 查询条件
     * @return 总行数
     */
    long count(InboundRecordEntity inboundRecord);

    /**
     * 新增数据
     *
     * @param inboundRecord 实例对象
     * @return 影响行数
     */
    int insert(InboundRecordEntity inboundRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<InboundRecordEntity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<InboundRecordEntity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<InboundRecordEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<InboundRecordEntity> entities);

    /**
     * 修改数据
     *
     * @param inboundRecord 实例对象
     * @return 影响行数
     */
    int update(InboundRecordEntity inboundRecord);

    /**
     * 通过主键删除数据
     *
     * @param recordId 主键
     * @return 影响行数
     */
    int deleteById(String recordId);

}

