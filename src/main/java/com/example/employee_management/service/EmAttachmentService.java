package com.example.employee_management.service;

import com.example.employee_management.common.utils.Result;
import com.example.employee_management.entity.EmAttachment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

/**
 * <p>
 * 附件表 服务类
 * </p>
 */
public interface EmAttachmentService {
    /**
     * 上传头像
     *
     * @param file
     * @return
     */
    EmAttachment uploadAvatar(int employeeId, MultipartFile file) throws IOException;


}
