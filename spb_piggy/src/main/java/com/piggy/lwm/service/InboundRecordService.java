package com.piggy.lwm.service;

import com.piggy.lwm.domain.InboundRecordEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (InboundRecord)表服务接口
 *
 * @author makejava
 * @since 2025-04-10 14:39:42
 */
public interface InboundRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    InboundRecordEntity queryById(Integer id);

    /**
     * 分页查询
     *
     * @param inboundRecord 筛选条件
     * @return 查询结果
     */
    Page<InboundRecordEntity> queryByPage(InboundRecordEntity inboundRecord, Integer page, Integer size, String orderCol, String orderDirect);

    /**
     * 新增数据
     *
     * @param inboundRecord 实例对象
     * @return 实例对象
     */
    boolean insert(InboundRecordEntity inboundRecord);

    /**
     * 修改数据
     *
     * @param inboundRecord 实例对象
     * @return 实例对象
     */
    boolean update(InboundRecordEntity inboundRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
