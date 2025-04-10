package com.piggy.lwm.service.impl;

import com.piggy.lwm.domain.OperationLogEntity;
import com.piggy.lwm.mapper.OperationLogMapper;
import com.piggy.lwm.service.OperationLogService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (OperationLog)表服务实现类
 *
 * @author makejava
 * @since 2025-04-10 14:59:44
 */
@Service("operationLogService")
public class OperationLogServiceImpl implements OperationLogService {
    private static int PAGE_DEFAULT = 1;
    private static int SIZE_DEFAULT = 10;
    @Resource
    private OperationLogMapper operationLogMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OperationLogEntity queryById(Integer id) {
        return this.operationLogMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param operationLog 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<OperationLogEntity> queryByPage(OperationLogEntity operationLog, Integer page, Integer size, String orderCol, String orderDirect) {
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
        
        long total = this.operationLogMapper.count(operationLog);
        
        return new PageImpl<>(this.operationLogMapper.queryAllByLimit(operationLog, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param operationLog 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(OperationLogEntity operationLog) {
        return this.operationLogMapper.insert(operationLog) > 0;
    }

    /**
     * 修改数据
     *
     * @param operationLog 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(OperationLogEntity operationLog) {
       return this.operationLogMapper.update(operationLog) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.operationLogMapper.deleteById(id) > 0;
    }
}
