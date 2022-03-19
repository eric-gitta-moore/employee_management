package com.example.employee_management.controller;


import com.example.employee_management.common.utils.Result;
import com.example.employee_management.entity.EmDepartment;
import com.example.employee_management.service.EmDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/em-department")
public class EmDepartmentController {

    @Autowired
    private EmDepartmentService departmentService;

    @GetMapping("getTreeSelect")
    public Result getTreeSelect() {
        List<EmDepartment> allDepartment = departmentService.selectDeptList(1);
//        return Result.success(allDepartment);
        return Result.success(departmentService.buildDeptTree(allDepartment));
    }
}
