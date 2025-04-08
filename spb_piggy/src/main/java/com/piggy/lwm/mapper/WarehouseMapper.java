package com.piggy.lwm.mapper;

import com.piggy.lwm.domain.WarehouseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Warehouse)表数据库访问层
 *
 * @author makejava
 * @since 2025-04-08 15:38:55
 */
public interface WarehouseMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param whId 主键
     * @return 实例对象
     */
    WarehouseEntity queryById(String whId);

    /**
     * 查询指定行数据
     *
     * @param warehouse 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<WarehouseEntity> queryAllByLimit(@Param("warehouse") WarehouseEntity warehouse, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param warehouse 查询条件
     * @return 总行数
     */
    long count(WarehouseEntity warehouse);

    /**
     * 新增数据
     *
     * @param warehouse 实例对象
     * @return 影响行数
     */
    int insert(WarehouseEntity warehouse);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<WarehouseEntity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<WarehouseEntity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<WarehouseEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<WarehouseEntity> entities);

    /**
     * 修改数据
     *
     * @param warehouse 实例对象
     * @return 影响行数
     */
    int update(WarehouseEntity warehouse);

    /**
     * 通过主键删除数据
     *
     * @param whId 主键
     * @return 影响行数
     */
    int deleteById(String whId);

}

