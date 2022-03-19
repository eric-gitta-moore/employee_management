package com.example.employee_management.service;

import com.example.employee_management.entity.EmDepartment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 */
public interface EmDepartmentService{


    /**
     * 查询部门管理数据
     *
     * @param corporateId 部门信息
     * @return 部门信息集合
     */
    List<EmDepartment> selectDeptList(Integer corporateId);

    /**
     * 构建前端所需要树结构
     *
     * @param depts 部门列表
     * @return 树结构列表
     */
    List<EmDepartment> buildDeptTree(List<EmDepartment> depts);

//    /**
//     * 构建前端所需要下拉树结构
//     *
//     * @param depts 部门列表
//     * @return 下拉树结构列表
//     */
//    List<TreeSelect> buildDeptTreeSelect(List<EmDepartment> depts);

}
