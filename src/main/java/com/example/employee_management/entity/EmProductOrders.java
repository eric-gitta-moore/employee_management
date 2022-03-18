package com.example.employee_management.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 产品订单
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("em_product_orders")
public class EmProductOrders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 套餐名称
     */
    private String packageName;

    /**
     * 套餐版本
     */
    private String packageVersion;

    /**
     * 开通时间
     */
    private LocalDateTime activeTime;

    /**
     * 支付方式
     */
    private String payment;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 产品开通状态
     */
    private String subscriptionStatus;

    /**
     * 实付金额
     */
    private BigDecimal amountPaid;

    /**
     * 优惠金额
     */
    private BigDecimal couponAmount;

    /**
     * 套餐价格
     */
    private BigDecimal packagePrice;

    /**
     * 套餐时效，开始
     */
    private LocalDateTime timeEfficiencyStart;

    /**
     * 套餐时效，结束
     */
    private LocalDateTime timeEfficiencyEnd;

    /**
     * 发票状态
     */
    private String invoiceStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 更新者
     */
    private String updateBy;


}
