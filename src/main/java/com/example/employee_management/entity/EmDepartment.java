package com.example.employee_management.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 部门表
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("em_department")
@ApiModel("部门类实体")
public class EmDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门名称
     */
    @ApiModelProperty("部门名称")
    private String departmentName;

    /**
     * 所属企业
     */
    @ApiModelProperty("所属企业")
    private Integer corporateId;

    /**
     * 上级部门id,0为顶级部门
     */
    @ApiModelProperty("上级部门id,0为顶级部门")
    private Integer superiorDepartment;

    /**
     * 负责人
     */
    @ApiModelProperty("负责人")
    private Integer owner;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String comment;

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


    /** 子部门 */
    @ApiModelProperty("子部门，数据库中没有这个字段")
    private List<EmDepartment> children = new ArrayList<>();


}
