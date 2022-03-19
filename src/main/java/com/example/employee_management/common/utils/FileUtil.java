package com.example.employee_management.common.utils;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * 文件处理
 */
public class FileUtil {
    //默认存放路径
    private static String storePath = "img";

    private static String catalogue = "src/main/resources/static/";

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
        String outFileName = catalogue+route+"/"+uuid+"."+suffix;

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
        String[] strings = new String[5];


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

    /**
     * 根据路径删除文件
     * @param url
     * @return
     */
    public static boolean deleteFile(String url){
        File file = new File(catalogue+url);
        if (file.exists()){
            file.delete();
            return true;
        }else {
            return false;
        }
    }

    public static void deleteFile(String[] urls){
        for (String url:urls){
            deleteFile(url);
        }
    }

}
