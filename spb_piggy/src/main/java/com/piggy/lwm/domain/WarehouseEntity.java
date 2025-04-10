package com.piggy.lwm.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * (Warehouse)实体类
 *
 * @author makejava
 * @since 2025-04-10 14:39:43
 */
@Data
public class WarehouseEntity implements Serializable {
    private static final long serialVersionUID = 558000626914951765L;
    /**
     * 自增主键ID
     */
    private Integer id;
    /**
     * 仓库ID（规则：WH-城市代码-序号）
     */
    private String whId;
    /**
     * 关联用户id
     */
    private Integer whUserId;
    /**
     * 仓库名称
     */
    private String whName;
    /**
     * 最大库容量（单位：立方米）
     */
    private Integer whCapacity;
    /**
     * 详细地址
     */
    private String whLocation;

}

