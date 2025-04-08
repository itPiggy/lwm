package com.piggy.lwm.service;

import com.piggy.lwm.domain.GoodsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2025-04-08 15:38:07
 */
public interface GoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    GoodsEntity queryById(String goodsId);

    /**
     * 分页查询
     *
     * @param goods 筛选条件
     * @return 查询结果
     */
    Page<GoodsEntity> queryByPage(GoodsEntity goods, Integer page, Integer size, String orderCol, String orderDirect);

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    boolean insert(GoodsEntity goods);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    boolean update(GoodsEntity goods);

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    boolean deleteById(String goodsId);

}
