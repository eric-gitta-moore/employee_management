package com.example.employee_management.controller;


import com.example.employee_management.common.utils.Result;
import com.example.employee_management.entity.EmDepartment;
import com.example.employee_management.service.EmDepartmentService;
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
public class EmDepartmentController {

    @Autowired
    private EmDepartmentService departmentService;

    /**
     * 获取部门树状下拉表
     *
     * @return
     */
    @GetMapping("/getTreeSelect")
    public Result getTreeSelect() {
        List<EmDepartment> allDepartment = departmentService.selectDeptList(1);
        return Result.success(departmentService.buildDeptTree(allDepartment));
    }

    @PutMapping("/addDepartment")
    public Result addDepartment(EmDepartment department) {
        Integer result = departmentService.addDepartment(department);
        if (result > 0) {
            return Result.success("添加成功");
        } else {
            return Result.fail("添加失败");
        }
    }

    @PutMapping("/editDepartment")
    public Result editDepartment(EmDepartment department) {
        Integer result = departmentService.editDepartment(department);
        if (result > 0) {
            return Result.success("修改成功");
        } else {
            return Result.fail("修改失败");
        }
    }
}
