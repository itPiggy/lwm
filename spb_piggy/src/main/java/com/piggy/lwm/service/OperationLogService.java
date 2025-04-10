package com.piggy.lwm.service;

import com.piggy.lwm.domain.OperationLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (OperationLog)表服务接口
 *
 * @author makejava
 * @since 2025-04-10 14:59:44
 */
public interface OperationLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OperationLogEntity queryById(Integer id);

    /**
     * 分页查询
     *
     * @param operationLog 筛选条件
     * @return 查询结果
     */
    Page<OperationLogEntity> queryByPage(OperationLogEntity operationLog, Integer page, Integer size, String orderCol, String orderDirect);

    /**
     * 新增数据
     *
     * @param operationLog 实例对象
     * @return 实例对象
     */
    boolean insert(OperationLogEntity operationLog);

    /**
     * 修改数据
     *
     * @param operationLog 实例对象
     * @return 实例对象
     */
    boolean update(OperationLogEntity operationLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
