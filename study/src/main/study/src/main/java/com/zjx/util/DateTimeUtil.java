package com.zjx.util;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * 日期时间工具类
 *
 * @author hunter
 * @version 1.0
 * @since 2018/9/19 14:40
 */
@Slf4j
public class DateTimeUtil {
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM = "yyyy-MM";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYY_MM_DDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    /**
     * 将日期转换成指定格式的字符串.
     *
     * @param date       日期
     * @param dateFormat 日期格式. 如果为空，默认为:yyyy-MM-dd HH:mm:ss.
     * @author hunter
     * @since 2018/9/19 14:40
     **/
    public static String dateToStr(final Date date, String dateFormat) {
        if (date == null) {
            return "";
        }
        try {
            if (dateFormat == null || dateFormat.trim().length() == 0) {
                dateFormat = "yyyy-MM-dd HH:mm:ss";
            }
            DateFormat fmt = new SimpleDateFormat(dateFormat.trim());
            return fmt.format(date);
        } catch (Exception ex) {
            log.error("将日期转换成指定格式({})的字符串时失败！错误原因：{}", dateFormat, ex.getMessage());
            return "";
        }
    }

    /**
     * 将当前日期转换成yyyyMMddHHmmss的字符串. 如：20180726112754
     *
     * @author hunter
     * @since 2018/8/31 19:36
     **/
    public static String currDateToStr() {
        return dateToStr(new Date(), "yyyyMMddHHmmss");
    }

    /**
     * 将字符串转换成指定格式的日期
     *
     * @param str        日期字符串.
     * @param dateFormat 日期格式. 如果为空，默认为:yyyy-MM-dd HH:mm:ss.
     * @return
     */
    public static Date strToDate(final String str, String dateFormat) {
        if (str == null || str.trim().length() == 0) return null;
        try {
            if (dateFormat == null || dateFormat.length() == 0) dateFormat = "yyyy-MM-dd HH:mm:ss";
            DateFormat fmt = new SimpleDateFormat(dateFormat);
            return fmt.parse(str.trim());

        } catch (Exception ex) {
            log.error("将字符串(" + str + ")转换成指定格式(" + dateFormat + ")的日期时失败！错误原因：", dateFormat, ex.getMessage());
            return null;
        }
    }

    /**
     * 字符串转换为日期（默认格式为yyyy-MM-dd）
     *
     * @param str 待转换为日志字符串
     * @author hunter
     * @since 2018/11/15 18:33
     **/
    public static Date strToDate(final String str) {
        return strToDate(str, YYYY_MM_DD);
    }

    /**
     * 获取两个日期间隔的所有日期
     *
     * @param start 格式必须为'2018-01-25'
     * @param end   格式必须为'2018-01-25'
     * @return
     */
    public static List<String> getBetweenDate(String start, String end) {
        List<String> list = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        if (distance < 1) {
            return list;
        }
        Stream.iterate(startDate, d -> {
            return d.plusDays(1);
        }).limit(distance + 1).forEach(f -> {
            list.add(f.toString());
        });
        return list;
    }

