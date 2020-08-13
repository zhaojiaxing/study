package com.zjx.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author Administrator
 * @date 2020-02-01 15:53
 */
public class EncodingTest {
    public static void main(String[] args) throws Exception{
        File file = new File("E:"+File.separator+"my.txt");
        OutputStream output = new FileOutputStream(file);
        output.write("好好学习，天天向上".getBytes("ISO8859-1"));
        output.close();
    }
}
