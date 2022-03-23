package com.example.employee_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.employee_management.common.utils.Result;
import com.example.employee_management.entity.EmProductOrders;
import com.example.employee_management.service.EmProductOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private EmProductOrdersService emProductOrdersService;

    /**
     * 获取所有产品信息
     * @return
     */
    @ApiOperation(" 李超===>获取所有产品信息")
    @GetMapping("/get")
    public Result getAllEmProductOrders()
    {
        List<EmProductOrders> allEmProductOrders = emProductOrdersService.getAllEmProductOrders();
        if(!allEmProductOrders.isEmpty())
        {
            return Result.success(200,"查询成功",allEmProductOrders);
        }
        else
        {
            return Result.fail(400,"查询失败",null);
        }
    }

    /**
     * 通过ID查询产品信息
     * @param id
     * @return
     */
    @ApiOperation(" 李超===>通过ID查询产品信息")
    @GetMapping("{id}")
    public Result getProductById(@PathVariable("id") Integer id)
    {
        EmProductOrders product = emProductOrdersService.getProductById(id);
        if(product != null)
        {
            return Result.success(200,"数据获取成功^_^",product);
        }
        else
        {
            return Result.fail(400,"数据获取失败-_-!",product);
        }
    }


    /**
     * 产品信息分页，多条件查询产品信息
     * @param currentPage
     * @param pageSize
     * @param emProductOrders
     * @return
     */
    @ApiOperation(" 李超===>产品信息分页和多条件查询产品信息")
    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage,@PathVariable int pageSize, EmProductOrders emProductOrders)
    {
        IPage<EmProductOrders> page = emProductOrdersService.getPage(currentPage, pageSize);

        //如果当前页码值大于总页码值，那么重写执行查询操作，使用最大页码值作为当前页码值
        if(page.getPages() < currentPage)
        {
            page = emProductOrdersService.getPage((int)page.getPages(), pageSize);
        }
        return Result.success(200,"分页成功",page);
    }

    /**
     *  修改开通状态
     *  @param type 说明是开通还是停止   id  产品id
     */
    @ApiOperation(" 肖恒宇===> 修改开通状态  type 说明是开通还是停止(stop表示停用 begin表示开通)    id  产品id")
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
