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

    /**
     * 更改手机号码
     * @param id 账号id
     * @param phone 手机号
     * @return 更改是否成功
     */
    boolean changePhone(int id, String phone);

    /**
     * 更改密码
     * @param id 账号ID
     * @param pwd 密码
     * @return
     */
    boolean changePasswd(int id, String pwd);
}
