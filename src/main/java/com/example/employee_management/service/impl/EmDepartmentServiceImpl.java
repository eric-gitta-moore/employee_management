package com.example.employee_management.service.impl;

import com.example.employee_management.entity.EmDepartment;
import com.example.employee_management.mapper.EmDepartmentMapper;
import com.example.employee_management.service.EmDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 */
@Service
public class EmDepartmentServiceImpl implements EmDepartmentService {

    @Autowired
    private EmDepartmentMapper departmentMapper;

    /**
     * 查询部门管理数据
     *
     * @param corporateId 部门信息
     * @return 部门信息集合
     */
    @Override
    public List<EmDepartment> selectDeptList(Integer corporateId) {
        return departmentMapper.selectDepartment(corporateId);
    }

    /**
     * 构建前端所需要树结构
     *
     * @param depts 部门列表
     * @return 树结构列表
     */
    @Override
    public List<EmDepartment> buildDeptTree(List<EmDepartment> depts) {
        List<EmDepartment> deptMap = new ArrayList<>();
//        HashMap<String, Object> second = new HashMap<>();
        //顶级部门
        for (EmDepartment dept : depts) {
            if (dept.getSuperiorDepartment() == 0) {
                deptMap.add(dept);
            }
        }
        //二级部门
        for (EmDepartment dept : depts) {
            if (dept.getSuperiorDepartment() != 0) {
                for (EmDepartment topDept : deptMap) {
                    if (topDept.getId().equals(dept.getSuperiorDepartment())) {
                        topDept.getChildren().add(dept);
                    }
                }
            }
        }
        return deptMap;
    }
}
