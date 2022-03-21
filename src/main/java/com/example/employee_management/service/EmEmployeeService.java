package com.example.employee_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.employee_management.entity.EmEmployee;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 员工表 服务类
 * </p>
 */
public interface EmEmployeeService {

    /**
     * 添加员工
     *
     * @param employee 员工信息
     * @return 影响行数
     */
    int addEmployee(EmEmployee employee);

    /**
     * 修改员工信息
     *
     * @param employee 员工信息
     * @return 影响行数
     */
    int editEmployee(EmEmployee employee);

    /**
     * 查找一个员工的信息
     *
     * @param id 员工id
     * @return 员工信息
     */
    EmEmployee findOne(int id);

    /**
     * 根据id删除某个员工
     * @param id 员工id
     * @return 影响行数
     */
    int deleteById(int id);

    IPage<EmEmployee> selectByParam(int currentPage, int pageSize, HashMap<String, String> where);

}
