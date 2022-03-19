package com.example.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.employee_management.entity.EmCorporateInformation;
import com.example.employee_management.mapper.EmCorporateInformationMapper;
import com.example.employee_management.service.EmCorporateInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 企业信息管理 服务实现类
 * </p>
 */
@Service
public class EmCorporateInformationServiceImpl implements EmCorporateInformationService {
    @Autowired
    EmCorporateInformationMapper mapper;

    /**
     * 获取当前企业的运营状态
     * @param id
     * @return
     */
    @Override
    public String getOperationsStatus(int id) {
        List<EmCorporateInformation> emCorporateInformation = mapper.selectList(new QueryWrapper<EmCorporateInformation>()
                .select("operations_status")
                .eq("id", id));
        updateOperationRecord(id);
        return emCorporateInformation.get(0).getOperationsStatus();
    }

    /**
     * 改变企业运营状态
     * @param id
     * @param oldState
     * @return
     */
    @Override
    public boolean changeOperationsStatus(int id, String oldState) {
        String newState;
        newState = oldState.equals("enable")?"pause":"enable";
        EmCorporateInformation emCorporateInformation = new EmCorporateInformation().setId(id).setOperationsStatus(newState);
        int result =  mapper.update(emCorporateInformation,new UpdateWrapper<EmCorporateInformation>().eq("id",id));
        updateOperationRecord(id);
        return result!=0;
    }

    /**
     * 更新操作记录
     * @param id
     */
    public void updateOperationRecord(int id){
        EmCorporateInformation admin = new EmCorporateInformation().setUpdateBy("admin").setUpdateTime(LocalDateTime.now());
        mapper.update(admin,new UpdateWrapper<EmCorporateInformation>().eq("id",id));
    }

}
