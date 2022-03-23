package com.example.employee_management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 产品订单
 * </p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("产品信息管理类")
@TableName("em_product_orders")
public class EmProductOrders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("产品id")
    private Integer id;

    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    private String productName;

    /**
     * 套餐名称
     */
    @ApiModelProperty("套餐名称")
    private String packageName;

    /**
     * 套餐版本
     */
    @ApiModelProperty("套餐版本")
    private String packageVersion;

    /**
     * 开通时间
     */
    @ApiModelProperty("开通时间")
    private LocalDateTime activeTime;

    /**
     * 支付方式
     */
    @ApiModelProperty("支付方式")
    private String payment;

    /**
     * 订单状态
     */
    @ApiModelProperty("订单状态")
    private String orderStatus;

    /**
     * 产品开通状态
     */
    @ApiModelProperty("产品开通状态")
    private String subscriptionStatus;

    /**
     * 实付金额
     */
    @ApiModelProperty("实付金额")
    private BigDecimal amountPaid;

    /**
     * 优惠金额
     */
    @ApiModelProperty("优惠金额")
    private BigDecimal couponAmount;

    /**
     * 套餐价格
     */
    @ApiModelProperty("套餐价格")
    private BigDecimal packagePrice;

    /**
     * 套餐时效，开始
     */
    @ApiModelProperty("套餐时效，开始时间")
    private LocalDateTime timeEfficiencyStart;

    /**
     * 套餐时效，结束
     */
    @ApiModelProperty("套餐时效，结束时间")
    private LocalDateTime timeEfficiencyEnd;

    /**
     * 发票状态
     */
    @ApiModelProperty("发票状态")
    private String invoiceStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    /**
     * 创建者
     */
    @ApiModelProperty("创建者")
    private String createBy;

    /**
     * 更新者
     */
    @ApiModelProperty("更新者")
    private String updateBy;


}
