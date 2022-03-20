package com.example.employee_management.mapper;

import com.example.employee_management.entity.EmEmployee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 */
@Repository
public interface EmEmployeeMapper extends BaseMapper<EmEmployee> {
    @Override
    int insert(EmEmployee entity);

    @Override
    int updateById(EmEmployee entity);

    @Override
    EmEmployee selectById(Serializable id);

    @Override
    int deleteById(Serializable id);
}
