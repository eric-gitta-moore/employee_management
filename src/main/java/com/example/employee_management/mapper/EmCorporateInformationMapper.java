package com.example.employee_management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.employee_management.entity.EmAttachmentAndEmCorporateInformation;
import com.example.employee_management.entity.EmCorporateInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 企业信息管理 Mapper 接口
 * </p>
 */
@Component
public interface EmCorporateInformationMapper extends BaseMapper<EmCorporateInformation> {

    //根据企业id查询所有联合信息
    EmAttachmentAndEmCorporateInformation getAllMsg(Integer id);

    //根据创建时间进行排序
    Page<EmCorporateInformation> sortByTime(@Param("page") Page<EmCorporateInformation> page);

}
