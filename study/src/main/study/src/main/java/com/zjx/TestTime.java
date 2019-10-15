package com.zjx;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/28 20:30
 */
public class TestTime {
    public static void main(String[] args) {
//        Date date = new Date();
////        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        String rr = simpledateformat.format(date);
////        Date date1 = stringToDate(rr,"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm:ss");
////        System.out.println(date1);
        String str = "sdsds";
        System.out.println(str.split(".")[0]);
    }

    /**
     * 将字符串型日期转换为日期型
     *
     * @param strDate
     *            字符串型日期
     * @param srcDateFormat
     *            源日期格式
     * @param dstDateFormat
     *            目标日期格式
     * @return Date 返回的util.Date型日期
     */
    public static Date stringToDate(String strDate, String srcDateFormat, String dstDateFormat) {
        Date rtDate = null;
        Date tmpDate = (new SimpleDateFormat(srcDateFormat)).parse(strDate, new ParsePosition(0));
        String tmpString = null;
        if (tmpDate != null)
            tmpString = (new SimpleDateFormat(dstDateFormat)).format(tmpDate);
        if (tmpString != null)
            rtDate = (new SimpleDateFormat(dstDateFormat)).parse(tmpString, new ParsePosition(0));
        return rtDate;
    }
}
