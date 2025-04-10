package com.piggy.lwm.service;

import com.piggy.lwm.domain.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2025-04-10 14:39:43
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserEntity queryById(Integer id);

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    Page<UserEntity> queryByPage(UserEntity user, Integer page, Integer size, String orderCol, String orderDirect);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    boolean insert(UserEntity user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    boolean update(UserEntity user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
