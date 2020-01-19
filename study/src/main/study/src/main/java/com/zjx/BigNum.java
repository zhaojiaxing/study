package com.zjx;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/12/20 15:18
 */
public class BigNum {
    public static void main(String[] args) {
//        BigInteger num = BigInteger.valueOf(-1000);
//        BigInteger other = BigInteger.valueOf(30);
//        System.out.println("num 加 other 的值为: "+num.add(other));
//        System.out.println("num 减 other 的值为: "+num.subtract(other));
//        System.out.println("num 乘 other 的值为: "+num.multiply(other));
//        System.out.println("num 除 other 的值为: "+num.divide(other));
//        System.out.println("num 除 other 的余数为: "+num.mod(other));
//        BigInteger[] divideAndRemainder = num.divideAndRemainder(other);
//        System.out.println("num 除 other 的值为: "+divideAndRemainder[0]+"num 除 other 的余数为: "+divideAndRemainder[1]);
//        System.out.println(" "+num.signum());
//        BigInteger b =new BigInteger("100");
        BigDecimal big = BigDecimal.valueOf(1500);
        BigDecimal big2 = BigDecimal.valueOf(1300);
        BigDecimal big3 = BigDecimal.valueOf(1000);
        BigDecimal result = big2.add(big3);
        System.out.println(result.divide(big,6, BigDecimal.ROUND_HALF_UP));
        double va = big2.divide(big,6,BigDecimal.ROUND_HALF_UP).doubleValue();
        double va2 = big3.divide(big,6,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(va);
        System.out.println(va2);
        System.out.println(va+va2);

    }
}
