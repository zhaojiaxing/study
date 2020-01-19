package com.zjx;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/14 15:33
 */
public class ListToString {
    public static void main(String[] args) {
        List<String> students = new ArrayList<String>() ;
        for(int i = 0;i < 313;i++){
            students.add("zhang"+i);
        }

//        String listStr = JSONObject.toJSONString(students);
//        System.out.println(listStr);
//        try {
//            List<String> list = JSONObject.parseArray(listStr,String.class);
//            for(String str : list){
//                System.out.println(str);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        int lenth = students.size()/100;
//        for(int i = 0; i < lenth;i++){
//            System.out.println("循环次数："+i);
//            List<String> temp = students.subList(0,100);
//            System.out.println("size:"+temp.size());
//            students.removeAll(temp);
//        }
////        System.out.println("size:::::"+students.size());
//        students.clear();
////        System.out.println("清空后的个数："+students.size());
//
//        BigDecimal a = new BigDecimal(0);
//        BigDecimal b = new BigDecimal(0);
//        System.out.println(a.compareTo(b));
    List<BillDetail> billDetails = new ArrayList<BillDetail>(){{
       add(new BillDetail(new BigDecimal(0),"sss")) ;
       add(new BillDetail(new BigDecimal(0),"aaa")) ;
       add(new BillDetail(new BigDecimal(0),"xxx")) ;
       add(new BillDetail(new BigDecimal(0),"vvv")) ;
    }};

    BigDecimal bv = billDetails.stream().filter(b->b.getDealMoney().compareTo(new BigDecimal(1))>0).map(BillDetail::getDealMoney).reduce(BigDecimal::add).orElse(new BigDecimal(0));
        System.out.println(bv);


    }
}
