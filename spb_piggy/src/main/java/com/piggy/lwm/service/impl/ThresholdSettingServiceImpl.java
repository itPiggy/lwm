package com.piggy.lwm.service.impl;

import com.piggy.lwm.domain.ThresholdSettingEntity;
import com.piggy.lwm.mapper.ThresholdSettingMapper;
import com.piggy.lwm.service.ThresholdSettingService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ThresholdSetting)表服务实现类
 *
 * @author makejava
 * @since 2025-04-10 14:39:43
 */
@Service("thresholdSettingService")
public class ThresholdSettingServiceImpl implements ThresholdSettingService {
    private static int PAGE_DEFAULT = 1;
    private static int SIZE_DEFAULT = 10;
    @Resource
    private ThresholdSettingMapper thresholdSettingMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ThresholdSettingEntity queryById(Integer id) {
        return this.thresholdSettingMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param thresholdSetting 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<ThresholdSettingEntity> queryByPage(ThresholdSettingEntity thresholdSetting, Integer page, Integer size, String orderCol, String orderDirect) {
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
        
        long total = this.thresholdSettingMapper.count(thresholdSetting);
        
        return new PageImpl<>(this.thresholdSettingMapper.queryAllByLimit(thresholdSetting, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param thresholdSetting 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(ThresholdSettingEntity thresholdSetting) {
        return this.thresholdSettingMapper.insert(thresholdSetting) > 0;
    }

    /**
     * 修改数据
     *
     * @param thresholdSetting 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(ThresholdSettingEntity thresholdSetting) {
       return this.thresholdSettingMapper.update(thresholdSetting) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.thresholdSettingMapper.deleteById(id) > 0;
    }
}
