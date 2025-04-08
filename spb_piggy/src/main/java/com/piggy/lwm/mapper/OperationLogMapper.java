package com.piggy.lwm.mapper;

import com.piggy.lwm.domain.OperationLogEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (OperationLog)表数据库访问层
 *
 * @author makejava
 * @since 2025-04-08 15:38:55
 */
public interface OperationLogMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    OperationLogEntity queryById(Integer logId);

    /**
     * 查询指定行数据
     *
     * @param operationLog 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<OperationLogEntity> queryAllByLimit(@Param("operationLog") OperationLogEntity operationLog, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param operationLog 查询条件
     * @return 总行数
     */
    long count(OperationLogEntity operationLog);

    /**
     * 新增数据
     *
     * @param operationLog 实例对象
     * @return 影响行数
     */
    int insert(OperationLogEntity operationLog);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<OperationLogEntity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OperationLogEntity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<OperationLogEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<OperationLogEntity> entities);

    /**
     * 修改数据
     *
     * @param operationLog 实例对象
     * @return 影响行数
     */
    int update(OperationLogEntity operationLog);

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 影响行数
     */
    int deleteById(Integer logId);

}

