package com.example.employee_management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.employee_management.entity.EmEmployee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

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

    /**
     * 根据条件翻页查询
     *
     * @param keyword        关键词
     * @param entryTimeStart 入职时间开始
     * @param entryTimeEnd   入职时间结束
     * @param status         员工状态
     * @param type           类型
     * @param page
     * @return
     */
    IPage<EmEmployee> selectPage(IPage<?> page,
                                 @Param("keyword") String keyword,
                                 @Param("entryTimeStart") String entryTimeStart,
                                 @Param("entryTimeEnd") String entryTimeEnd,
                                 @Param("status") String status,
                                 @Param("type") String type
    );
}
