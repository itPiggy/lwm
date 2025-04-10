package com.piggy.lwm.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * (InboundRecord)实体类
 *
 * @author makejava
 * @since 2025-04-10 14:39:42
 */
@Data
public class InboundRecordEntity implements Serializable {
    private static final long serialVersionUID = -46295470965929023L;
    /**
     * 自增主键ID
     */
    private Integer id;
    /**
     * 入库单号（规则：IN-日期-序号）
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
     * 入库数量
     */
    private Integer quantity;
    /**
     * 生产日期
     */
    private String productionDate;
    /**
     * 存储位置（如A-01-02）
     */
    private String storageLocation;
    /**
     * 操作员ID
     */
    private Integer operatorId;
    /**
     * 入库时间
     */
    private String inboundTime;

}

