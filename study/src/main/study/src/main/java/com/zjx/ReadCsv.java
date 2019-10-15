package com.zjx;

import com.zjx.bean.EncodeUtils;

import java.io.*;
import java.util.*;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/09/16 10:29
 */
public class ReadCsv {
    public static void main(String[] args) {
        // 1. .csv文件的路径。注意只有一个\的要改成\\
//        File csv = new File(
////                "F:\\kerui\\人行需求\\2018111301查询结果201811.csv"); // CSV文件路径
////
////
////        BufferedReader br = null;
////        try {
////            br = new BufferedReader(new FileReader(csv));
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        }
////        String line = "";
////        String everyLine = "";
////        List<String[]> dataList = new ArrayList<>();
////        try {
//////            List<String> allString = new ArrayList<>();
////            while ((line = br.readLine()) != null) // 读取到的内容给line变量
////            {
////                everyLine = line;
//////                System.out.println(everyLine);
////                dataList.add(everyLine.split(","));
////            }
////            System.out.println("csv表格中所有行数：" + dataList.size());
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
        String path = "F:\\kerui\\人行需求\\2018111301查询结果201811121107RH000001.csv";
        String path2 = "F:\\kerui\\人行需求\\2018111301查询结果201811.csv";
        List<String[]> dataList = readCSV(path);
        dataList.stream().forEach(d -> {
            for (String s : d) {
                System.out.print(s + " ");
            }
            System.out.println("\t");
        });

    }

    public static List<String[]> readCSV(String path) {
        List<String[]> dataList = new ArrayList<>();
        try {
            File csv = new File(path); // CSV文件路径
            FileInputStream in = new FileInputStream(csv);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(csv));
            String encodeType = EncodeUtils.getEncode(new BufferedInputStream(new FileInputStream(new File(""))), true);

            System.out.println(encodeType);
            InputStreamReader isr = new InputStreamReader(in, encodeType);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) { // 读取到的内容给line变量
                String[] data = line.split(",");
                if(data != null && data.length > 0){
                    dataList.add(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }


}
