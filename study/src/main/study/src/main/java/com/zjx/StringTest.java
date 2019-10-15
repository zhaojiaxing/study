package com.zjx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.zjx.bean.Account;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/08/27 21:41
 */
public class StringTest {
    public static void main(String[] args) throws UnsupportedEncodingException {

//        String s = "张三";
//        System.out.println(s.length());
//        System.out.println(s.codePointCount(0,s.length()));
//        System.out.println(s.getBytes("UTF-8").length);
//        List<Integer> a = new ArrayList<Integer>(){{add(1);add(2);add(3);add(4);}};
//        System.out.println(a.toString());
//        List<Integer> c = JSON.parseArray(a.toString(),Integer.class);
//        System.out.println(c);

        List<Account> accounts = new ArrayList<Account>(){{
            add(new Account(1342l,16l));
            add(new Account(1342l,17l));
            add(new Account(171l,234l));
            add(new Account(171l,234l));
            add(new Account(172l,234l));
            add(new Account(17444l,234l));
            add(new Account(17444l,234l));
//            add(new Account(175555l,234l));
//            add(new Account(172234l,234l));
//            add(new Account(1756565l,234l));
//            add(new Account(1723232l,234l));
//            add(new Account(178787l,234l));
//            add(new Account(1733424l,234l));
//            add(new Account(1232327l,234l));
        }};

        List<Account> set = new ArrayList<Account>(){{
            add(new Account(1342l,162l,new Date()));
            add(new Account(1342l,162l,new Date()));
            add(new Account(171l,2345l,new Date(119,2,12)));
            add(new Account(171l,2345l,new Date(119,8,15)));
//            add(new Account(177l,234l));
//            add(new Account(172l,234l));
//            add(new Account(17444l,234l));
            add(new Account(17444l,234l,new Date(119,7,16)));
        }};
        List<Account> uni = set.stream().collect(
                collectingAndThen(
                        toCollection(()->new TreeSet<>(comparing(Account::getUserAccountId))),ArrayList::new));

//        Optional<Account> opt = uni.stream().min(Comparator.comparing(Account::getDate));
//        System.out.println(opt.get());
//        System.out.println(uni);

        String s = uni.stream().map(Account::getUserAccountId).map(String::valueOf).distinct().collect(Collectors.joining(","));
        System.out.println(s);
//        accounts.removeIf(a -> a.getUserAccountId().equals(172l));
//        System.out.println(accounts);
//        Map<Long, List<Account>> map = accounts.stream().collect(Collectors.groupingBy(Account::getUserAccountId));
//        for(Map.Entry<Long, List<Account>> entry : map.entrySet()){
//            System.out.println(entry.getValue().size());
//        }

//        test3(accounts);
//        System.out.println();
//        List<Account> accounts2 =accounts.stream().filter(account -> account.getUserAccountId().longValue()==234l).collect(Collectors.toList());
//        Account account = accounts2.get(0);
//        accounts.remove(account);
//        account.setUserAccountId(45677l);
//        accounts.add(account);
//        System.out.println(accounts);
//        accounts.stream().collect(collectingAndThen(
//                toCollection(() -> new TreeSet<>(comparing(o -> o.getUserAccountId() + ";" + o.getOtherAccountId()))), ArrayList::new)
//        );
//
//
//        accounts.forEach(a-> System.out.println(a));

//        List<String> test = new ArrayList<String>(){{add("qweer");add("123");add("345");add("zxc");add("rty");}};
//        System.out.println(test.contains("123"));

//        System.out.println(getSqlDate(getDate(new Date())));
//        System.out.println(getSqlDate(new Date()));

//        Date date1 = new Date();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Date date2 = new Date();
//        System.out.println(date1 == date2);
////        System.out.println(date2.compareTo(date1));
//        System.out.println(getKey("3456",3,new Date().getTime()));

//        for(int i = 0;i < 10;i++){
//            for(int j = i+1;j < 10;j++){
//                if(j==5){
//                    break;
//                }
//                System.out.println(i+" : "+j);
//            }
//        }
//        LocalDate localDate = LocalDate.now().minusYears(1);
//        System.out.println(localDate.toString());
//        List<List<Account>> accountsL = splitList(accounts,5);
//        for(List<Account> accounts1 : accountsL){
//            System.out.println(accounts1);
//        }
//        String str = null;
//        str.trim();
    }

    public static void test3(List<Account> array) {
        int i,j;
        Account temp;
        for(i=1;i<array.size();i++) {
            temp=array.get(i);
            for(j=i-1;j>=0;j--) {
                if(temp.getUserAccountId()>array.get(j).getUserAccountId()) {
                    break;
                }else {
                    array.set(j+1,array.get(j));
                }
            }
            array.set(j+1,temp);
        }

    }

    public static String getSqlDate(Date date){
        DateFormat df2 = DateFormat.getDateTimeInstance();
        return df2.format(date);
    }

    public static Date transDatetimeToDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        LocalDate localDate = LocalDate.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH)+1,
                cal.get(Calendar.DAY_OF_MONTH));
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Integer getHour(Date date){
        SimpleDateFormat sf = new SimpleDateFormat("HH");
        String time = sf.format(date);
        return Integer.valueOf(time);
    }

    public static Date getDate(Date date){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sf.format(date);
        try {
            return sf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getKey(String idCard,Integer type,Long date){
        return idCard + "-" + type + "-"+date;
    }

//    public static <T> List<List<T>> averageAssign(List<T> list,int n){
//        List<List<T>> result=new ArrayList<List<T>>();
//        int remaider=list.size()%n;  //(先计算出余数)
//        int number=list.size()/n;  //然后是商
//        int offset=0;//偏移量
//        for(int i=0;i<n;i++){
//            List<T> value=null;
//            if(remaider>0){
//                value=list.subList(i*number+offset, (i+1)*number+offset+1);
//                remaider--;
//                offset++;
//            }else{
//                value=list.subList(i*number+offset, (i+1)*number+offset);
//            }
//            result.add(value);
//        }
//        return result;
//    }

    public static<T> List<List<T>> splitList(List<T> list, int len) {
        if (list == null || list.size() == 0 || len < 1) {
            return null;
        }

        List<List<T>> result = new ArrayList<List<T>>();


        int size = list.size();
        int count = (size + len - 1) / len;


        for (int i = 0; i < count; i++) {
            List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }
        return result;
    }






}
