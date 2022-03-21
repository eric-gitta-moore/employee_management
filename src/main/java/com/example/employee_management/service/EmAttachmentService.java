package com.example.employee_management.service;

import com.example.employee_management.entity.EmAttachment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 附件表 服务类
 * </p>
 */
public interface EmAttachmentService{
    /**
     *   修改编辑企业信息
     */


     boolean updateEmAttachment(EmAttachment emAttachment);



    /**
     *  文件存储
     */

      Integer saveFile(String path);


}
