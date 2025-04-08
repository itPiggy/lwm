package com.piggy.lwm.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * (OutboundRecord)实体类
 *
 * @author makejava
 * @since 2025-04-08 15:38:55
 */
@Data
public class OutboundRecordEntity implements Serializable {
    private static final long serialVersionUID = 224273318098811345L;
/**
     * 出库单号（规则：OUT-日期-序号）
     */
    private String recordId;
/**
     * 货物ID
     */
    private String goodsId;
/**
     * 仓库ID
     */
    private String warehouseId;
/**
     * 出库数量
     */
    private Integer quantity;
/**
     * 操作员ID
     */
    private Integer operatorId;
/**
     * 出库时间
     */
    private String outboundTime;

}

