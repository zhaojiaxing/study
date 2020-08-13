package com.zjx;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2020/05/18 18:34
 */
public class TestFile {
    public static void main(String[] args) {
        String name = "tp_qwww_trades.txt";
        System.out.println(name.split("tp_")[1].split("_trades")[0]);
    }
}
