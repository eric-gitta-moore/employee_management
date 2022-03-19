package com.example.employee_management.mapper;

import com.example.employee_management.entity.EmDepartment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 */
public interface EmDepartmentMapper extends BaseMapper<EmDepartment> {


    /**
     * 查询部门数据
     * @param corporateId 部门信息ID
     * @return
     */
    List<EmDepartment> selectDepartment(Integer corporateId);
}
