package com.piggy.lwm.service;

import com.piggy.lwm.domain.ThresholdSettingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ThresholdSetting)表服务接口
 *
 * @author makejava
 * @since 2025-04-08 15:38:55
 */
public interface ThresholdSettingService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    ThresholdSettingEntity queryById(String goodsId);

    /**
     * 分页查询
     *
     * @param thresholdSetting 筛选条件
     * @return 查询结果
     */
    Page<ThresholdSettingEntity> queryByPage(ThresholdSettingEntity thresholdSetting, Integer page, Integer size, String orderCol, String orderDirect);

    /**
     * 新增数据
     *
     * @param thresholdSetting 实例对象
     * @return 实例对象
     */
    boolean insert(ThresholdSettingEntity thresholdSetting);

    /**
     * 修改数据
     *
     * @param thresholdSetting 实例对象
     * @return 实例对象
     */
    boolean update(ThresholdSettingEntity thresholdSetting);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    boolean deleteById(String goodsId);

}
