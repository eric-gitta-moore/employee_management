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
import java.time.LocalDateTime;

/**
 * <p>
 * 企业信息管理
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("em_corporate_information")
@ApiModel("企业信息管理类")
public class EmCorporateInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("企业在企业信息表中的ID")
    private Integer id;

    /**
     * 实体租户名称（企业名称）（企业全称）
     */
    @ApiModelProperty("企业名称")
    private String corporateName;

    /**
     * 企业联系人（企业管理员）
     */
    @ApiModelProperty("企业联系人")
    private String corporateContactPersonName;

    /**
     * 实体租户编号
     */
    @ApiModelProperty("实体租户编号")
    private String tenantsNumber;

    /**
     * 运营状态
     */
    @ApiModelProperty("运营状态")
    private String operationsStatus;

    /**
     * 审核状态 
     */
    @ApiModelProperty("审核状态")
    private String reviewStatus;

    /**
     * 时效,开始
     */
    @ApiModelProperty("套餐开始时间")
    private LocalDateTime timeEfficiencyStart;

    /**
     * 时效,结束
     */
    @ApiModelProperty("套餐结束时间")
    private LocalDateTime timeEfficiencyEnd;

    /**
     * 企业logo
     */
    @ApiModelProperty("企业logo")
    private Integer logo;

    /**
     * 所属行业
     */
    @ApiModelProperty("所属行业")
    private String industry;

    /**
     * 企业法人
     */
    @ApiModelProperty("企业法人")
    private String legalEntity;

    /**
     * 企业联系人电话
     */
    @ApiModelProperty("企业联系人电话")
    private String contactPhone;

    /**
     * 企业简介
     */
    @ApiModelProperty("企业简介")
    private String summary;

    /**
     * 统一社会信用代码
     */
    @ApiModelProperty("统一社会信用代码")
    private String certificateForUniformSocialCreditCode;

    /**
     * 企业工商营业执照（三证合一），图片
     */
    @ApiModelProperty("企业工商营业执照（三证合一），图片")
    private Integer businessLicense;

    /**
     * 企业法人身份证号
     */
    @ApiModelProperty("企业法人身份证号")
    private String legalEntityIdentityCard;

    /**
     * 企业法人身份证，正面（国徽），图片
     */
    @ApiModelProperty("企业法人身份证，正面（国徽），图片")
    private Integer legalEntityIdentityCardImgPositive;

    /**
     * 企业法人身份证，反面（人像），图片
     */
    @ApiModelProperty("企业法人身份证，反面（人像），图片")
    private Integer legalEntityIdentityCardImgRear;

    /**
    * 企业联系人身份证号
    */
    @ApiModelProperty("企业联系人身份证号")
    private String contactPersonIdentityCard;

    /**
     * 企业联系人身份证号，正面（国徽），图片
     */
    @ApiModelProperty("企业联系人身份证号，正面（国徽），图片")
    private Integer contactPersonIdentityCardImgPositive;

    /**
     * 企业联系人身份证号，反面（人像），图片
     */
    @ApiModelProperty("企业联系人身份证号，反面（人像），图片")
    private Integer contactPersonIdentityCardImgRear;

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
