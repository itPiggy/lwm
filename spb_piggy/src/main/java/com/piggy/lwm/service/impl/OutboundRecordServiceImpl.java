package com.piggy.lwm.service.impl;

import com.piggy.lwm.domain.OutboundRecordEntity;
import com.piggy.lwm.mapper.OutboundRecordMapper;
import com.piggy.lwm.service.OutboundRecordService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (OutboundRecord)表服务实现类
 *
 * @author makejava
 * @since 2025-04-10 14:39:42
 */
@Service("outboundRecordService")
public class OutboundRecordServiceImpl implements OutboundRecordService {
    private static int PAGE_DEFAULT = 1;
    private static int SIZE_DEFAULT = 10;
    @Resource
    private OutboundRecordMapper outboundRecordMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OutboundRecordEntity queryById(Integer id) {
        return this.outboundRecordMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param outboundRecord 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<OutboundRecordEntity> queryByPage(OutboundRecordEntity outboundRecord, Integer page, Integer size, String orderCol, String orderDirect) {
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
        
        long total = this.outboundRecordMapper.count(outboundRecord);
        
        return new PageImpl<>(this.outboundRecordMapper.queryAllByLimit(outboundRecord, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param outboundRecord 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(OutboundRecordEntity outboundRecord) {
        return this.outboundRecordMapper.insert(outboundRecord) > 0;
    }

    /**
     * 修改数据
     *
     * @param outboundRecord 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(OutboundRecordEntity outboundRecord) {
       return this.outboundRecordMapper.update(outboundRecord) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.outboundRecordMapper.deleteById(id) > 0;
    }
}
