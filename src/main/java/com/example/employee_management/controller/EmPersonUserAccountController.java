package com.example.employee_management.controller;


import com.example.employee_management.common.utils.Result;
import com.example.employee_management.entity.EmPersonUserAccount;
import com.example.employee_management.service.impl.EmPersonUserAccountServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 个人用户账号 前端控制器
 * </p>
 */
@Api(value = "用户信息的各种操作和暂停，注销，启动的改变")
@RestController
@RequestMapping("/em-person-user-account")
public class EmPersonUserAccountController{


    @Autowired
    EmPersonUserAccountServiceImpl Service;

    @ApiOperation(value = "展示用户数据")
    @GetMapping("/main")
    public Result personUserAccount(){
        return Result.success(Service.select());
    }


    @GetMapping("/enable")
    @ApiOperation(value = "启动用户")
    public Result enable(@RequestParam("id") int id){
        boolean enable = Service.updateStatus(id, "enable");
        if(enable){
            return Result.success("成功");
        }
        else {
            return Result.fail("失败");
        }
    }


    @GetMapping("/pause")
    @ApiOperation(value = "暂停用户")
    public Result pause(@RequestParam("id") int id){
        boolean pause = Service.updateStatus(id, "pause");
        if(pause){
            return Result.success("成功");
        }
        else {
          return Result.fail("失败");
        }
    }


    @DeleteMapping("/sing_out")
    @ApiOperation(value = "注销用户")
    public Result sing_out(@RequestParam("id") int id){
        Service.deleteById(id);
        return Result.success("成功");
    }

    @GetMapping("/search")
    @ApiOperation(value = "查询用户,keywords，代表用户的名字或者id")
    public Result search(@RequestParam("keywords") String keywords){
        EmPersonUserAccount search = Service.Search(keywords);
        return Result.success(search);
    }

}
