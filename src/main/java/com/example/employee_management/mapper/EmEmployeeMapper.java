package com.example.employee_management.mapper;

import com.example.employee_management.entity.EmEmployee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 */
@Repository
public interface EmEmployeeMapper extends BaseMapper<EmEmployee> {

}
