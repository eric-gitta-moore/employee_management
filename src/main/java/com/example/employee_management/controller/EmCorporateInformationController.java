package com.example.employee_management.controller;


import com.example.employee_management.common.utils.QueryPage;
import com.example.employee_management.common.utils.Result;
import com.example.employee_management.entity.EmAttachmentAndEmCorporateInformation;
import com.example.employee_management.entity.EmCorporateInformation;
import com.example.employee_management.service.EmCorporateInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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


    @PostMapping(value = "/queryByCreatime")
    @ApiOperation("朱涵===>根据创建时间来查询并且降序排序")
    public Result queryByCreatime(@RequestBody EmCorporateInformation emCorporateInformation, QueryPage queryPage){
        return  Result.success(service.queryByCreatimeService(queryPage));
    }

    @PostMapping(value = "/queryByName")
    @ApiOperation("朱涵===>根据企业名称查询企业信息")
    public Result queryByName(@RequestBody EmCorporateInformation emCorporateInformation, QueryPage queryPage){
        return  Result.success(service.queryByNameService(emCorporateInformation,queryPage));
    }

    @ApiOperation("朱涵===>根据企业审核的状态字段查询所有未审核的企业")
    @GetMapping(value = "/queryByStatus")
    public Result queryByStatus(){
        List<EmAttachmentAndEmCorporateInformation> listAll = service.queryByStatusService();
        return Result.success(listAll);
    }

    @ApiOperation("朱涵===>查询勾选状态的审核信息")
    @GetMapping ("/queryStatusById/{id}")
    public Result queryStatusById(@PathVariable Integer id){
        EmAttachmentAndEmCorporateInformation allmsg = service.queryStatusByIdService(id);
        return Result.success(allmsg);
    }

    @ApiOperation("朱涵===>进行审核")
    @PutMapping("/updateReviewStatus")
    public Result updateReviewStatus(@RequestBody EmAttachmentAndEmCorporateInformation emAttachmentAndEmCorporateInformation,
                                     @RequestParam("status") Integer status){
        String  result = service.updateCorInfoStatusService(emAttachmentAndEmCorporateInformation, status);
        if (result.equals("succed")){
            return Result.success(result);
        }else {
            return Result.fail(result);
        }
    }


}
