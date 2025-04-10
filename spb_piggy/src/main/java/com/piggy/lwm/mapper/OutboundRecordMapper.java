package com.piggy.lwm.mapper;

import com.piggy.lwm.domain.OutboundRecordEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (OutboundRecord)表数据库访问层
 *
 * @author makejava
 * @since 2025-04-10 14:39:42
 */
public interface OutboundRecordMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OutboundRecordEntity queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param outboundRecord 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<OutboundRecordEntity> queryAllByLimit(@Param("outboundRecord") OutboundRecordEntity outboundRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param outboundRecord 查询条件
     * @return 总行数
     */
    long count(OutboundRecordEntity outboundRecord);

    /**
     * 新增数据
     *
     * @param outboundRecord 实例对象
     * @return 影响行数
     */
    int insert(OutboundRecordEntity outboundRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OutboundRecordEntity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OutboundRecordEntity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OutboundRecordEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OutboundRecordEntity> entities);

    /**
     * 修改数据
     *
     * @param outboundRecord 实例对象
     * @return 影响行数
     */
    int update(OutboundRecordEntity outboundRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

