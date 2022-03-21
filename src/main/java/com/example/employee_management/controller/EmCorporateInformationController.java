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
public class EmCorporateInformationController {


    @Autowired
    EmCorporateInformationServiceImpl emCorporateInformationService;



/**
     * 编辑页面数据处理 存储
 * @param emCorporateInformation    企业信息对象
     */

    @PutMapping("/saveCorporationEdit")
    @ApiOperation("接受企业信息编辑页面，修改到数据库")
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
