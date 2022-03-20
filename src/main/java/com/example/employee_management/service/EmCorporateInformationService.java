package com.example.employee_management.service;

/**
 * <p>
 * 企业信息管理 服务类
 * </p>
 */
public interface EmCorporateInformationService{

    String changeOperationsStatus(int id, String state);

    boolean cancelEnterprise(int id);



}
