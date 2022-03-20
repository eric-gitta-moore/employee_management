package com.example.employee_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.employee_management.entity.EmCorporateUserAccount;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 企业用户账号管理 服务类
 * </p>
 */
public interface EmCorporateUserAccountService{
    String getStatus(int id);

    boolean changeStatus(int id,String state);

    boolean deleteAccount(int id);


    IPage getUserAccount(int currentPage,String keyword,int size);
}
