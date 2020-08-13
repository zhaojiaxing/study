package com.zjx.file;

import java.io.*;

public class OutputStreamWriterTest {
    public static void main(String[] args) throws Exception{
        File file = new File("E:"+ File.separator+"demo"+File.separator+"study.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        //字节流
        OutputStream output = new FileOutputStream(file);

        //将字节流转换为字符流
        Writer out = new OutputStreamWriter(output);
        String c = "Hello World!";
        //进行输出
        out.write(c);

        out.flush();
        out.close();
    }
}
