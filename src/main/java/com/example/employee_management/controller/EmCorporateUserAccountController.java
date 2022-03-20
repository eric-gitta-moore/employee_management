package com.example.employee_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.employee_management.common.utils.Result;
import com.example.employee_management.service.EmCorporateInformationService;
import com.example.employee_management.service.EmCorporateUserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
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



    @ApiOperation("根据Id更改企业用户状态，id 企业用户id，newState 要改变的状态")
    @PutMapping("/changeStatus")
    public Result changeOperationsStatus(@RequestParam(name = "id") int id,@RequestParam(name = "newState") String newState){
        //过去改变状态结果
        String result = service.changeStatus(id,newState);
        if (result.equals("succeed")){
            return Result.success(result);
        }else {
            return Result.fail(result);
        }
    }

    @DeleteMapping("/deleteAccount")
    @ApiOperation("注销企业用户，id：企业用户id")
    public Result deleteAccount(@RequestParam(name = "id") int id){
        boolean isDeleted = service.deleteAccount(id);
        if(isDeleted){
            return Result.success("注销成功");
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
    @ApiOperation("获取企业用户信息，keyword为空时搜索全部，key关键字对用户名和企业名进行搜索，currentPage：页码，keyword：关键字,size:每页的数量，默认值为5")
    public Result findByKeyword(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                                @RequestParam(name = "keyword",required = false) String keyword,
                                @RequestParam(name = "size",defaultValue = "5")Integer size){
        IPage userAccount = service.getUserAccount(currentPage,keyword,size);
        return Result.success(userAccount);
    }
}
