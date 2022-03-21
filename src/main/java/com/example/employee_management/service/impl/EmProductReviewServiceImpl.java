package com.example.employee_management.service.impl;

import com.example.employee_management.entity.EmAttachment;
import com.example.employee_management.entity.EmProductReview;
import com.example.employee_management.mapper.EmAttachmentMapper;
import com.example.employee_management.mapper.EmProductReviewMapper;
import com.example.employee_management.service.EmProductReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 产品提交审核 服务实现类
 * </p>
 */
@Service
public class EmProductReviewServiceImpl implements EmProductReviewService {

    @Autowired
    EmProductReviewMapper emProductReviewMapper;



    /**
     *  储存产品提交审核中的信息
     */

    @Override
    public boolean saveProductCheckInformation(EmProductReview emProductReview) {
        try {
            emProductReviewMapper.insert(emProductReview);
            return true;
        }catch (Exception o){
           o.printStackTrace();
           return false;
        }

    }


    /**
     *提供审核展示数据
     * @param id 产品id
     * @return  emProductReview 产品审核表数据
     */

    @Override
    public EmProductReview provideProductionInformation(Integer id) {
         try{
             EmProductReview emProductReview = emProductReviewMapper.selectById(id);

             return emProductReview ;
         }catch (Exception o){
            o.printStackTrace();
            return null ;
         }
    }


}
