package com.zjx.file;

import java.io.*;

/**
 * @author zhaojiaxing
 * @date 2020-02-01 16:33
 */
public class ByteArrayTest {
    public static void main(String[] args) throws Exception {
//        test();
        mergerFiles();
    }

    /**
     * 利用内存流合并；两个文件
     * @throws Exception
     */
    public static void mergerFiles() throws Exception {
        File fileA = new File("E:\\demo\\study.txt");
        File fileB = new File("E:\\demo\\writer.txt");
        InputStream inputStreamA = new FileInputStream(fileA);
        InputStream inputStreamB = new FileInputStream(fileB);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int temp = 0;
        //每次读取一个字节
        while((temp = inputStreamA.read()) != -1){
            out.write(temp);
        }
        //每次读取一个字节
        while((temp = inputStreamB.read()) != -1){
            out.write(temp);
        }

        //将所有的内容变为字节数组
        byte[] data = out.toByteArray();

        out.close();
        inputStreamA.close();
        inputStreamB.close();

        System.out.println(new String(data));
    }

    /**
     * 利用内存流将字符串转为大写
     * @throws Exception
     */
    public static void test() throws Exception {
        //要求被转换的字符串
        String str = "Hello*World";
        //将要读取的数据设置到内存输入流中
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        //从内存输出流中取出数据进行操作
        OutputStream outputStream = new ByteArrayOutputStream();
        int temp = 0;
        //每次读取一个数据
        while ((temp = inputStream.read()) != -1) {
            //将字母转为大写并输出
            outputStream.write(Character.toUpperCase(temp));
        }

        //调用toString方法
        System.out.println(outputStream);

        inputStream.close();
        outputStream.close();

    }
}
