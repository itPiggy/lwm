package com.piggy.lwm.service.impl;

import com.piggy.lwm.domain.UserEntity;
import com.piggy.lwm.mapper.UserMapper;
import com.piggy.lwm.service.UserService;
import com.piggy.lwm.util.PasswordUtil;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2025-04-10 14:39:43
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static int PAGE_DEFAULT = 1;
    private static int SIZE_DEFAULT = 10;
    @Resource
    private UserMapper userMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserEntity queryById(Integer id) {
        return this.userMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<UserEntity> queryByPage(UserEntity user, Integer page, Integer size, String orderCol, String orderDirect) {
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
        
        long total = this.userMapper.count(user);
        
        return new PageImpl<>(this.userMapper.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(UserEntity user) {
        return this.userMapper.insert(user) > 0;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(UserEntity user) {
       return this.userMapper.update(user) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userMapper.deleteById(id) > 0;
    }

    @Override
    public UserEntity login(UserEntity user) {
        // 将密码进行SHA256哈希处理
        user.setUserPwd(PasswordUtil.digestPwdSHA256(user.getUserPwd()));
        return this.userMapper.login(user);
    }
}
