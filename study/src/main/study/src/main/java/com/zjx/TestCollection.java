package com.zjx;

import javax.swing.plaf.ListUI;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by zjx on 2019/3/2.
 */
public class TestCollection {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<Integer>(){{add(123);add(1232);add(12322);add(123222);add(1232222);add(12322222);add(123222221);add(12344444);}};
//        Iterator it = list.iterator();
////
////        while (it.hasNext()){
////            System.out.println(it.next());
////        }
////
////
////        ExecutorService es = Executors.newFixedThreadPool(10);
////        es.execute(new Runnable() {
////            public void run() {
////                System.out.println("打印："+Thread.currentThread().getName());
////            }
////        });
//
//        List<User> users = new ArrayList<User>(){{add(new User("张三"));
//            add(new User("张三"));
//            add(new User("张三"));
//            add(new User("李四"));
//            add(new User("李四"));
//            add(new User("王五"));
//            add(new User("王五"));
//        }};

//        Map<String,List<User>> map = users.stream().collect(Collectors.groupingBy(User::getUserName));
//        for(Map.Entry<String, List<User>> entry : map.entrySet()){
//            System.out.println("key=="+entry.getKey()+"    value=="+entry.getValue());
//        }


//        List<Student> students = new ArrayList<Student>() {{
//            add(new Student("张三", 12));
//            add(new Student("张三", 13));
//            add(new Student("张三", 34));
//            add(new Student("李四", 54));
//            add(new Student("李四", 12));
//            add(new Student("王五", 23));
//            add(new Student("王五", 21));
//        }};

        //排序
//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                //升序
//                return o1.getAge() - o2.getAge();
//            }
//        });

//       Collections.sort(students,(o1,o2) ->(o1.getAge()-o2.getAge()));
//
//
//        students.stream().forEach(student -> {
//            System.out.println(student.getAge());
//        });

        //排序
//        Comparator<Student> comparator = Comparator.comparing(Student::getAge);
//        List<Student> list = students.stream().sorted(comparator.reversed()).collect(Collectors.toList());
//        list.stream().forEach(user -> {
//            System.out.println(user.getAge());
//        });
//
//        BigDecimal bigDecimal = new BigDecimal(5).multiply(new BigDecimal(4));
//        System.out.println(bigDecimal);

//        String s = "中国工商银行成都分行";
////        System.out.println(s.matches("(.*)132(.*)"));
//        System.out.println(s.contains("工商银行"));
//        String str = "123.234344";
//        System.out.println(new BigDecimal("0"));
//        Date dd = new Date();
//        Map<String,Object> map = new HashMap<>();
//        map.put("test",dd);
//        Date da = (Date) map.get("test");
//        System.out.println(dd);

//        System.out.println(students.stream().map(Student::getUsername).collect(Collectors.toList()).contains("张三"));

//        List<String> list = new ArrayList<>();
//        list.stream().filter(Objects::nonNull).forEach(e ->{
//            System.out.println("sdsdsdsds"+e.toLowerCase());
//        });


//        String str = "{\"code\":505,\"msg\":\"数组越界异常\",\"data\":null}";
//        Pattern pattern = Pattern.compile(".*code.*");
//        Matcher matcher = pattern.matcher(str);
//        System.out.println(matcher.matches());
//        System.out.println(str.indexOf("\"code\":"));
//        System.out.println("code="+str.substring(str.indexOf("\"code\":")+7,str.indexOf(",\"msg")));
//            System.out.println("msg="+str.substring(str.indexOf("msg")+5,str.indexOf(",\"data")));
////        System.out.println(new Date(new java.util.Date().getTime()));
//        DateFormat df2 = DateFormat.getDateTimeInstance();
//        Timestamp ctime = new java.sql.Timestamp(new java.util.Date().getTime());
//        System.out.println( df2.format(new Date()));


        List<Student> students = new ArrayList<Student>() {{
            add(new Student("张三", 12));
            add(new Student("李四", 54));
            add(new Student("王五", 23));
            add(new Student("李留", 21));
        }};

        List<Student> students2 = new ArrayList<Student>() {{
            add(new Student("张三", 12));
            add(new Student("李四", 54));
            add(new Student("王五", 23));
        }};

        List<String> s = new ArrayList<String>() {{
            add("张三");
            add("李四");
            add("王五");
            add("陈留");
            add("王五");
        }};
        List<String> s2 = new ArrayList<String>() {{
            add("张三");
            add("李四");
            add("王五");
        }};
        System.out.println(s.containsAll(s2));
    }
}
