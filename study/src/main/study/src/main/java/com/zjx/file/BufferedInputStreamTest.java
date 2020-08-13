package com.zjx.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author zhaojiaxing
 * @date 2020-02-02 20:18
 */
public class BufferedInputStreamTest {
    public static void main(String[] args) {
        //输入文件路径
        File file = new File("E:\\demo\\study.txt");
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            int temp = 0;
            byte[] data = new byte[1024];
            while((temp = buf.read(data)) != -1){
                System.out.println(new String(data));
            }
            buf.close();
        } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
