package com.example.employee_management.service;

import com.example.employee_management.entity.EmCorporateInformation;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * <p>
 * 企业信息管理 服务类
 * </p>
 */
public interface EmCorporateInformationService{
    String getOperationsStatus(int id);

    boolean changeOperationsStatus(int id,String state);

    boolean cancelEnterprise(int id);



}
