package com.zjx;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;
import java.lang.String;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/08 10:52
 */
public class StreamCreat {
    public static void main(String[] args) {
//        Stream<String> song = Stream.of("gently","down","the","stream");
//        Stream<String> test =  Arrays.stream(new String[]{"1","2"},0,2);
//        test.forEach(e -> System.out.println(e));
//
//        Stream<String> a = Stream.generate(()->"Test");
//        System.out.println(a.findAny().get());

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO,n -> n.add(BigInteger.ONE));
        integers.forEach(e -> System.out.println(e));
    }
}
