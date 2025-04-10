package com.piggy.lwm.service.impl;

import com.piggy.lwm.domain.WarehouseEntity;
import com.piggy.lwm.mapper.WarehouseMapper;
import com.piggy.lwm.service.WarehouseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Warehouse)表服务实现类
 *
 * @author makejava
 * @since 2025-04-10 14:39:43
 */
@Service("warehouseService")
public class WarehouseServiceImpl implements WarehouseService {
    private static int PAGE_DEFAULT = 1;
    private static int SIZE_DEFAULT = 10;
    @Resource
    private WarehouseMapper warehouseMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public WarehouseEntity queryById(Integer id) {
        return this.warehouseMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param warehouse 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<WarehouseEntity> queryByPage(WarehouseEntity warehouse, Integer page, Integer size, String orderCol, String orderDirect) {
        if(page == null || page <= 0){
            page = PAGE_DEFAULT;
        }
        if(size == null || size <= 0){
            size = SIZE_DEFAULT;
        }

        Sort sort = null;
        if(orderCol != null) {
            Sort.Order order = new Sort.Order(("DESC".equals(orderDirect) ? Sort.Direction.DESC : Sort.Direction.ASC), orderCol);
            sort = Sort.by(order);
        }

        PageRequest pageRequest = PageRequest.of(page - 1, size);
        if(sort != null){
            pageRequest = PageRequest.of(page - 1, size, sort);
        }
        
        long total = this.warehouseMapper.count(warehouse);
        
        return new PageImpl<>(this.warehouseMapper.queryAllByLimit(warehouse, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param warehouse 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(WarehouseEntity warehouse) {
        return this.warehouseMapper.insert(warehouse) > 0;
    }

    /**
     * 修改数据
     *
     * @param warehouse 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(WarehouseEntity warehouse) {
       return this.warehouseMapper.update(warehouse) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.warehouseMapper.deleteById(id) > 0;
    }
}
