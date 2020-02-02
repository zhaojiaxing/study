package com.zjx.file;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest2 {
    public static void main(String[] args) {
        File file = new File("E:"+File.separator+"demo"+File.separator+"1.txt");
        //判断是否是文件
        if(file.isFile()){
            System.out.println("是文件");
        }
        //判断是否是目录
        if(file.getParentFile().isDirectory()){
            System.out.println("父目录是文件夹");
        }
        System.out.println("文件名是："+file.getName());
        System.out.println("文件路径："+file.getPath());
        //获取文件大小
        long length = file.length();
        System.out.println("文件大小："+(new BigDecimal(length).
                divide(new BigDecimal(1024*1024),2,BigDecimal.ROUND_HALF_UP))+"M");
        //获取文件上次修改日期
        Date modifyTime = new Date(file.lastModified());
        System.out.println("文件的最近修改日期是："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(modifyTime));
        System.out.println(file.isAbsolute());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());


    }
}
