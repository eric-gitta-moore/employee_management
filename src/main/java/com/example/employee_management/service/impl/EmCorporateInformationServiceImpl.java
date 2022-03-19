package com.example.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.employee_management.common.utils.FileUtil;
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
     *  注销企业
     *  并且删除企业有关文件
     * @param id
     * @return 返回结果
     */
    @Override
    public boolean cancelEnterprise(int id) {
        List<String> imgUrl = mapper.getImgUrl(id);
        FileUtil.deleteFile((String[]) imgUrl.toArray());
        String logo = mapper.selectList(new QueryWrapper<EmCorporateInformation>().select("logo").eq("id",id)).get(0).getLogo();
        FileUtil.deleteFile(logo);
        return mapper.cancelEnterprise(id);

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
