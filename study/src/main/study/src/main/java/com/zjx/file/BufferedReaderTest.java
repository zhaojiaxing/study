package com.zjx.file;

import java.io.*;

/**
 * @author zhaojiaxing
 * @date 2020-02-02 12:04
 */
public class BufferedReaderTest {
    public static void main(String[] args) {
//        readIn();
        readFile();

    }

    /**
     * 使用BufferedReader处理键盘输入
     */
    public static void readIn(){
        //System.in是InputStream类对象，因此需要将其转换为Reader类，这里使用InputStreamReader转换
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入数据：");
        String str = null;
        try {
            str = buf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("输入的内容："+str);
    }

    /**
     * 使用BufferedReader读取文件
     */
    public static void readFile(){
        File file = new File("E:\\demo\\study.txt");
        try {
            //使用字符缓冲输入流读取文件
            BufferedReader buf = new BufferedReader(new FileReader(file));
            String str = null;
            //每次读取一行
            while((str = buf.readLine()) != null){
                System.out.println(str);
            }
            //关闭流
            buf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
