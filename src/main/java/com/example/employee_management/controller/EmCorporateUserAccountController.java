package com.example.employee_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.employee_management.common.utils.Result;
import com.example.employee_management.service.EmCorporateInformationService;
import com.example.employee_management.service.EmCorporateUserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 企业用户账号管理 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/em-corporate-user-account")
@Api(value = "EmCorporateUserAccountController",tags = {"刘锦堂===>企业用户账号管理接口"})
public class EmCorporateUserAccountController {

    @Autowired
    EmCorporateUserAccountService service;


    @ApiOperation("根据Id获取企业用户状态，id：企业用户id")
    @GetMapping("/getStatus")
    public Result getOperationsStatus(int id){
        String operationsStatus = service.getStatus(id);
        if(operationsStatus!=null){
            return Result.success(operationsStatus);
        }else{
            return Result.fail("当前用户不存在");
        }
    }

    @ApiOperation("根据Id更改企业用户状态，id 企业用户id，oldState 当前的状态")
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
    @ApiOperation("删除企业用户，id：企业用户id")
    public Result deleteAccount(int id){
        boolean isDeleted = service.deleteAccount(id);
        if(isDeleted){
            return Result.success("删除成功");
        }else {
            return Result.fail("用户不存在");
        }
    }


    /**
     * 获取企业用户信息，keyword为空时搜索全部
     * @param currentPage
     * @param keyword
     * @return
     */
    @GetMapping("/getUserAccount")
    @ApiOperation("获取企业用户信息，keyword为空时搜索全部，key关键字对用户名和企业名进行搜索，currentPage：页码，keyword：关键字")
    public Result findByKeyword(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                                @RequestParam(name = "keyword") String keyword ){
        IPage userAccount = service.getUserAccount(currentPage,keyword);
        return Result.success(userAccount);
    }
}
