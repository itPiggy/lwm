package com.piggy.lwm.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2025-04-08 15:38:55
 */
@Data
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 482448243481985373L;
/**
     * 用户唯一ID（自增）
     */
    private Integer userId;
/**
     * 用户名（唯一）
     */
    private String username;
/**
     * SHA-256加密密码
     */
    private String userPwd;
/**
     * 真实姓名
     */
    private String realName;
/**
     * 权限等级（0-系统管理员，1-仓库主管，2-普通员工）
     */
    private String permissionLevel;
/**
     * 创建时间
     */
    private String createTime;
/**
     * 更新时间
     */
    private String updateTime;

}

