package com.example.employee_management.service.impl;

import com.example.employee_management.entity.EmCorporateInformation;
import com.example.employee_management.mapper.EmCorporateInformationMapper;
import com.example.employee_management.service.EmCorporateInformationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 企业信息管理 服务实现类
 * </p>
 */
@Service
public class EmCorporateInformationServiceImpl   implements EmCorporateInformationService {

    @Autowired
    EmCorporateInformationMapper emCorporateInformationMapper;

/*更改企业信息
* */
    public boolean updateEmCorporateInformation(EmCorporateInformation emCorporateInformation){

        try{
            emCorporateInformationMapper.updateById(emCorporateInformation);
            return true;
        }catch(Exception exception){
            exception.printStackTrace();
            return false;
        }

    }


}
