package com.example.employee_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 企业用户账号管理 服务类
 * </p>
 */
public interface EmCorporateUserAccountService{

    String changeStatus(int id, String state);

    boolean deleteAccount(int id);


    IPage getUserAccount(int currentPage,String keyword,int size);
}
