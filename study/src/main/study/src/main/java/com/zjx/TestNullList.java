package com.zjx;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/27 17:40
 */
public class TestNullList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("sss,s");
        list.stream().filter(Objects::nonNull).forEach(s -> {
            System.out.println(s.split(",")[0]);
        });
    }
}
