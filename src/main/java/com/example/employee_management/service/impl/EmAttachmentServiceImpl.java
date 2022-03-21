package com.example.employee_management.service.impl;

import com.example.employee_management.common.utils.FileUtil;
import com.example.employee_management.common.utils.Result;
import com.example.employee_management.entity.EmAttachment;
import com.example.employee_management.entity.EmEmployee;
import com.example.employee_management.exception.GlobalHandler;
import com.example.employee_management.mapper.EmAttachmentMapper;
import com.example.employee_management.service.EmAttachmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.employee_management.service.EmEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

import java.time.LocalDateTime;

/**
 * <p>
 * 附件表 服务实现类
 * </p>
 */
@Service
public class EmAttachmentServiceImpl implements EmAttachmentService {
    @Autowired
    EmAttachmentMapper attachmentMapper;

    /**
     * 上传头像
     *
     * @param employeeId
     * @param file
     * @return
     */
    @Override
    public EmAttachment uploadAvatar(int employeeId, MultipartFile file) throws IOException {
        String filePath;
        filePath = FileUtil.pictureStorage("avatar", file);
        EmAttachment att = new EmAttachment();
        att.setName(file.getOriginalFilename());
        att.setPath(filePath);
        int effectLine = attachmentMapper.insert(att);
        if (effectLine == 0) {
            //异常处理
        }
        //自增id
        System.out.println(att.getId());
        return att;
    }

    /**
     * 获取附件信息
     *
     * @param attachId
     * @return
     */
    @Override
    public EmAttachment getAttachInfo(int attachId) {
        EmAttachment attachment = attachmentMapper.selectById(attachId);
        attachment.setPath(FileUtil.getCatalogue() + attachment.getPath());
        return attachment;
    }
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
