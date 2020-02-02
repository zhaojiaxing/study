package com.zjx.file;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        //设置文件路径
        File file = new File("E:"+File.separator+"demo"+File.separator+"demo2"+File.separator+"test.txt");
        try {
            //寻找父路径并判断是否存在
            System.out.println(file.getParentFile().exists());
            //如果父路径不存在则创建父路径
            if(!file.getParentFile().exists()){
//                file.getParentFile().mkdir();
                //创建多级目录
                file.getParentFile().mkdirs();
            }
            //如果文件存在则删除
            if(file.exists()){
                file.delete();
            }else {
                //如果文件不存在则创建
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
