package com.example.employee_management.controller;


import com.example.employee_management.common.utils.FileUtil;
import com.example.employee_management.common.utils.Result;
import com.example.employee_management.service.impl.EmAttachmentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    EmAttachmentServiceImpl emAttachmentService;


    /**
     *  xiaohenhyv  文件处理接口
     *  @param file 传输的文件
     */

      @PostMapping("/fileReserve")
      @ApiOperation("接受发送的文件存储到数据库")
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

}
