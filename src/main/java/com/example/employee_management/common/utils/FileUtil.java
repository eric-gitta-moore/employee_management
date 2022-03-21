package com.example.employee_management.common.utils;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * 文件处理
 */
public class FileUtil {
    //默认存放路径
    private static String storePath = "img";

    /**
     * 存放在static下的自定义的文件夹中
     * @param route
     * @param file
     * @return 文件路径
     * @throws IOException
     */
    public static String pictureStorage(String route,MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        String filename = file.getOriginalFilename();
        String suffix = filename.split("\\.")[1];
        String uuid = UUID.randomUUID().toString();
        String outFileName = "src/main/resources/static/"+route+"/"+uuid+"."+suffix;

        try(OutputStream outputStream = new FileOutputStream(outFileName)){
            IOUtils.copy(inputStream,outputStream);
            return route+"/"+uuid+"."+suffix;
        }catch (IOException e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 存放在static下的自定义的文件夹中
     * @param file
     * @return 文件路径
     * @throws IOException
     */
    public static String pictureStorage(MultipartFile file) throws IOException {
        return pictureStorage(storePath, file);
    }



/**
 *   处理多文件
 *   @param route
 *   @param file
 *   @return 文件路径数组
 */
    public static String[] pictureStorage(String route,MultipartFile[] file) throws IOException {
        String[] strings=new String[10];


        for (int i = 0; i < file.length; i++) {
            strings[i]=pictureStorage(file[i]);
        }
        return strings;
    }

    /**
     * 存放在static下的自定义的文件夹中
     * @param file
     * @return 文件路径数组
     * @throws IOException
     */
    public static String[] pictureStorage(MultipartFile[] file) throws IOException {
        return pictureStorage(storePath,file);
    }


}
