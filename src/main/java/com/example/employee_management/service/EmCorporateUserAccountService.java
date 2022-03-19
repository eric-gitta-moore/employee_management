package com.example.employee_management.service;

import com.example.employee_management.entity.EmCorporateUserAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 企业用户账号管理 服务类
 * </p>
 */
public interface EmCorporateUserAccountService{
    String getStatus(int id);

    boolean changeStatus(int id,String state);

    boolean deleteAccount(int id);
}
