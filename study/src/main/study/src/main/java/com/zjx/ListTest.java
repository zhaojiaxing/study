package com.zjx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2020/08/04 17:24
 */
public class ListTest {
    public static void main(String[] args) {
//        List list = new ArrayList<>();
//        list.add(12);
//        list.add(3,12);
//        System.out.println(4>>1);
//        int[] array = new int[5];
//        int[] copyArray = new int[5];
//        array[0]=1;
//        array[1]=3;
//        array[2]=8;
//        System.arraycopy(array,1,array,1+1,2);
//        array[1] = 23;
//        System.out.println(Arrays.toString(array));
//        AtomicInteger a = new AtomicInteger();
//        a.getAndIncrement();
        String[] words = new String[]{"Hello","World"};
        List<String> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        a.forEach(System.out::println);
    }
}
