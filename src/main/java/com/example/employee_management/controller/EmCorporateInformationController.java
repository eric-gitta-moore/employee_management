package com.example.employee_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.employee_management.common.controller.BaseController;
import com.example.employee_management.common.utils.QueryPage;
import com.example.employee_management.common.utils.Result;
import com.example.employee_management.entity.EmAttachmentAndEmCorporateInformation;
import com.example.employee_management.entity.EmCorporateInformation;
import com.example.employee_management.service.EmCorporateInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 企业信息管理 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/em-corporate-information")
@Api(value = "EmAttachmentController", tags = {"企业信息管理功能接口"})
public class EmCorporateInformationController extends BaseController {

    /**
     * 通过接口进行注入:EmCorporateInformationService
     */
    @Autowired
    EmCorporateInformationService emAttachmentControllerService;


    @PostMapping(value = "/queryByCreatime")
    @ApiOperation("朱涵===>根据创建时间来查询并且降序排序")
    public Result queryByCreatime(@RequestBody EmCorporateInformation emCorporateInformation, QueryPage queryPage){
        return  Result.success(emAttachmentControllerService.queryByCreatimeService(queryPage));
    }

    @PostMapping(value = "/queryByName")
    @ApiOperation("朱涵===>根据企业名称查询企业信息")
    public Result queryByName(@RequestBody EmCorporateInformation emCorporateInformation, QueryPage queryPage){
        return  Result.success(emAttachmentControllerService.queryByNameService(emCorporateInformation,queryPage));
    }

    @ApiOperation("朱涵===>根据企业审核的状态字段查询所有未审核的企业")
    @GetMapping(value = "/queryByStatus")
    public Result queryByStatus(){
        List<EmAttachmentAndEmCorporateInformation> listAll = emAttachmentControllerService.queryByStatusService();
        return Result.success(listAll);
    }

    @ApiOperation("朱涵===>查询勾选状态的审核信息")
    @GetMapping ("/queryStatusById/{id}")
    public Result queryStatusById(@PathVariable Integer id){
        EmAttachmentAndEmCorporateInformation allmsg = emAttachmentControllerService.queryStatusByIdService(id);
        return Result.success(allmsg);
    }

    @ApiOperation("朱涵===>进行审核")
    @PutMapping("/updateReviewStatus")
    public Result updateReviewStatus(@RequestBody EmAttachmentAndEmCorporateInformation emAttachmentAndEmCorporateInformation,
                                     @RequestParam("status") Integer status){
        String  result = emAttachmentControllerService.updateCorInfoStatusService(emAttachmentAndEmCorporateInformation, status);
        if (result.equals("succed")){
            return Result.success(result);
        }else {
            return Result.fail(result);
        }
    }






}
