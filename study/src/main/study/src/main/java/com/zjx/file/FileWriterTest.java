package com.zjx.file;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class FileWriterTest {
    public static void main(String[] args) throws Exception{
        //1. 定义要输出的文件路径
        File file = new File("E:"+File.separator+"demo"+File.separator+"writer.txt");
        //如果目录不存在则创建
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        //2. 实例化Writer类对象
        Writer out = new FileWriter(file);
        //3. 进行内容输出
        String str = "好好学习，天天向上！！！";
        //输出字符串数据
        out.write(str);
        //4. 关闭流
        out.close();
    }
}
