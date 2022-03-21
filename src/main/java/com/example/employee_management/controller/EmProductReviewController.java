package com.example.employee_management.controller;


import com.example.employee_management.common.utils.FileUtil;
import com.example.employee_management.common.utils.Result;
import com.example.employee_management.entity.EmProductReview;
import com.example.employee_management.service.impl.EmProductReviewServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * <p>
 * 产品提交审核 前端控制器
 * </p>
 */
@RestController
@Api(value = " EmProductReviewController", tags = {"产品提交审核api"})
@RequestMapping("/em-product-review")
public class EmProductReviewController {


     @Autowired
    EmProductReviewServiceImpl emProductReviewService;


    /**
     * 存储提交审核时的提交的产品信息
     *
     *
     * @param emProductReview 审核提交产品的信息对象 对象内容除开通理由之外 还需携带产品id    文件的id字符串
     */
    @ApiOperation("存储提交审核时的提交的产品信息")
    @PostMapping("/saveProductCheckInformation")
    public Result saveProductCheckInformation(@RequestBody EmProductReview emProductReview){
        try{
              emProductReview.setCreateTime(LocalDateTime.now());
              emProductReview.setUpdateTime(LocalDateTime.now());
              emProductReview.setCreateBy("admin");
              emProductReview.setUpdateBy("admin");

            emProductReviewService.saveProductCheckInformation(emProductReview);
            return Result.success("操作成功^_^");
        }catch (Exception o){
            o.printStackTrace();

            return Result.fail("操作失败>_<服务器异常");
        }



    }


    /**
     * 提供正在审核中的产品信息
     * @param  id 在展示的产品的id
     * @return  result 包含开通/停用理由 以及展示的照片的文件路径
     */
    @ApiOperation("提供正在审核中的产品信息 包含开通/停用理由 以及展示的照片的文件路径  id 在展示的产品的id")
    @GetMapping("/provideProductionInformation/{id}")
    public Result provideProductionInformation( @PathVariable("id") Integer id){
        try{
            EmProductReview show = emProductReviewService.provideProductionInformation(id);

            return Result.success("操作成功^_^",show);
        }catch (Exception o){
          o.printStackTrace();

          return Result.fail("操作失败>_<");
        }


    }


}
