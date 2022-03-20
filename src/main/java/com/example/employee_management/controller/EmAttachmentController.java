package com.example.employee_management.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 附件表 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/em-attachment")
public class EmAttachmentController {
    @Autowired
    EmAttachmentService attachmentService;

    @Autowired
    EmEmployeeService employeeService;

    /**
     * 上传头像
     * @param employeeId 员工id
     * @param file 文件
     * @return
     */
    @PutMapping("/uploadAvartar")
    public Result uploadAvatar(String employeeId, MultipartFile file) {
        if (file.isEmpty()) {
            return Result.fail("上传文件不能为空");
        }
        EmEmployee employee = employeeService.findOne(Integer.parseInt(employeeId));
        if (employee == null) {
            return Result.fail("该员工不存在");
        }
        EmAttachment attachment;
        try {
            attachment = attachmentService.uploadAvatar(employee.getId(), file);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        return Result.success(attachment);
    }



}
