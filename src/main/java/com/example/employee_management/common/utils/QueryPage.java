package com.example.employee_management.common.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 分页参数定义
 *
 * @author tycoding
 * @date 2020/6/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("分页工具类")
public class QueryPage implements Serializable {

    /**
     * 当前页
     */
    @ApiModelProperty("当前页")
    private int page;

    /**
     * 每页的记录数
     */
    @ApiModelProperty("每页的记录数")
    private int limit;
}
