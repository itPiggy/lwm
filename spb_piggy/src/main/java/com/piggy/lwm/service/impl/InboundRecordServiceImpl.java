package com.piggy.lwm.service.impl;

import com.piggy.lwm.domain.InboundRecordEntity;
import com.piggy.lwm.mapper.InboundRecordMapper;
import com.piggy.lwm.service.InboundRecordService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (InboundRecord)表服务实现类
 *
 * @author makejava
 * @since 2025-04-08 15:38:36
 */
@Service("inboundRecordService")
public class InboundRecordServiceImpl implements InboundRecordService {
    private static int PAGE_DEFAULT = 1;
    private static int SIZE_DEFAULT = 10;
    @Resource
    private InboundRecordMapper inboundRecordMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param recordId 主键
     * @return 实例对象
     */
    @Override
    public InboundRecordEntity queryById(String recordId) {
        return this.inboundRecordMapper.queryById(recordId);
    }

    /**
     * 分页查询
     *
     * @param inboundRecord 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<InboundRecordEntity> queryByPage(InboundRecordEntity inboundRecord, Integer page, Integer size, String orderCol, String orderDirect) {
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
        
        long total = this.inboundRecordMapper.count(inboundRecord);
        
        return new PageImpl<>(this.inboundRecordMapper.queryAllByLimit(inboundRecord, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param inboundRecord 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(InboundRecordEntity inboundRecord) {
        return this.inboundRecordMapper.insert(inboundRecord) > 0;
    }

    /**
     * 修改数据
     *
     * @param inboundRecord 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(InboundRecordEntity inboundRecord) {
       return this.inboundRecordMapper.update(inboundRecord) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param recordId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String recordId) {
        return this.inboundRecordMapper.deleteById(recordId) > 0;
    }
}
