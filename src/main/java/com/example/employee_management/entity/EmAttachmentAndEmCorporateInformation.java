package com.example.employee_management.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("查询结果封装类")
public class EmAttachmentAndEmCorporateInformation {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("企业id")
    private Integer id;

    /**
     * 实体租户名称（企业名称）（企业全称）
     */
    @ApiModelProperty("企业名称")
    private String corporateName;


    /**
     * 审核状态
     */
    @ApiModelProperty("审核状态")
    private String reviewStatus;

    /**
     * 企业法人
     */
    @ApiModelProperty("企业法人")
    private String legalEntity;

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
     * 企业工商营业执照（三证合一），图片路径
     */
    @ApiModelProperty("企业工商营业执照")
    private String businessLicensePath;

    /**
     * 企业法人身份证，正面路径
     */
    @ApiModelProperty("企业法人身份证正面路径")
    private String legalEntityIdentityCardImgPositivePath;

    /**
     * 企业法人身份证，反面路径
     */
    @ApiModelProperty("企业法人身份证反面路径")
    private String legalEntityIdentityCardImgRearPath;

    /**
     * 企业联系人身份证号，正面路径
     */
    @ApiModelProperty("企业联系人身份证号正面路径")
    private String contactPersonIdentityCardImgPositivePath;

    /**
     * 企业联系人身份证号，反面路径
     */
    @ApiModelProperty("企业联系人身份证号反面路径")
    private String contactPersonIdentityCardImgRearPath;

}
