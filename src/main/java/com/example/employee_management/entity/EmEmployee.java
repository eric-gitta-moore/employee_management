package com.example.employee_management.entity;

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
 * 员工表
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("em_employee")
public class EmEmployee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户名
     */
    private String account;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 性别
     */
    private String sex;

    /**
     * 职务(administration:行政,customer_service:客服,design:设计,research_and_development:研发,finance:财务,personnel_matters:人事,it:IT,market:市场,operate:运营,product:产品,purchase:采购,sale:销售,other:其他)
     */
    private String job;

    /**
     * 状态(formal:正式,on_trial:试用,quit:离职,pending_resignation:待离职)
     */
    private String status;

    /**
     * 入职时间
     */
    private LocalDateTime entryTime;

    /**
     * 离职时间
     */
    private LocalDateTime departureTime;

    /**
     * 头像（附件表ID）
     */
    private Integer avatar;

    /**
     * 员工编号
     */
    private String employeeNumber;

    /**
     * 所属部门id
     */
    private Integer departmentId;

    /**
     * 管理范围
     */
    private String managementScope;

    /**
     * 岗位(ordinary_staff:普通员工,manager:经理,executive_director:主管,minister:部长,group_leader:组长,chief_inspector:总监,management_layer:管理层,senior_management:高级管理层,general_manager:总经理)
     */
    private String post;

    /**
     * 类型(full_time:全职,internship:实习,part_time_job:兼职,outsource:外包,dispatch:派遣)
     */
    private Integer type;

    /**
     * 转正时间
     */
    private LocalDateTime regularTime;

    /**
     * 备注
     */
    private String comment;

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
