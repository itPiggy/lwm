package com.piggy.lwm.service;

import com.piggy.lwm.domain.WarehouseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Warehouse)表服务接口
 *
 * @author makejava
 * @since 2025-04-08 15:38:55
 */
public interface WarehouseService {

    /**
     * 通过ID查询单条数据
     *
     * @param whId 主键
     * @return 实例对象
     */
    WarehouseEntity queryById(String whId);

    /**
     * 分页查询
     *
     * @param warehouse 筛选条件
     * @return 查询结果
     */
    Page<WarehouseEntity> queryByPage(WarehouseEntity warehouse, Integer page, Integer size, String orderCol, String orderDirect);

    /**
     * 新增数据
     *
     * @param warehouse 实例对象
     * @return 实例对象
     */
    boolean insert(WarehouseEntity warehouse);

    /**
     * 修改数据
     *
     * @param warehouse 实例对象
     * @return 实例对象
     */
    boolean update(WarehouseEntity warehouse);

    /**
     * 通过主键删除数据
     *
     * @param whId 主键
     * @return 是否成功
     */
    boolean deleteById(String whId);

}
