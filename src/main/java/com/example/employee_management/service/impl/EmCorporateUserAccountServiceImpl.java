package com.example.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.employee_management.entity.EmCorporateInformation;
import com.example.employee_management.entity.EmCorporateUserAccount;
import com.example.employee_management.mapper.EmCorporateInformationMapper;
import com.example.employee_management.mapper.EmCorporateUserAccountMapper;
import com.example.employee_management.service.EmCorporateUserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 企业用户账号管理 服务实现类
 * </p>
 */
@Service
public class EmCorporateUserAccountServiceImpl implements EmCorporateUserAccountService {
    @Autowired
    EmCorporateUserAccountMapper mapper;

    /**
     * 获取当前员工状态
     * @param id
     * @return
     */
    @Override
    public String getStatus(int id) {
        List<EmCorporateUserAccount> emCorporateUserAccounts = mapper.selectList(new QueryWrapper<EmCorporateUserAccount>()
                .select("operations_status")
                .eq("id", id));
        updateOperationRecord(id);
        return emCorporateUserAccounts.get(0).getStatus();
    }

    /**
     * 改变员工状态
     * @param id
     * @param oldState
     * @return
     */
    @Override
    public boolean changeStatus(int id, String oldState) {
        String newState;
        newState = oldState.equals("enable")?"pause":"enable";
        EmCorporateUserAccount emCorporateUserAccount = new EmCorporateUserAccount().setId(id).setStatus(newState);
        int result =  mapper.update(emCorporateUserAccount,new UpdateWrapper<EmCorporateUserAccount>().eq("id",id));
        updateOperationRecord(id);
        return result!=0;
    }

    /**
     * 删除企业用户
     * @param id
     * @return
     */
    @Override
    public boolean deleteAccount(int id) {
        int result = mapper.delete(new UpdateWrapper<EmCorporateUserAccount>().eq("id",id));
        return result!=0;
    }

    /**
     * 默认查询
     * @param currentPage
     * @return
     */
    @Override
    public IPage getUserAccount(int currentPage,String keyword) {
        Page<EmCorporateUserAccount> page = new Page(currentPage,5);
        mapper.findByKeyword(page, keyword);
        System.out.println(page.getTotal());
        return page;
    }



    /**
     * 更新操作记录
     * @param id
     */
    public void updateOperationRecord(int id){
        EmCorporateUserAccount admin = new EmCorporateUserAccount().setUpdateBy("admin").setUpdateTime(LocalDateTime.now());
        mapper.update(admin,new UpdateWrapper<EmCorporateUserAccount>().eq("id",id));
    }
}
