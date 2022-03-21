package com.example.employee_management.controller;


import com.example.employee_management.common.utils.FileUtil;
import com.example.employee_management.common.utils.Result;
import com.example.employee_management.entity.EmAttachment;
import com.example.employee_management.entity.EmCorporateInformation;
import com.example.employee_management.entity.EmProductReview;
import com.example.employee_management.mapper.EmCorporateInformationMapper;
import com.example.employee_management.service.EmAttachmentService;
import com.example.employee_management.service.impl.EmAttachmentServiceImpl;
import com.example.employee_management.service.impl.EmCorporateInformationServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import com.example.employee_management.common.utils.Result;
import com.example.employee_management.service.EmCorporateInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * <p>
 * 企业信息管理 前端控制器
 * </p>
 */
@RestController
@Api(value = "EmCorporateInformationController", tags = {"企业信息管理api"})
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
    @ApiOperation("刘锦堂===>根据Id更改企业运营状态，id：企业Id，newState：要改变为什么状态")
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
    @ApiOperation("刘锦堂===>注销企业，并删除所有相关的东西，id：企业Id")
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


    @Autowired
    EmCorporateInformationServiceImpl emCorporateInformationService;



/**
     * 编辑页面数据处理 存储
 * @param emCorporateInformation    企业信息对象
     */

    @PutMapping("/saveCorporationEdit")
    @ApiOperation("肖恒宇===>接受企业信息编辑页面，修改到数据库")
    public Result saveCorporationEdit(@RequestBody EmCorporateInformation emCorporateInformation){
        try{
            emCorporateInformationService.updateEmCorporateInformation(emCorporateInformation);
            return Result.success("操作成功^_^");
        }catch (Exception o){
             o.printStackTrace();
            return Result.fail("操作失败>_< 服务器异常");
        }
    }



}
