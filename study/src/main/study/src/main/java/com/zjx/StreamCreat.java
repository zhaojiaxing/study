package com.zjx;

import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
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

//        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO,n -> n.add(BigInteger.ONE));
//        integers.forEach(e -> System.out.println(e));

        List<String> a = new ArrayList<String>() {{
            add("123");
            add("234");
            add("123");
            add("345");
            add("678");
        }};
        List<String> b = new ArrayList<String>() {{
            add("123");
            add("234");
            add("3677");
            add("8888");
        }};
//        a.retainAll(b);
//        System.out.println(a.size());
        List<String> s = a.stream().filter(t->!b.contains(t)).collect(Collectors.toList());
        System.out.println(s);

//        System.out.println("zz".equals(null));
        Map<String, Student> amap = new HashMap<>();
        amap.put("a", new Student("张三", 18));
        amap.put("b", new Student("李四", 19));
        amap.put("c", new Student("王五", 12));
        amap.put("d", new Student("赵楼", 12));
        amap.put("e", new Student("陈强", 18));

//        List<Student> students = amap.values().stream().collect(Collectors.toList());
//        students.stream().forEach(student -> {
//            student.setAge(34);
//        });
//        amap.forEach((k,v)->{
//            System.out.println(k+ "   " +v);
//        });

//        String str = "2018-07-03";
//        Date date = strParseDate(str, "yyyy/MM/dd");
//        System.out.println(date.getYear() + "  " + date.getMonth() + " " + date.getDay());
    }

    public static Date strParseDate(final String str, String dateFormat) {
        try {
            if (StringUtils.isEmpty(str)) {
                return null;
            }
            if (StringUtils.isEmpty(dateFormat)) {
                dateFormat = "yyyy-MM-dd HH:mm:ss";
            }
            if (str.contains("-")) {
                if (str.contains(":")) {
                    dateFormat = "yyyy-MM-dd HH:mm:ss";
                } else {
                    dateFormat = "yyyy-MM-dd";
                }

            }
            DateFormat fmt = new SimpleDateFormat(dateFormat);
            return fmt.parse(str.trim());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
