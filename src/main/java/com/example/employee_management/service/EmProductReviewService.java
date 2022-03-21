package com.example.employee_management.service;

import com.example.employee_management.entity.EmProductReview;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 产品提交审核 服务类
 * </p>
 */

public interface EmProductReviewService{

   /**
    *存储提交审核阶段的数据
    */

     boolean saveProductCheckInformation(EmProductReview emProductReview);

   /**
    *  提供审核页面展示的数据
    */

    EmProductReview provideProductionInformation(Integer id);


}
