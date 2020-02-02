package com.zjx.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author zhaojiaxing
 * @date 2020-02-02 20:13
 */
public class BufferedWriterTest {
    public static void main(String[] args) {
        File file = new File("E:\\demo\\buffer.txt");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            String str = "好好学习，天天向上！！！";
            out.write(str);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
