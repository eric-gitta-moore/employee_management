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


    @PutMapping("/changeOperationsStatus")
    @ApiOperation("根据Id更改企业运营状态，id：企业Id，newState：要改变为什么状态")
    public Result changeOperationsStatus(@RequestParam(name = "id") int id,@RequestParam(name = "newState")String newState){
        //获取修改结果
        String result = service.changeOperationsStatus(id, newState);
        if(result.equals("succeed")){
            return Result.success(result);
        }else {
            return Result.fail(result);
        }



    }

    /**
     *  注销企业，并删除所有相关的东西
     * @param id
     * @return
     */
    @DeleteMapping("/cancelEnterprise")
    @ApiOperation("注销企业，并删除所有相关的东西，id：企业Id")
    public Result cancelEnterprise(@RequestParam(name = "id")int id){
        //获取注销结果
        boolean succeed = service.cancelEnterprise(id);
        if(succeed){
            return Result.success("注销成功");
        }
        return Result.fail("注销失败");
    }





}
