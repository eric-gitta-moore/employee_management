package com.example.employee_management.service;


import com.example.employee_management.entity.EmPersonUserAccount;

import java.util.List;

/**
 * <p>
 * 个人用户账号 服务类
 * </p>
 */
public interface EmPersonUserAccountService{
//    查询用户信息
    List<EmPersonUserAccount> select();
//    根据id删除用户信息
    int deleteById(int id);
//    改变用户状态
    boolean updateStatus(int id,String status);
//    搜索用户
    EmPersonUserAccount Search(String keywords);
}
