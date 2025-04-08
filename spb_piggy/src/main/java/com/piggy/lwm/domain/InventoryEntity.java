package com.piggy.lwm.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * (Inventory)实体类
 *
 * @author makejava
 * @since 2025-04-08 15:38:55
 */
@Data
public class InventoryEntity implements Serializable {
    private static final long serialVersionUID = -47151061724454966L;
/**
     * 货物ID
     */
    private String goodsId;
/**
     * 仓库ID
     */
    private String warehouseId;
/**
     * 当前库存数量
     */
    private Integer quantity;
/**
     * 最后更新时间
     */
    private String lastUpdated;

}

