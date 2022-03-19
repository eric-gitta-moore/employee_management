package com.example.employee_management.service.impl;

import com.example.employee_management.entity.EmEmployee;
import com.example.employee_management.mapper.EmEmployeeMapper;
import com.example.employee_management.service.EmEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 */
@Service
public class EmEmployeeServiceImpl implements EmEmployeeService {
    @Autowired
    private EmEmployeeMapper employeeMapper;

    /**
     * 添加员工
     *
     * @param employee 员工信息
     * @return
     */
    @Override
    public boolean addEmployee(EmEmployee employee) {
        employeeMapper.insert(employee);
        return false;
    }

    /**
     * 修改员工信息
     *
     * @param employee 员工信息
     * @return
     */
    @Override
    public boolean editEmployee(EmEmployee employee) {
        return false;
    }
}
