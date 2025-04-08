package com.piggy.lwm.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * (OperationLog)实体类
 *
 * @author makejava
 * @since 2025-04-08 15:38:55
 */
@Data
public class OperationLogEntity implements Serializable {
    private static final long serialVersionUID = 654926298247154552L;
/**
     * 日志ID（自增）
     */
    private Integer logId;
/**
     * 操作用户ID
     */
    private Integer userId;
/**
     * 操作类型（如入库/出库/权限修改）
     */
    private String operationType;
/**
     * 操作对象ID（如入库单号）
     */
    private String targetId;
/**
     * 操作详情（JSON格式）
     */
    private String details;
/**
     * 操作时间
     */
    private String timestamp;

}

