package com.zjx;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/13 17:15
 */
public class TestRecurion {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        get(list,0);
        for(String s: list){
            System.out.println(s);
        }
    }

    public static void get(List<String> list,int count){
        list.add("ass:"+count);
        if(count == 5){
            return;
        }
         get(list,++count);

    }
}
