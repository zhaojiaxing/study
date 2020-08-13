package com.zjx.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author zhaojiaxing
 * @date 2020-02-02 20:28
 */
public class BufferedOutputStreamTest {
    public static void main(String[] args) {
        //输出文件路径
        File file = new File("E:\\demo\\test.txt");
        try {
            //使用字节缓冲输出流
            BufferedOutputStream buf = new BufferedOutputStream(new FileOutputStream(file));
            String str = "好好学习，天天向上";
            buf.write(str.getBytes());

            //关闭流
            buf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
