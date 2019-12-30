package com.zjx;

import com.zjx.util.CardUtil;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by zjx on 2019/2/16.
 */
public class Test {
    private static BigDecimal money;
    public static void main(String[] args){
//        int x = 5;
//        boolean b1 = true;
//        boolean b2 = false;
//        if((x==4) && !b2)
//            System.out.println("1 ");
//        System.out.println("2 ");
//        if((b2 = true) && b1)
//            System.out.println("3 ");
//
//        Integer i = new Integer(1) + new Integer(2);
//        switch(i){
//            case 1:
//                System.out.println("one");
//            case 2:
//                System.out.println("two");
//            case 3:
//                System.out.println("three");
//            case 4:
//                System.out.println("four");
////                break;
//            default:
//                System.out.println("other");
//                break;
//        }

//
//        int sum = 0;
//        int b[][] = {{13,14,15},{23,24,25},{33,34,35}};
//        for(int i=0;i<b.length;i++){
//            System.out.print("b["+i+"]:");
//            for(int j=0;j<b[i].length;j++){
//                System.out.print(b[i][j] + " ");
//                sum += b[i][j];
//            }
//            System.out.println();
//        }
//        System.out.println("sum="+sum);

//        int i=0,j=9;
//        do{
////            if(i++ >= j)
////                break;
//            i++;
//            System.out.println("zxcv");
//        }while(i<1);
//        System.out.println("i="+i+" and j="+j);
//
//        Student student = new Student();
////
////        System.out.println(student.getClass().getName());
//
//        StringBuilder sql = new StringBuilder("sssssszzzzz");
//        StringBuilder total = new StringBuilder(sql);
//
//        sql.append("axcffff");
//
////        System.out.println(total.toString());
//
//
//        String str = "";
//        getStr(str);
//        System.out.println(str);
//        getStudent(student);
//        System.out.println(student.getAge());

//        System.out.println(TypeEnum.getFieldByType(4));

//        money = new BigDecimal(5020.0000);
////        BigDecimal bigDecimal = money.divideAndRemainder(new BigDecimal(100))[1];
////        System.out.println(money.divideAndRemainder(new BigDecimal(100))[1].compareTo(new BigDecimal(0)) == 0);

//        LinkedList<String> list = new LinkedList();
//        list.addFirst("ss");
//        list.addFirst("dd");
//        list.addFirst("ff");
//        list.addFirst("gg");
//        List<String> strings = new ArrayList<>(list);
//        list.stream().forEach(l -> System.out.println(l));
//        Student student = new Student();
////        getStudent(student);
////        System.out.println(student.getAge());

//        String idcard = "110101199011124497";
////        System.out.println(CardUtil.getAge(idcard));
//        test();
//        System.out.println(CardUtil.delEndZero("345101"));
//        getPercent();
//
        int[] a = {1,7,4,5,6,3};
////        int[] b = a;
////        b[4] = 56;
////        System.out.println(Arrays.toString(a));
////        int[] c = Arrays.copyOf(a,a.length+5);
////        c[1] = 1234;
//        Arrays.sort(a,Collections.reverseOrder());
//        System.out.println(Arrays.toString(a));

//        int[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
//        Arrays.sort(a);
//        for(int arr:a) {
//            System.out.print(arr + " ");
//        }

//        for(int i = 0; i < 10;i++){
//            System.out.println(Arrays.toString(lottery(new int[49],10)));
//        }
//        int[] z = Arrays.copyOfRange(a,2,5);
        int[] d = new int[100000000];
        for(int i = 0;i < d.length;i++){
            d[i] = i+1;
        }
        //二分搜索
        int boo = Arrays.binarySearch(d,400001);
        System.out.println(boo);
    }

    private static void getStr(String str){
        str = "zxcvdddd";
    }

    private static void getStudent(Student student){
        student.setAge(12);
        student.setUsername("zzz");
    }

    /**
     * 获取百分比
     */
    private static void getPercent(){
        int diliverNum=3;
        int queryMailNum=9;
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float)diliverNum/(float)queryMailNum);
        System.out.println("百分比为:" + result);
    }

    private static int[] lottery(int[] numbers,int k){
        int[] result = new int[k];
        int n = numbers.length;
        for(int i = 0; i< n;i++){
            numbers[i] = i+1;
        }
        for(int i = 0;i < k;i++){
            int r = (int)(Math.random()*n);
            result[i] = numbers[r];
            numbers[r] = numbers[n - 1];
            n--;
        }
        Arrays.sort(result);
        return result;
    }

}
