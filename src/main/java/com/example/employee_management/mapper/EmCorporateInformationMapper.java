package com.example.employee_management.mapper;

import com.example.employee_management.entity.EmCorporateInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 企业信息管理 Mapper 接口
 * </p>
 */
@Repository
public interface EmCorporateInformationMapper extends BaseMapper<EmCorporateInformation> {
    /**
     * 企业注销，删除企业有关的所有信息
     * @param id
     * @return
     */
    boolean cancelEnterprise(int id);

    //根据企业id查询所有联合信息
    EmAttachmentAndEmCorporateInformation getAllMsg(Integer id);

    //根据创建时间进行排序
    Page<EmCorporateInformation> sortByTime(@Param("page") Page<EmCorporateInformation> page);

    /**
     * 获取图片的url
     * @param id
     * @return
     */
    List<String> getImgUrl(int id);
}
