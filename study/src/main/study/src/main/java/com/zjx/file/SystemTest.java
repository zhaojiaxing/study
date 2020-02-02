package com.zjx.file;

import java.io.InputStream;

/**
 * @author zhaojiaxing
 * @date 2020-02-01 22:31
 */
public class SystemTest {
    public static void main(String[] args) throws Exception{
        InputStream input = System.in;
        byte[] data = new byte[1024];
        System.out.println("请输入数据：");
        int len = input.read(data);
        System.out.println("输入数据为："+new String(data,0,len));
    }
}
