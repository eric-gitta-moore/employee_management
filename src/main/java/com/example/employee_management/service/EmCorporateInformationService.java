package com.example.employee_management.service;

import com.example.employee_management.entity.EmCorporateInformation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 企业信息管理 服务类
 * </p>
 */
public interface EmCorporateInformationService{


/**
 *         更改企业信息
 */

     boolean updateEmCorporateInformation(EmCorporateInformation emCorporateInformation);



}
