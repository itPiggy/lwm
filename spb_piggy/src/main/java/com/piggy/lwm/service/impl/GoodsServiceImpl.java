package com.piggy.lwm.service.impl;

import com.piggy.lwm.domain.GoodsEntity;
import com.piggy.lwm.mapper.GoodsMapper;
import com.piggy.lwm.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Goods)表服务实现类
 *
 * @author makejava
 * @since 2025-04-08 15:38:07
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    private static int PAGE_DEFAULT = 1;
    private static int SIZE_DEFAULT = 10;
    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    @Override
    public GoodsEntity queryById(String goodsId) {
        return this.goodsMapper.queryById(goodsId);
    }

    /**
     * 分页查询
     *
     * @param goods 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<GoodsEntity> queryByPage(GoodsEntity goods, Integer page, Integer size, String orderCol, String orderDirect) {
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
        
        long total = this.goodsMapper.count(goods);
        
        return new PageImpl<>(this.goodsMapper.queryAllByLimit(goods, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(GoodsEntity goods) {
        return this.goodsMapper.insert(goods) > 0;
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(GoodsEntity goods) {
       return this.goodsMapper.update(goods) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String goodsId) {
        return this.goodsMapper.deleteById(goodsId) > 0;
    }
}
