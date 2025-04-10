package com.piggy.lwm.service.impl;

import com.piggy.lwm.domain.InventoryEntity;
import com.piggy.lwm.mapper.InventoryMapper;
import com.piggy.lwm.service.InventoryService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Inventory)表服务实现类
 *
 * @author makejava
 * @since 2025-04-10 14:39:42
 */
@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService {
    private static int PAGE_DEFAULT = 1;
    private static int SIZE_DEFAULT = 10;
    @Resource
    private InventoryMapper inventoryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public InventoryEntity queryById(Integer id) {
        return this.inventoryMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param inventory 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<InventoryEntity> queryByPage(InventoryEntity inventory, Integer page, Integer size, String orderCol, String orderDirect) {
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
        
        long total = this.inventoryMapper.count(inventory);
        
        return new PageImpl<>(this.inventoryMapper.queryAllByLimit(inventory, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param inventory 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(InventoryEntity inventory) {
        return this.inventoryMapper.insert(inventory) > 0;
    }

    /**
     * 修改数据
     *
     * @param inventory 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(InventoryEntity inventory) {
       return this.inventoryMapper.update(inventory) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.inventoryMapper.deleteById(id) > 0;
    }
}
