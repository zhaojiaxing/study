package com.zjx;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @description 日期转换工具类
 * @Date 2019/04/11 17:36
 */
public class DateUtil {

    public static Date strParseDate(final String str, String dateFormat) {
        try {
            if (Objects.isNull(str)) {
                return null;
            }
            if (Objects.isNull(dateFormat)) {
                dateFormat = "yyyy-MM-dd HH:mm:ss";
            }
            DateFormat fmt = new SimpleDateFormat(dateFormat);
            return fmt.parse(str.trim());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
