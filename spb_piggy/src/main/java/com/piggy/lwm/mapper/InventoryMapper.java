package com.piggy.lwm.mapper;

import com.piggy.lwm.domain.InventoryEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Inventory)表数据库访问层
 *
 * @author makejava
 * @since 2025-04-10 14:39:42
 */
public interface InventoryMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    InventoryEntity queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param inventory 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<InventoryEntity> queryAllByLimit(@Param("inventory") InventoryEntity inventory, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param inventory 查询条件
     * @return 总行数
     */
    long count(InventoryEntity inventory);

    /**
     * 新增数据
     *
     * @param inventory 实例对象
     * @return 影响行数
     */
    int insert(InventoryEntity inventory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<InventoryEntity> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<InventoryEntity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<InventoryEntity> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<InventoryEntity> entities);

    /**
     * 修改数据
     *
     * @param inventory 实例对象
     * @return 影响行数
     */
    int update(InventoryEntity inventory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

