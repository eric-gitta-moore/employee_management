package com.example.employee_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.employee_management.common.utils.Result;
import com.example.employee_management.common.utils.SmsUtil;
import com.example.employee_management.service.EmCorporateInformationService;
import com.example.employee_management.service.EmCorporateUserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

import java.util.Map;

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
    public Result changeOperationsStatus(@RequestBody Map<String,String> map){
        String id = map.get("id");
        String newState = map.get("newState");
        if(id==null || newState==null){
            Result.fail("id或新状态不能为空");
        }
        //过去改变状态结果
        String result = service.changeStatus(Integer.parseInt(map.get("id")), newState);
        if (result.equals("succeed")){
            return Result.success(result);
        }else {
            return Result.fail(result);
        }
    }

    /**
     *  注销企业用户
     * @param map id:企业用户id
     * @return
     */
    @DeleteMapping("/deleteAccount")
    @ApiOperation("注销企业用户，id：企业用户id")
    public Result deleteAccount(@RequestBody Map<String,String> map){
        String id = map.get("id");
        if(id==null){
            Result.fail("id不能为空");
        }
        boolean isDeleted = service.deleteAccount(Integer.parseInt(id));
        if(isDeleted){
            return Result.success("注销成功");
        }else {
            return Result.fail("用户不存在");
        }
    }


    /**
     * 获取企业用户信息，keyword为空时搜索全部
     * @param map 接收所有参数 currentPage：页码，keyword：关键字,size:每页的数量，默认值为5
     * @return
     */
    @GetMapping("/getUserAccount")
    @ApiOperation("获取企业用户信息，keyword为空时搜索全部，key关键字对用户名和企业名进行搜索，currentPage：页码，keyword：关键字,size:每页的数量，默认值为5")
    public Result findByKeyword(@RequestBody Map<String,String> map){
        String currentPage = map.get("currentPage");
        String keyword = map.get("keyword");
        String pSize = map.get("size");
        int page=1;
        int size=5;
        if(currentPage!=null){
            page=Integer.parseInt(currentPage);
        }
        if (pSize!=null){
            size=Integer.parseInt(pSize);
        }
        IPage userAccount = service.getUserAccount(page,keyword,size);
        return Result.success(userAccount);
    }


    /**
     * 发送验证码
     * @param phone 手机号
     * @param session
     * @return
     */
    @ApiOperation("发送验证码")
    @GetMapping("/sendSms")
    public Result sendSms(String phone, HttpSession session) {
        if (session.getAttribute("smsCode") == null) {
            HashMap<String, HashMap<String, Object>> codeList = new HashMap<>();
            session.setAttribute("smsCode", codeList);
        }
        HashMap<String, HashMap<String, Object>> list = (HashMap<String, HashMap<String, Object>>) session.getAttribute("smsCode");
        String code = SmsUtil.random();
        HashMap<String, Object> map = new HashMap<>();
        map.put("phone", phone);
        map.put("code", code);
        list.put(phone,map);
        session.setAttribute("smsCode", list);
        System.out.println(session.getAttribute("smsCode"));
        return SmsUtil.sendSms(code, phone) ? Result.success("发送成功") : Result.fail("发送失败");
    }

    /**+
     * 确认修改手机号
     * @param id 企业账号id
     * @param originPhone 原手机号
     * @param originPhoneCode 原手机收到的验证码
     * @param newPhone 新手机号
     * @param newPhoneCode 新手机号收到的验证码
     * @param session
     * @return
     */
    @ApiOperation("确认修改手机号")
    @PutMapping("/submitChangePhone")
    public Result submitChangePhone(String id,
                                    String originPhone, String originPhoneCode,
                                    String newPhone,String newPhoneCode,
                                    HttpSession session) {

        if (session.getAttribute("smsCode") == null) {
            return Result.fail("请先获取验证码");
        }
        HashMap<String, HashMap<String, Object>> list = (HashMap<String, HashMap<String, Object>>) session.getAttribute("smsCode");
        System.out.println(list.toString());
        if (!list.containsKey(originPhone) || !list.containsKey(newPhone)) {
            return Result.fail("请先获取验证码");
        }
        if (list.get(originPhone).get("code").equals(originPhoneCode) &&
                list.get(newPhone).get("code").equals(newPhoneCode)) {
            boolean result = service.changePhone(Integer.parseInt(id), newPhone);
            if (result) {
                session.removeAttribute("smsCode");
            }
            return result?Result.success("修改成功"):Result.fail("修改失败");
        }
        return Result.fail("验证码错误");
    }
}