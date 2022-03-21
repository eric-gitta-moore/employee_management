package com.example.employee_management.mapper;

import com.example.employee_management.entity.EmAttachment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 附件表 Mapper 接口
 * </p>
 */
@Mapper
@Repository
public interface EmAttachmentMapper extends BaseMapper<EmAttachment> {


    @Override
    int insert(EmAttachment entity);

    /**
     * 将图片路径保存进附件表，并返回其在附件表中的ID
     * @param path
     * @return
     */
    public Integer savePicturePath(EmAttachment path);

}
