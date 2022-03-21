package com.example.employee_management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.employee_management.entity.EmProductOrders;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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
    /**
     * 获取所有的产品信息
     * @return
     */
    public List<EmProductOrders> getAllEmProductOrders();

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    public EmProductOrders getProductById(Integer id);

    /**
     * 做分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    public IPage<EmProductOrders> getPage(int currentPage, int pageSize);

    /**
     * 做多条件查询
     * @param currentPage
     * @param pageSize
     * @param emProductOrders
     * @return
     */
    public IPage<EmProductOrders> getPage(int currentPage, int pageSize, EmProductOrders emProductOrders);

}
