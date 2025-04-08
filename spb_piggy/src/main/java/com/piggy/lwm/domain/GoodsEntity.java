package com.piggy.lwm.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2025-04-08 15:38:07
 */
@Data
public class GoodsEntity implements Serializable {
    private static final long serialVersionUID = -17536399428357645L;
/**
     * 货物ID（规则：G-分类代码-日期-序号）
     */
    private String goodsId;
/**
     * 货物名称
     */
    private String goodsName;
/**
     * 分类（如电子产品/日用品）
     */
    private String category;
/**
     * 供应商名称
     */
    private String supplier;
/**
     * 保质期（天数）
     */
    private Integer shelfLife;

}

