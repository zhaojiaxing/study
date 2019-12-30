package com.zjx.util;

import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author zhaojiaxing
 * @version 1.0
 * @description 身份证相关工具类
 * @Date 2019/04/11 9:46
 */
public class CardUtil {

    /**
     * 根据身份证获取年龄
     *
     * @param cardCode
     * @return: java.lang.Integer
     * @author: zhaojiaxing
     * @createTime: 2019/11/11 0011 11:39
     */
    public static Integer getAge(String cardCode) {
        judgeCard(cardCode);
        int length = cardCode.length() == 18 ? 14 : 12;
        //先获取生日串(15位身份证都是2000年以前出生的)
        String birthday = cardCode.length() == 18 ? cardCode.substring(6, length) : "19".concat(cardCode.substring(6, length));
        //通过生日获取年月日
        int year = Integer.parseInt(birthday.substring(0, 4));
        int month = Integer.parseInt(birthday.substring(4, 6));
        int day = Integer.parseInt(birthday.substring(6, 8));

        // 得到当前的系统时间并获取当前的年月日
        String localDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        int localYear = Integer.parseInt(localDate.substring(0, 4));
        int localMonth = Integer.parseInt(localDate.substring(5, 7));
        int localDay = Integer.parseInt(localDate.substring(8, 10));

        int age = localYear - year;
        //如果日期小于当前日期则减一（还未过生，年龄不变）
        if(localMonth < month || (localMonth == month && localDay < day)){
            age--;
        }
        return age;
    }

    /**
     * 根据身份证号码判断用户男女
     *
     * @param cardCode
     * @return: java.lang.Integer
     * @author: zhaojiaxing
     * @createTime: 2019/11/11 0011 11:45
     */
    public static Integer getSex(String cardCode) {
        judgeCard(cardCode);
        String sign = cardCode.length() == 18 ? cardCode.substring(16, 17) : cardCode.substring(14, 15);
        return Integer.parseInt(sign) % 2 == 0 ? 2 : 1;
    }

    /**
     * 判断身份证格式
     * @param cardCode
     * @return: java.lang.Integer
     * @author: zhaojiaxing
     * @createTime: 2019/11/11 0011 11:45
     */
    private static void judgeCard(String cardCode){
        if (StringUtils.isEmpty(cardCode) || (cardCode.length() != 15 && cardCode.length() != 18)) {
            throw new RuntimeException("身份证号码格式错误");
        }
    }
}