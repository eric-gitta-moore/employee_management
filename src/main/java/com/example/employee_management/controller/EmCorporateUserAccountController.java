package com.example.employee_management.controller;


import com.example.employee_management.common.utils.Result;
import com.example.employee_management.service.EmCorporateInformationService;
import com.example.employee_management.service.EmCorporateUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 企业用户账号管理 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/em-corporate-user-account")
public class EmCorporateUserAccountController {

    @Autowired
    EmCorporateUserAccountService service;


    @GetMapping("/getStatus")
    public Result getOperationsStatus(int id){
        String operationsStatus = service.getStatus(id);
        if(operationsStatus!=null){
            return Result.success(operationsStatus);
        }else{
            return Result.fail("当前用户不存在");
        }
    }

    @PutMapping("/changeStatus")
    public Result changeOperationsStatus(int id,String oldState){
        try {
            service.changeStatus(id,oldState);
            return Result.success("改变状态成功");
        }catch (Exception e){
            return Result.fail("改变状态失败");
        }
    }

    @DeleteMapping("/deleteAccount")
    public Result deleteAccount(int id){
        boolean isDeleted = service.deleteAccount(id);
        if(isDeleted){
            return Result.success("删除成功");
        }else {
            return Result.fail("用户不存在");
        }
    }
}
