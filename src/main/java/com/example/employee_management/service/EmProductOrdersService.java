package com.example.employee_management.service;

import com.example.employee_management.entity.EmProductOrders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 产品订单 服务类
 * </p>
 */
public interface EmProductOrdersService{

    /**
     *修改开通状态
     */
    boolean updateSubscriptionStatus(Integer id,String type);

}
