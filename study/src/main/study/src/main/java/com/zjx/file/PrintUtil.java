package com.zjx.file;

import java.io.*;

/**
 * 打印流
 *
 * @author zhaojiaxing
 * @date 2020-02-01 17:07
 */
public class PrintUtil {

    private OutputStream output;

    public PrintUtil(OutputStream output) {
        this.output = output;
    }

    public void print(String s) {
        try {
            output.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(int s) {
        this.print(String.valueOf(s));
    }

    public void print(double s) {
        this.print(String.valueOf(s));
    }

    public void println(String s) {
        this.print(s.concat("\n"));
    }

    public void println(int s) {
        this.print(String.valueOf(s).concat("\n"));
    }

    public void println(double s) {
        this.print(String.valueOf(s).concat("\n"));
    }

    public void close(){
        try {
            this.output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class TestDemo{
    public static void main(String[] args) throws Exception{
//        PrintUtil printUtil = new PrintUtil(new FileOutputStream(new File("E:\\demo\\test.txt")));
        PrintStream printUtil = new PrintStream(new FileOutputStream(new File("E:\\demo\\test.txt")));
//        printUtil.print("hello ");
//        printUtil.println("world ");
//        printUtil.print(1+1);
//        printUtil.println(1.1+1.1);

        String name = "张三";
        int age = 19;
        double score = 780000.3567;
        //整数(%d)、字符串(%s)、小数(%m.nf)、字符(%c)
        printUtil.printf("姓名:%s,年龄:%d,分数:%2.2f",name,age,score);
        printUtil.close();
    }
}
