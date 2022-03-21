package com.example.employee_management.service.impl;

import com.example.employee_management.entity.EmPersonUserAccount;
import com.example.employee_management.mapper.EmPersonUserAccountMapper;
import com.example.employee_management.service.EmPersonUserAccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 个人用户账号 服务实现类
 * </p>
 */
@Service
public class EmPersonUserAccountServiceImpl implements EmPersonUserAccountService{
    @Autowired
    EmPersonUserAccountMapper emPersonUserAccountMapper;

    @Override
    @ApiOperation(value = "查询用户信息")
    public List<EmPersonUserAccount> select(){
        return emPersonUserAccountMapper.selectList(null);
    }

    @Override
    @ApiOperation(value = "根据id删除用户信息")
    public int deleteById(int id) {
        int i = emPersonUserAccountMapper.deleteById(id);
        return i;
    }

    @Override
    @ApiOperation(value = "改变用户状态")
    public boolean updateStatus(int id,String status) {
        EmPersonUserAccount PersonById = emPersonUserAccountMapper.selectById(id);
        if(PersonById.getStatus().equals(status)){
            return false;
        }
        else {
            EmPersonUserAccount obj = new EmPersonUserAccount(id, null, null, null, null, status, null, null, null, null, null);
            //更新用户状态
            emPersonUserAccountMapper.updateById(obj);
            return true;
        }
    }

    @Override
    @ApiOperation(value = "搜索用户")
    public EmPersonUserAccount Search(String keywords) {
        EmPersonUserAccount emPerson = emPersonUserAccountMapper.Search(keywords);
        return emPerson;
    }

}
