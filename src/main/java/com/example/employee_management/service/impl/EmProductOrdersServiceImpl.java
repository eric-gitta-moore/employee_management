package com.example.employee_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.employee_management.entity.EmProductOrders;
import com.example.employee_management.mapper.EmProductOrdersMapper;
import com.example.employee_management.service.EmProductOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 产品订单 服务实现类
 * </p>
 */
@Service
public class EmProductOrdersServiceImpl implements EmProductOrdersService {



    @Autowired
    private EmProductOrdersMapper emProductOrdersMapper;

    /**
     * 查看所有产品信息
     * @return
     */
    @Override
    public List<EmProductOrders> getAllEmProductOrders() {
        return emProductOrdersMapper.selectList(null);
    }

    /**
     * 通过ID查询产品信息
     * @param id
     * @return
     */
    @Override
    public EmProductOrders getProductById(Integer id) {
        return emProductOrdersMapper.selectById(id);
    }

    /**
     * 分页方法，与多条件查询构成重载
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public IPage<EmProductOrders> getPage(int currentPage, int pageSize) {
        Page<EmProductOrders> page = new Page<EmProductOrders>(currentPage,pageSize);
        emProductOrdersMapper.selectPage(page,null);
        return page;
    }

    /**
     * 分页和多条件查询方法与分页方法重载
     * @param currentPage
     * @param pageSize
     * @param emProductOrders
     * @return
     */
    @Override
    public IPage<EmProductOrders> getPage(int currentPage, int pageSize, EmProductOrders emProductOrders) {
        LambdaQueryWrapper<EmProductOrders> lambdaQueryWrapper = new LambdaQueryWrapper<EmProductOrders>();
        lambdaQueryWrapper.like(emProductOrders.getTimeEfficiencyStart().getSecond()!=0,EmProductOrders::getTimeEfficiencyStart,emProductOrders.getTimeEfficiencyStart());
        lambdaQueryWrapper.like(emProductOrders.getTimeEfficiencyEnd().getSecond()!=0,EmProductOrders::getTimeEfficiencyEnd,emProductOrders.getTimeEfficiencyEnd());
        lambdaQueryWrapper.like(Strings.isNotEmpty(emProductOrders.getProductName()),EmProductOrders::getProductName,emProductOrders.getProductName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(emProductOrders.getPayment()),EmProductOrders::getPayment,emProductOrders.getPayment());
        lambdaQueryWrapper.like(Strings.isNotEmpty(emProductOrders.getOrderStatus()),EmProductOrders::getOrderStatus,emProductOrders.getOrderStatus());

        Page<EmProductOrders> page = new Page<EmProductOrders>(currentPage,pageSize);
        emProductOrdersMapper.selectPage(page,lambdaQueryWrapper);
        return null;
    }

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