    /***
     * 日期月份减N个月
     * @param datetime
     */
    public static String dateMinus(String datetime, int num) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.MONTH, 0 - num);
        date = cl.getTime();
        return sdf.format(date);
    }

    /**
     * 在指定日期上面加减相应的日期
     *
     * @param addType  加减天还是月标识
     * @param datetime 原日期
     * @param num      增减的数量
     * @return 计算后的日期
     */
    public static Date addTime(Integer addType, Date datetime, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(datetime);
        c.add(addType, num);
        return c.getTime();
    }

    /**
     * 日期天数增加num天
     *
     * @param datetime 日期
     * @param format   格式模板
     * @param num      增加天数
     * @return 增加后的时间
     * @author zhoukb
     * @since 2019/5/24 14:47
     */
    public static String addDaysToDate(String datetime, String format, int num) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(strToDate(datetime, format));
        //增加num天
        cd.add(Calendar.DATE, num);
        return dateToStr(cd.getTime(), format);
    }

    /**
     * 获取某月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
    }

    /**
     * 获取某年某月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getFisrtDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime());
        return firstDayOfMonth;
    }

    /**
     * 获取两个日期之间的所有月份
     *
     * @param minDate
     * @param maxDate
     * @return
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        try {
            min.setTime(sdf.parse(minDate));
            max.setTime(sdf.parse(maxDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    /**
     * 获取两个日期之间的所有月份
     *
     * @param minDate
     * @param maxDate
     * @return
     */
    public static List<String> getMonthBetween(Date minDate, Date maxDate) {
        ArrayList<String> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(minDate);
        max.setTime(maxDate);
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    /**
     * 根据开始结束时间将日期划分为周
     *
     * @param sTime
     * @param eTime
     * @return
     */
    public static List<String> getWeekList(String sTime, String eTime) {
        LocalDate startTime = LocalDate.parse(sTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endTime = LocalDate.parse(eTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<String> resultList = new ArrayList();
        //判断是否同一周
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 4);
        if (startTime.get(weekFields.weekOfWeekBasedYear()) == endTime.get(weekFields.weekOfWeekBasedYear())) {
            resultList.add(startTime + " 00:00:00" + "," + endTime + " 23:59:59");
            return resultList;
        }
        //开始周
        TemporalAdjuster FIRST_OF_WEEK = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.minusDays(localDate.getDayOfWeek().getValue() - DayOfWeek.MONDAY.getValue()));
        LocalDate startFirstWeek = startTime.with(FIRST_OF_WEEK);  //开始周开始日期
        TemporalAdjuster LAST_OF_WEEK = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.plusDays(DayOfWeek.SUNDAY.getValue() - localDate.getDayOfWeek().getValue()));
        LocalDate endFirstWeek = startTime.with(LAST_OF_WEEK);     //开始周结束日期

        //结束周
        TemporalAdjuster FIRST_OF_WEEK1 = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.minusDays(localDate.getDayOfWeek().getValue() - DayOfWeek.MONDAY.getValue()));
        LocalDate startLastWeek = endTime.with(FIRST_OF_WEEK1);
        TemporalAdjuster LAST_OF_WEEK1 = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.plusDays(DayOfWeek.SUNDAY.getValue() - localDate.getDayOfWeek().getValue()));
        //将第一周添加
        resultList.add(startTime + " 00:00:00" + "," + endFirstWeek + " 23:59:59");
        while (true) {
            startFirstWeek = startFirstWeek.plusDays(7);
            if (startFirstWeek.with(LAST_OF_WEEK).equals(startLastWeek.with(LAST_OF_WEEK1))) {
                break;
            } else {
                resultList.add(startFirstWeek.with(FIRST_OF_WEEK) + " 00:00:00" + "," + startFirstWeek.with(LAST_OF_WEEK) + " 23:59:59");
            }
        }
        resultList.add(startLastWeek + " 00:00:00" + "," + endTime + " 23:59:59");
        return resultList;
    }

    /**
     * 将整数秒转换成时分秒
     *
     * @param callTime
     * @return
     */
    public static String secToTime(Long callTime) {
        int time = 0;
        if (callTime != null) {
            time = callTime.intValue();
        }
        String timeStr;
        int hour;
        int minute;
        int second;
        if (time <= 0) return "00分00秒";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + "分" + unitFormat(second) + "秒";
            } else {
                hour = minute / 60;
                if (hour > 99) return "99小时59分59秒";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + "小时" + unitFormat(minute) + "分" + unitFormat(second) + "秒";
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10) retStr = "0" + Integer.toString(i);
        else retStr = "" + i;
        return retStr;
    }

    /**
     * 将几分几秒格式的字符串转化成秒
     *
     * @param time 时间字符串
     * @return 时间转换后的秒数
     * @author zhoukb
     * @since 2019/7/10 11:18
     */
    public static Integer getSecondsFromStr(String time) {
        //判断是否为纯数字的正则表达式
        String reg = "^\\d+$";
        if (time.matches(reg)) {
            return Integer.parseInt(time);
        } else {
            //小时
            int s = 0;
            int hourIndex = time.indexOf("时");
            int minuteIndex = time.indexOf("分");
            int secondIndex = time.indexOf("秒");
            if (hourIndex >= 0) {
                s += Integer.parseInt(time.substring(0, hourIndex)) * 3600;
            }
            if (minuteIndex >= 0) {
                //分钟
                s += Integer.parseInt(time.substring(hourIndex >= 0 ? hourIndex + 1 : 0, minuteIndex)) * 60;
            }
            if (secondIndex >= 0) {
                //秒
                s += Integer.parseInt(time.substring(minuteIndex >= 0 ? minuteIndex + 1 : hourIndex >= 0 ? hourIndex + 1 : 0, secondIndex));
            }
            return s;
        }
    }

    /**
     * @desc 根据年龄获取出生日期
     * @param age 年龄
     * @return java.util.Date 出生日期
     * @author tangxin
     * @date 2019/7/19
     */
    public static LocalDate getBirthdayByAge(Integer age){
        LocalDate now = LocalDate.now();
        return now.minusYears(age);
    }

    /**
     * @desc 根据身份证获取生日
     * @param idCard 身份证号
     * @return java.util.Date 生日
     * @author tangxin
     * @date 2019/7/23
     */
    public static Date getBirthdayByIdCard(String idCard){
        String birthStr = idCard.substring(6,14);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            return format.parse(birthStr);
        } catch (ParseException e) {
            log.error("getBirthdayByIdCard error ,{}",idCard);
        }
        return null;
    }

    public static Date transDatetimeToDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        LocalDate localDate = LocalDate.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH));
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate getLocalDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return LocalDate.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH));
    }

    public static LocalDateTime transToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * @desc 判断是否后半夜
     * @param date
     * @return boolean
     * @author tangxin
     * @date 2019/10/16
     */
    public static boolean inLateNight(Date date){
        if (date == null) return false;
        LocalDateTime localDateTime = transToLocalDateTime(date);
        return  localDateTime.getHour()>=0 && localDateTime.getHour()<=5;
    }

    /**
     * 返回日期
     * @param date
     * @return: java.util.Date
     * @author: zhaojiaxing
     * @createTime: 2019/9/10 0010 13:58
     */
    public static Date getDate(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sf.format(date);
        try {
            return sf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
//        ca.add(Calendar.DATE,5);
//        System.out.println(ca.get(Calendar.DATE));
        // 5天后
        calendar.add(Calendar.DATE,5);
        int day_5 = calendar.get(Calendar.DATE);
        System.out.println("五天后是" + day_5+"日");
    }

}
