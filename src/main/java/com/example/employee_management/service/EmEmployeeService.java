package com.example.employee_management.service;

import com.example.employee_management.entity.EmEmployee;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 员工表 服务类
 * </p>
 */
public interface EmEmployeeService{

    /**
     * 添加员工
     * @param employee 员工信息
     * @return
     */
    boolean addEmployee(EmEmployee employee);

    /**
     * 修改员工信息
     * @param employee 员工信息
     * @return
     */
    boolean editEmployee(EmEmployee employee);

}
