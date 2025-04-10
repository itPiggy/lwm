package com.piggy.lwm.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * (ThresholdSetting)实体类
 *
 * @author makejava
 * @since 2025-04-10 14:39:42
 */
@Data
public class ThresholdSettingEntity implements Serializable {
    private static final long serialVersionUID = -24945563716073388L;
    /**
     * 自增主键ID
     */
    private Integer id;
    /**
     * 货物ID
     */
    private String goodsId;
    /**
     * 仓库ID
     */
    private String warehouseId;
    /**
     * 最低库存阈值
     */
    private Integer minQuantity;

}

