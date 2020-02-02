package com.zjx.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamTest {

    public static void main(String[] args) throws Exception{
        //1. 定义要输入的文件路径
        File file = new File("E:"+File.separator+"demo"+File.separator+"study.txt");
        //判断文件是否存在后才可以进行读取
        if(file.exists()){
            // 2. 使用FileInputStream进行读取
            InputStream inputStream = new FileInputStream(file);
            //准备处理一个1024的数组
            byte[] data = new byte[1024];
            //字节数组的操作脚标
            int foot = 0;
            //表示每次读取的字节数据
            int temp = 0;
            //读取一个字节
            while((temp = inputStream.read()) != -1){
                if(temp != -1){
                    data[foot++] = (byte)temp;
                }
            }
            //4. 关闭流
            inputStream.close();
            System.out.println("["+new String(data,0,foot)+"]");
        }
    }
}
