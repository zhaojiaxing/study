package com.zjx.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOutputStreamTest {
    public static void main(String[] args) throws Exception{
       single();
       arrayOutput();
    }

    /**
     * 单个字节输出文件
     * @throws Exception
     */
    public static void single() throws Exception{
        //1. 定义要输出的文件路径
        File file = new File("E:"+File.separator+"demo"+File.separator+"test.txt");
        //如果目录不存在则先创建目录
        if(file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        //2. 应该使用OutputStream和其子类进行对象的实例化，此时目录存在，文件还不存在
        OutputStream outputStream = new FileOutputStream(file);

        //3. 进行文件内容的输出
        String str = "好好学习，天天向上";
        //将字符串转为byte数组
        byte[] data = str.getBytes();

        outputStream.write(data);

        //4. 关闭资源
        outputStream.close();
    }

    /**
     * 部分字节数组输出
     */
    public static void arrayOutput()throws Exception{
        //1. 定义要输出的文件路径
        File file = new File("E:"+File.separator+"demo"+File.separator+"study.txt");
        //如果目录不存在则先创建目录
        if(file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        //2. 应该使用OutputStream和其子类进行对象的实例化，此时目录存在，文件还不存在
        OutputStream outputStream = new FileOutputStream(file);

        //3. 进行文件内容的输出
        String str = "我们要好好学习技术，然后找个好工作，多赚点钱，补贴家用，实现自我价值，成为一个对社会有用的人";
        //将字符串转为byte数组
        byte[] data = str.getBytes();

        outputStream.write(data,0,6);

        //4. 关闭资源
        outputStream.close();
    }
}
