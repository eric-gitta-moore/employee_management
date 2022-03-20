package com.example.employee_management.service.impl;

import com.example.employee_management.common.utils.FileUtil;
import com.example.employee_management.common.utils.Result;
import com.example.employee_management.entity.EmAttachment;
import com.example.employee_management.entity.EmEmployee;
import com.example.employee_management.exception.GlobalHandler;
import com.example.employee_management.mapper.EmAttachmentMapper;
import com.example.employee_management.service.EmAttachmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.employee_management.service.EmEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

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
        System.out.println(att.getId());//自增id
        return att;
    }
}
