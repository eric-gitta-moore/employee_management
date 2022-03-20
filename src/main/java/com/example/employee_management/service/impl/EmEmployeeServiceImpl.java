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
    public int addEmployee(EmEmployee employee) {
        return employeeMapper.insert(employee);
    }

    /**
     * 修改员工信息
     *
     * @param employee 员工信息
     * @return
     */
    @Override
    public int editEmployee(EmEmployee employee) {
        return employeeMapper.updateById(employee);
    }

    /**
     * 查找一个员工的信息
     *
     * @param id 员工id
     * @return
     */
    @Override
    public EmEmployee findOne(int id) {
        return employeeMapper.selectById(id);
    }

    /**
     * 根据id删除某个员工
     *
     * @param id 员工id
     * @return 影响行数
     */
    @Override
    public int deleteById(int id) {
        return employeeMapper.deleteById(id);
    }
}
