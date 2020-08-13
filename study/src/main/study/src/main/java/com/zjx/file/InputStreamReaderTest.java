package com.zjx.file;

import java.io.*;

public class InputStreamReaderTest {
    public static void main(String[] args) throws Exception{
        File file = new File("E:"+ File.separator+"demo"+File.separator+"study.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        //字节输入流
        InputStream in = new FileInputStream(file);

        //将字节输入流转为字符输入流
        Reader input = new InputStreamReader(in);
        char[] c = new char[1024];
        //读数据
        input.read(c);

        //关闭流
        input.close();

        System.out.println(new String(c));
    }
}
