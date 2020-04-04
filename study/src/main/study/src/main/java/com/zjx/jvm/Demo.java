package com.zjx.jvm;

/**
 * @author zhaojiaxing
 * @date 2020-03-22 20:45
 */
public class Demo {

    public int math(){
        int a = 1;
        int b = 2;
        int c = (a+b)*10;
        return c;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.math();
        System.out.println(System.getProperties());
    }
}
