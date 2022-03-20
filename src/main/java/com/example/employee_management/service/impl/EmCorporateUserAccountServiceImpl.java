package com.example.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.employee_management.entity.EmCorporateUserAccount;
import com.example.employee_management.mapper.EmCorporateUserAccountMapper;
import com.example.employee_management.service.EmCorporateUserAccountService;
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
     * 获取当前员工状态，
     * @param id
     * @return
     */
    public String getStatus(int id) {
        List<EmCorporateUserAccount> emCorporateUserAccounts = mapper.selectList(new QueryWrapper<EmCorporateUserAccount>()
                .select("status")
                .eq("id", id));
        updateOperationRecord(id);
        //员工不存在时返回null
        if(emCorporateUserAccounts.size()==0){
            return null;
        }
        return emCorporateUserAccounts.get(0).getStatus();
    }

    /**
     * 改变员工状态
     * @param id
     * @param newState
     * @return
     */
    @Override
    public String changeStatus(int id, String newState) {
        //获取旧状态，判断是否存在或需要修改
        String oldState = getStatus(id);
        if (oldState==null){
            return "用户不存在或已被注销";
        }
        if(oldState.equals(newState)){
            return "已启用或暂停，不要重复请求";
        }
        //更新状态
        EmCorporateUserAccount emCorporateUserAccount = new EmCorporateUserAccount().setId(id).setStatus(newState);
        mapper.update(emCorporateUserAccount,new UpdateWrapper<EmCorporateUserAccount>().eq("id",id));
        updateOperationRecord(id);
        return "succeed";
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
    public IPage getUserAccount(int currentPage,String keyword,int size) {
        Page<EmCorporateUserAccount> page = new Page(currentPage,size);
        mapper.findByKeyword(page, keyword);
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


    /**
     * 更改手机号码
     *
     * @param id    账号id
     * @param phone 手机号
     * @return 更改是否成功
     */
    @Override
    public boolean changePhone(int id, String phone) {
        EmCorporateUserAccount admin = new EmCorporateUserAccount().setPhone(phone);
        updateOperationRecord(id);
        return mapper.update(admin,new UpdateWrapper<EmCorporateUserAccount>().eq("id",id)) > 0;
    }

    /**
     * 更改密码
     *
     * @param id  账号ID
     * @param pwd 密码
     * @return
     */
    @Override
    public boolean changePasswd(int id, String pwd) {
//        EmCorporateUserAccount admin = new EmCorporateUserAccount().setPhone(phone);
//        updateOperationRecord(id);
//        return mapper.update(admin,new UpdateWrapper<EmCorporateUserAccount>().eq("id",id)) > 0;
        return false;
    }
}
