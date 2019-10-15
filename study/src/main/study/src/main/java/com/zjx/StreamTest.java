package com.zjx;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/08 9:18
 */
public class StreamTest {
    public static void main(String[] args) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get("F:\\123.txt")), StandardCharsets.UTF_8);
            List<String> list = Arrays.asList(contents.split("\\PL+"));

//            long count = 0;
//            for(String w : list){
//                if(w.length() > 12){
//                    count++;
//                }
//                System.out.println(w);
//            }

//            long count = list.stream().filter(w -> w.length() > 12).count();
            long count = list.parallelStream().filter(w -> w.length() > 12).count();
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
