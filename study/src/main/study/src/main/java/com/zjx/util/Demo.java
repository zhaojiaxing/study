package com.zjx.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class Demo {
    public static void main(String[] args) {
        BigDecimal a = null;
        Integer faultRate = 6;
        a = BigDecimal.valueOf(faultRate.doubleValue() / 3);
        BigDecimal b = a.setScale(2, RoundingMode.HALF_UP);//保留两位小数
        System.out.println("结果是" + b);
        //下面将结果转化成百分比
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);

        System.out.println(percent.format(b.doubleValue()));
    }
}
