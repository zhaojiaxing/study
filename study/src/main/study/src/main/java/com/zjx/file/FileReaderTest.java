package com.zjx.file;

import java.io.*;

public class FileReaderTest {
    public static void main(String[] args) throws Exception{
        //1. 定义要输入的文件路径
        File file = new File("E:"+File.separator+"demo"+File.separator+"writer.txt");
        //判断文件是否存在后才可以进行读取
        if(file.exists()){

            // 2. 为Reader类对象实例化
            Reader input = new FileReader(file);

            // 3. 进行数据读取
            char[] c = new char[1024];
            int len = input.read(c);

            //4. 关闭流
            input.close();
            System.out.println(new String(c,0,len));
        }
    }
}
