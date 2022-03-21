package com.example.employee_management.service.impl;

import com.example.employee_management.entity.EmAttachment;
import com.example.employee_management.mapper.EmAttachmentMapper;
import com.example.employee_management.service.EmAttachmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 附件表 服务实现类
 * </p>
 */
@Service
public class EmAttachmentServiceImpl implements EmAttachmentService {

    @Autowired
    EmAttachmentMapper emAttachmentMapper;

    /**
     * 修改编辑企业信息
     */

    @Override
    public boolean updateEmAttachment(EmAttachment emAttachment) {

        try{
            emAttachmentMapper.updateById(emAttachment);
            return true;
        }catch (Exception o){
            o.printStackTrace();
            return false;
        }


    }





    /**
     * 文件存储
     * @return  存储的文件id
     * @param path       文件路径
     */

    @Override
    public Integer saveFile(String path) {
        try {
            EmAttachment q1 = new EmAttachment();
            q1.setPath(path);
            q1.setUpdateBy("admin");
            q1.setCreateBy("admin");
            q1.setComment(path + "描述");
            q1.setCreateTime(LocalDateTime.now());
            q1.setUpdateTime(LocalDateTime.now());

            Integer insert = emAttachmentMapper.insert(q1);

            /**
             *获取文件id
             */

            Integer id = q1.getId();
            return id == null ? null : id;

        } catch (Exception o) {
            o.printStackTrace();
            return null;
        }

    }
}
