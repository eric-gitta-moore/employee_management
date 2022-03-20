package com.example.employee_management.controller;


import com.example.employee_management.common.utils.Result;
import com.example.employee_management.service.EmCorporateInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
     *  改变企业运营状态
     * @param map id：企业Id，newState：要改变为什么状态
     * @return
     */
    @PutMapping("/changeOperationsStatus")
    @ApiOperation("根据Id更改企业运营状态，id：企业Id，newState：要改变为什么状态")
    public Result changeOperationsStatus(@RequestBody Map<String,String> map){
        String id = map.get("id");
        String newState = map.get("newState");
        if(id==null || newState==null){
            return Result.fail("id或newState不能为空");
        }
        //获取修改结果
        String result = service.changeOperationsStatus(Integer.parseInt(id), newState);
        if(result.equals("succeed")){
            return Result.success(result);
        }else {
            return Result.fail(result);
        }



    }

    /**
     *
     * @param map id：企业Id
     * @return
     */
    @DeleteMapping("/cancelEnterprise")
    @ApiOperation("注销企业，并删除所有相关的东西，id：企业Id")
    public Result cancelEnterprise(@RequestBody Map<String,String> map){
        String id = map.get("id");
        if(id==null){
            return Result.fail("id不能为空");
        }
        //获取注销结果
        boolean succeed = service.cancelEnterprise(Integer.parseInt(id));
        if(succeed){
            return Result.success("注销成功");
        }
        return Result.fail("注销失败");
    }





}
