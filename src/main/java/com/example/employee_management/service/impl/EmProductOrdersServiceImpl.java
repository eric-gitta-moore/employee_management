package com.example.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.employee_management.entity.EmProductOrders;
import com.example.employee_management.mapper.EmProductOrdersMapper;
import com.example.employee_management.service.EmProductOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品订单 服务实现类
 * </p>
 */
@Service
public class EmProductOrdersServiceImpl implements EmProductOrdersService {

    @Autowired
    EmProductOrdersMapper emProductOrdersMapper;

    /**
     * 修改开通状态
     * @param id 产品id
     * @param  type 开通还是停用
     */

    @Override
    public boolean updateSubscriptionStatus(Integer id,String type) {
        try{
            UpdateWrapper<EmProductOrders> w1=new UpdateWrapper<EmProductOrders>();
            w1.eq("id",id);
            EmProductOrders q1=new EmProductOrders();
            if(type.equals("stop")){
                q1.setSubscriptionStatus("inactive");
            }else if(type.equals("begin")){
                   q1.setSubscriptionStatus("auto_activate");
            }else {
                q1.setSubscriptionStatus("pending_manual_activate");
            }

            Integer update = emProductOrdersMapper.update(q1, w1);
            return update==null ? false:true;
        }catch (Exception o){
            o.printStackTrace();
            return false;

        }


    }
}
