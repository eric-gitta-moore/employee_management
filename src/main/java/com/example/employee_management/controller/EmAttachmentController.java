package com.example.employee_management.controller;


import com.example.employee_management.common.utils.FileUtil;
import com.example.employee_management.common.utils.Result;
import com.example.employee_management.entity.EmAttachment;
import com.example.employee_management.entity.EmEmployee;
import com.example.employee_management.service.EmAttachmentService;
import com.example.employee_management.service.EmEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 附件表 前端控制器
 * </p>
 */
@RestController
@Api(value = "EmAttachmentController", tags = {"文件上传api  _xhy"})
@RequestMapping("/em-attachment")
public class EmAttachmentController {
    @Autowired
    EmAttachmentService attachmentService;



    @Autowired
    private EmAttachmentService emAttachmentService;

    /**
     * 文件保存接口
     * @param files
     * @return
     */
    @PostMapping("/save")
    @ApiOperation("李超===>接受发送的文件存储到数据库，注意，发送文件的对象名必须为files,图片属性名一并上传，并且属性名对象名必须为pictureNames")
    public Result saveFile(MultipartFile [] files,String [] pictureNames)
    {
        List<Integer> list = new ArrayList<Integer>();
        LocalDateTime localDateTime = LocalDateTime.now();
        int i = 0;
        for (i = 0; i < files.length; i++)
        {
            try
            {
                String path = FileUtil.pictureStorage(files[i]);
                if(!path.isEmpty())
                {
                    EmAttachment emAttachment = new EmAttachment(path, pictureNames[i],null, localDateTime, localDateTime, "admin", "admin");
                    Integer id = emAttachmentService.savePicturePath(emAttachment);
                    list.add(id);
                }

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        if (!list.isEmpty())
        {
            return Result.success(200,"图片存放成功",list);
        }
        else
        {
            return Result.fail(400,"图片保存失败",null);
        }
    }

    /**
     *  xiaohenhyv  文件处理接口
     *  @param file 传输的文件
     */

      @PostMapping("/fileReserve")
      @ApiOperation("肖恒宇===>接受发送的文件存储到数据库")
      public Result fileReserve(MultipartFile[] file)   {
               Integer[] integers=new Integer[4];
          try{

              String[] strings = FileUtil.pictureStorage(file);

              for(int i=0;i<strings.length;i++){
                  if(strings[i]!=null){
                      Integer integer = emAttachmentService.saveFile(strings[i]);
                      integers[i]=integer;
                  }

              }
              return Result.success("操作成功^_^ data默认是四个为null的不用处理，",integers);
          }catch (Exception o){
              o.printStackTrace();
              return Result.fail("操作失败>_<  data值会为null");
          }



      }

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
