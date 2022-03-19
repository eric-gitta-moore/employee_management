package com.example.employee_management.controller;


import com.example.employee_management.common.utils.Result;
import com.example.employee_management.service.EmCorporateInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 企业信息管理 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/em-corporate-information")
public class EmCorporateInformationController {
    @Autowired
    EmCorporateInformationService service;


    @GetMapping("/operationsStatus")
    public Result getOperationsStatus(int id){
        String operationsStatus = service.getOperationsStatus(id);
        if(operationsStatus!=null){
            return Result.success(operationsStatus);
        }else{
            return Result.fail("当前企业不存在");
        }
    }

    @PutMapping("/changeOperationsStatus")
    public Result changeOperationsStatus(int id,String oldState){
        try {
            service.changeOperationsStatus(id,oldState);
            return Result.success("改变状态成功");
        }catch (Exception e){
            return Result.fail("改变状态失败");
        }
    }







}
