package com.dangdang.common.utils.easyui.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件上传工具类
 */
public class FileUploadUtil {

    public static File path = null;
    public static String format = null;
    public static SimpleDateFormat simpleDateFormat = null ;
    static {
        //获取跟目录
        try {
            path = new File(ResourceUtils.getURL("classpath:static/upload/").getPath());
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 文件保存的路径
     * @return
     */
    public static String getPath(){
        format = simpleDateFormat.format(new Date());
       return "static/upload/"+format+"/";
    }

    /**
     * 获取绝对路径
     * @return
     */
    public static String getAbsolutePath(){
        format = simpleDateFormat.format(new Date());
        File upload = new File(path.getAbsolutePath()+"/"+format);
        if(!upload.exists()) {
            upload.mkdirs();
        }
        return upload.getAbsolutePath();

    }

    /**
     * 获取项目根路径
     * @return
     */
    public static String getResource(){
        try {
            return ResourceUtils.getURL("classpath:").getPath().substring(1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
