package com.example.employee_management.controller;


import com.example.employee_management.common.utils.Result;
import com.example.employee_management.common.utils.ToolsUtil;
import com.example.employee_management.entity.EmEmployee;
import com.example.employee_management.service.EmDepartmentService;
import com.example.employee_management.service.EmEmployeeService;
import io.swagger.annotations.Api;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Ref;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/em-employee")
@Api(value = "EmEmployeeController", tags = {"员工管理API"})
public class EmEmployeeController {
    @Autowired
    private EmEmployeeService employeeService;

    @GetMapping("/findOne")
    public Result findOne(int id) {
        return Result.success(employeeService.findOne(id));
    }

    @PutMapping("/edit")
    public Result edit(EmEmployee employee) {
        return employeeService.editEmployee(employee) > 0 ? Result.success("修改成功") : Result.fail("修改失败");
    }

    @DeleteMapping("/delete")
    public Result delete(int id) {
        EmEmployee employee = employeeService.findOne(id);
        if (employee == null) {
            return Result.fail("没有该员工");
        }
        return employeeService.deleteById(id) > 0 ? Result.success("删除成功") : Result.fail("删除失败");
    }

    @PutMapping("/add")
    public Result add(EmEmployee employee) {
        return employeeService.addEmployee(employee) > 0 ? Result.success("修改成功") : Result.fail("修改失败");
    }

}
