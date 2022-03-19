package com.example.employee_management.controller;


import com.example.employee_management.common.utils.Result;
import com.example.employee_management.service.EmCorporateInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 企业信息管理 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/em-corporate-information")
@Api(value = "EmCorporateInformationController",tags = {"刘锦堂===>{改变状态，注销企业}"})
public class EmCorporateInformationController {
    @Autowired
    EmCorporateInformationService service;

    /**
     * 根据Id获取企业运营状态
     * @param id
     * @return
     */
    @ApiOperation("根据Id获取企业运营状态")
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
    @ApiOperation("根据Id更改企业运营状态")
    public Result changeOperationsStatus(int id,String oldState){
        try {
            service.changeOperationsStatus(id,oldState);
            return Result.success("改变状态成功");
        }catch (Exception e){
            return Result.fail("改变状态失败");
        }
    }

    /**
     *  注销企业，并删除所有相关的东西
     * @param id
     * @return
     */
    @DeleteMapping("/cancelEnterprise")
    @ApiOperation("注销企业，并删除所有相关的东西")
    public Result cancelEnterprise(int id){
        boolean succeed = service.cancelEnterprise(id);
        if(succeed){
            return Result.success("注销成功");
        }
        return Result.fail("注销失败");
    }





}
