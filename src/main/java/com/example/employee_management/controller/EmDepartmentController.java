package com.example.employee_management.controller;


import com.example.employee_management.common.utils.Result;
import com.example.employee_management.entity.EmDepartment;
import com.example.employee_management.service.EmDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/em-department")
@Api(value = "EmDepartmentController", tags = {"部门增删改查API"})
public class EmDepartmentController {

    @Autowired
    private EmDepartmentService departmentService;

    /**
     * 当前部门id
     */
    private int currentCorporateId = 1;

    /**
     * 获取部门树状下拉表
     *
     * @return
     */
    @ApiOperation("获取部门树状下拉表")
    @GetMapping("/getTreeSelect")
    public Result getTreeSelect() {
        List<EmDepartment> allDepartment = departmentService.selectDeptList(1);
        return Result.success(departmentService.buildDeptTree(allDepartment));
    }

    /**
     * 添加部门
     *
     * @param department 部门信息
     * @return
     */
    @ApiOperation("添加部门")
    @PutMapping("/addDepartment")
    public Result addDepartment(EmDepartment department) {
        Integer result = departmentService.addDepartment(department);
        if (result > 0) {
            return Result.success("添加成功");
        } else {
            return Result.fail("添加失败");
        }
    }

    /**
     * 编辑部门
     *
     * @param department 部门信息
     * @return
     */
    @ApiOperation("编辑部门")
    @PutMapping("/editDepartment")
    public Result editDepartment(EmDepartment department) {
        Integer result = departmentService.editDepartment(department);
        if (result > 0) {
            return Result.success("修改成功");
        } else {
            return Result.fail("修改失败");
        }
    }

    /**
     * 获取部门列表
     * @return
     */
    @ApiOperation("获取部门列表")
    @GetMapping("/getDepartmentList")
    public Result getDepartmentList() {
        return Result.success(departmentService.selectDeptList(this.currentCorporateId));
    }
}
