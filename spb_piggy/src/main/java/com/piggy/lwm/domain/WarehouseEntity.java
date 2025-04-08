package com.piggy.lwm.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * (Warehouse)实体类
 *
 * @author makejava
 * @since 2025-04-08 15:38:55
 */
@Data
public class WarehouseEntity implements Serializable {
    private static final long serialVersionUID = -85736535058670237L;
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

