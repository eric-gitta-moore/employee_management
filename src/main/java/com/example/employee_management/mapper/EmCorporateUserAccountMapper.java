package com.example.employee_management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.employee_management.entity.EmCorporateUserAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 企业用户账号管理 Mapper 接口
 * </p>
 */
@Repository
public interface EmCorporateUserAccountMapper extends BaseMapper<EmCorporateUserAccount> {
    /**
     * 通过关键字查询
     * @param page
     * @param keyword
     * @return
     */
    Page<EmCorporateUserAccount> findByKeyword(@Param("page")Page<EmCorporateUserAccount> page,@Param("keyword") String keyword);

    /**
     * 默认查询
     * @param page
     * @return
     */
    Page<EmCorporateUserAccount> findByKeyword(@Param("page")Page<EmCorporateUserAccount> page);
}
