package com.zjx.file;

import java.io.*;

/**
 * @author Administrator
 * @date 2020-02-01 11:49
 */
public class CopyFile {
    public static void main(String[] args) throws Exception{
        //源文件路径（源文件必须存在）,File.separator为文件分隔符，也可以直接写入路径，不用此分隔符
        File source = new File("E:"+File.separator+"demo"+File.separator+"study.txt");
        //目标文件路径（此时文件不存在，需要由源文件拷贝）
        File target = new File("E:"+File.separator+"demo"+File.separator+"copy"+File.separator+"study.txt");

        //如果源文件不存在则不能拷贝
        if(!source.exists()){
            return;
        }

        //如果目标文件目录不存在则创建
        if(!target.getParentFile().exists()){
            target.getParentFile().mkdirs();
        }

        //实现文件的拷贝
        InputStream inputStream = new FileInputStream(source);
        OutputStream outputStream = new FileOutputStream(target);
        int temp = 0;
        //每次读取1024个字节
        byte[] data = new byte[1024];
        //将每次读取的数据保存到字节数组里面，并且返回读取的个数
        while ((temp = inputStream.read(data)) != -1){
            //输出数组
            outputStream.write(data,0,temp);
        }

        inputStream.close();
        outputStream.close();

    }
}
