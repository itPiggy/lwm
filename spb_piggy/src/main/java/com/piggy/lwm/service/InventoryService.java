package com.piggy.lwm.service;

import com.piggy.lwm.domain.InventoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Inventory)表服务接口
 *
 * @author makejava
 * @since 2025-04-10 14:39:42
 */
public interface InventoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    InventoryEntity queryById(Integer id);

    /**
     * 分页查询
     *
     * @param inventory 筛选条件
     * @return 查询结果
     */
    Page<InventoryEntity> queryByPage(InventoryEntity inventory, Integer page, Integer size, String orderCol, String orderDirect);

    /**
     * 新增数据
     *
     * @param inventory 实例对象
     * @return 实例对象
     */
    boolean insert(InventoryEntity inventory);

    /**
     * 修改数据
     *
     * @param inventory 实例对象
     * @return 实例对象
     */
    boolean update(InventoryEntity inventory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
