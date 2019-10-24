package com.zjx;

import java.math.BigDecimal;

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

        money = new BigDecimal(5020.0000);
        BigDecimal bigDecimal = money.divideAndRemainder(new BigDecimal(100))[1];
        System.out.println(money.divideAndRemainder(new BigDecimal(100))[1].compareTo(new BigDecimal(0)) == 0);

    }

    private static void getStr(String str){
        str = "zxcvdddd";
    }

    private static void getStudent(Student student){
        student.setAge(12);
        student.setUsername("zzz");
    }
}
