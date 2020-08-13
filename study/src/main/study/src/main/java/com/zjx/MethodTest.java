package com.zjx;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2020/08/04 17:07
 */
public class MethodTest {
    public static void main(String[] args) {
        try {
            Method method = Student.class.getMethod("getUsername");
            Student student = new Student("123",12);
            Student student2 = new Student("234",17);
            Integer o1Result = (Integer) method.invoke(student);
            Integer o2Result = (Integer) method.invoke(student2);
            System.out.println(o1Result+"   "+o2Result);
            List list = new ArrayList<>();
            list.add(12);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
