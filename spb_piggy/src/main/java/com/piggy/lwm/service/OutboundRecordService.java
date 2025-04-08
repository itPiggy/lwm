package com.piggy.lwm.service;

import com.piggy.lwm.domain.OutboundRecordEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (OutboundRecord)表服务接口
 *
 * @author makejava
 * @since 2025-04-08 15:38:55
 */
public interface OutboundRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param recordId 主键
     * @return 实例对象
     */
    OutboundRecordEntity queryById(String recordId);

    /**
     * 分页查询
     *
     * @param outboundRecord 筛选条件
     * @return 查询结果
     */
    Page<OutboundRecordEntity> queryByPage(OutboundRecordEntity outboundRecord, Integer page, Integer size, String orderCol, String orderDirect);

    /**
     * 新增数据
     *
     * @param outboundRecord 实例对象
     * @return 实例对象
     */
    boolean insert(OutboundRecordEntity outboundRecord);

    /**
     * 修改数据
     *
     * @param outboundRecord 实例对象
     * @return 实例对象
     */
    boolean update(OutboundRecordEntity outboundRecord);

    /**
     * 通过主键删除数据
     *
     * @param recordId 主键
     * @return 是否成功
     */
    boolean deleteById(String recordId);

}
