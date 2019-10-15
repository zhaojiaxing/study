package com.zjx.algorithm;

import java.util.*;

/**
 * 冒泡排序法
 *
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/10/08 17:29
 */
public class BubbleSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            //获取0到100的随机整数
            list.add((int) (Math.random() * 100000));
        }
        long system = System.currentTimeMillis();
        bubbllSort(list);
        System.out.println("总共耗时：" + (System.currentTimeMillis() - system));
        System.out.println(list);
    }

    /**
     * 冒泡排序
     * @param list
     * @return: void
     * @author: zhaojiaxing
     * @createTime: 2019/10/10 0010 11:58
     */
    public static void bubbllSort(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).intValue() > list.get(j + 1).intValue()) {
                    Integer temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
