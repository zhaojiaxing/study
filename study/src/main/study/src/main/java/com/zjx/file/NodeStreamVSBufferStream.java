package com.zjx.file;

import java.io.*;

public class NodeStreamVSBufferStream {
    public static void main(String[] args) throws Exception {
        File file = new File("E:\\demo\\test.doc");
        File copyFile = new File("E:\\demo\\test(copy).doc");
        testBufferedInputStream(file,copyFile);
        testFileInputStream(file,copyFile);
        testFileWriter(file,copyFile);
    }


    private static void testBufferedInputStream(File file, File copyFile) throws Exception {
        //测试包装流 ，1024个字节拷贝
        System.out.println("------------测试包装流 ，1024个字节拷贝---------------");
        long start = System.currentTimeMillis();

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(copyFile));
        int len = 0;
        byte[] b = new byte[1024];
        while((len = in.read(b))!= -1){
            out.write(b);
        }
        in.close();
        out.close();
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void testFileInputStream(File file, File copyFile) throws Exception {
        //测试字节流 ，存1024个字节拷贝
        System.out.println("------------测试字节流 ，存1024个字节拷贝---------------");
        long start = System.currentTimeMillis();
        InputStream in = new FileInputStream(file);
        OutputStream out = new FileOutputStream(copyFile);
        int len = 0;
        byte[] b = new byte[1024];
        while((len = in.read(b))!= -1){
            out.write(b);
        }
        in.close();
        out.close();
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void testFileWriter(File file, File copyFile) throws Exception {
        //测试缓冲字符流
        System.out.println("------------测试缓冲字符流---------------");
        long start = System.currentTimeMillis();
        BufferedReader in = new BufferedReader(new FileReader(file));
        BufferedWriter out = new BufferedWriter(new FileWriter(copyFile));
        String str = null;
        while((str = in.readLine())!= null){
            out.write(str);
        }
        in.close();
        out.close();
        System.out.println(System.currentTimeMillis() - start);
    }
}
