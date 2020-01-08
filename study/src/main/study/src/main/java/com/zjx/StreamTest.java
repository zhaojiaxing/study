package com.zjx;
import static java.lang.System.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/08 9:18
 */
public class StreamTest {
    public static void main(String[] args) {
//        try {
////            String contents = new String(Files.readAllBytes(Paths.get("F:\\123.txt")), StandardCharsets.UTF_8);
////            List<String> list = Arrays.asList(contents.split("\\PL+"));
////
//////            long count = 0;
//////            for(String w : list){
//////                if(w.length() > 12){
//////                    count++;
//////                }
//////                System.out.println(w);
//////            }
////
//////            long count = list.stream().filter(w -> w.length() > 12).count();
////            long count = list.parallelStream().filter(w -> w.length() > 12).count();
////            System.out.println(count);
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        }

//        List<String[]> list = new ArrayList<>();
//        list.add(new String[]{"12","23","345"});
//        list.add(new String[]{"45","54","78"});
//        list.add(new String[]{"21","45","43"});
//
//        List<String[]> s = list.stream().peek(l->l[0] = "ddd").collect(Collectors.toList());
//        s.stream().forEach(f-> System.out.println(f[0]+" "+f[1]+" "+f[2]));

//        String str = "旅游#跑步#游泳#打乒乓#";
//        List list = new ArrayList();
//        Stream.of(str.split("#")).forEach(
//                        e ->list.add(e)
//                );
//        System.out.println(list);
        List<String> list1 = new ArrayList<>();
//        List<String> list2 = new ArrayList<>();
//        for(int i = 0;i< 10000;i++){
//            list1.add("元素"+i);
//        }
//        for(int i = 100;i> 0;i--){
//            list2.add("元素"+i);
//        }
//        long time1 = System.currentTimeMillis();
////        list1.removeAll(list2);
//        list2.removeAll(list1);
//        System.out.println("总共耗时："+(System.currentTimeMillis() - time1));

//        CompletableFuture.runAsync(() -> {
//            for (int i = 0; i < 1000; i++) {
//                list1.add("元素" + i);
//            }
//
//        });
//
//        CompletableFuture.runAsync(() -> {
//            int count = 0;
//            System.out.println("线程开始："+list1.size());
//            while(count < 1000){
//                if(list1.size() > 400){
//                    List<String> list2 = list1.subList(0,400);
//                    list1.removeAll(list1.subList(0,400));
//                    System.out.println("list1的size为："+list1.size());
//                    System.out.println("list2的size为："+list2.size());
//                    count++;
//                }
//            }
//
//        });

        out.println("测试静态导入");

    }
}
