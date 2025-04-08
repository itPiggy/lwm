package com.piggy.lwm.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * (ThresholdSetting)实体类
 *
 * @author makejava
 * @since 2025-04-08 15:38:55
 */
@Data
public class ThresholdSettingEntity implements Serializable {
    private static final long serialVersionUID = 184895409815616379L;
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

