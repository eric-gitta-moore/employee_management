package com.example.employee_management.controller;


import com.example.employee_management.common.utils.Result;
import com.example.employee_management.entity.EmProductOrders;
import com.example.employee_management.service.impl.EmProductOrdersServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 产品订单 前端控制器
 * </p>
 */
@RestController
@Api(value = "EmProductOrdersController", tags = {"产品订单api"})
@RequestMapping("/em-product-orders")
public class EmProductOrdersController {


    @Autowired
    EmProductOrdersServiceImpl emProductOrdersService;

    /**
     *  修改开通状态
     *  @param type 说明是开通还是停止   id  产品id
     */
    @ApiOperation("  修改开通状态  type 说明是开通还是停止(stop表示停用 begin表示开通)    id  产品id")
    @PutMapping("/updateSubscriptionStatus/{id}/{type}")
    public Result updateSubscriptionStatus(@PathVariable("id") Integer id,@PathVariable("type") String type) {
        try {
            boolean b = emProductOrdersService.updateSubscriptionStatus(id, type);
            return b==true ? Result.success("操作成功^_^"):Result.fail("操作失败>_<");
        } catch (Exception o) {
            o.printStackTrace();
            return Result.fail("操作失败>_<");
        }
    }


}
