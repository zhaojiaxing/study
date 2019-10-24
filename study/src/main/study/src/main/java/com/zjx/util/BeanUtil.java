/**
 * @(#) BeanUtil.java      1.0  2018年4月3日  hunter
 * <p>
 * Copyright  (c)  2018 	keyway. All Rights Reserved.
 */
package com.zjx.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 实体工具类
 *
 * @author hunter
 * @version 1.0
 * @since 2018年4月3日 上午11:02:29
 */

public class BeanUtil {

    /**
     * 两个类相同属性值复制并返回新对象
     *
     * @param source 复制源
     * @param clazz  目标类
     * @author hunter
     * @since 2018年4月3日 上午11:13:40
     */
    public static <T> T copy(Object source, Class<T> clazz) {
        if (source != null) {
            T t;
            try {
                t = clazz.newInstance();
                org.springframework.beans.BeanUtils.copyProperties(source, t);
                return t;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 两个类相同属性值复制并返回新对象
     *
     * @param source 复制源
     * @param clazz  目标类
     * @return java.util.Optional<T>
     * @author zhoukebo
     * @since 2019/3/18 11:10
     */
    public static <T> Optional<T> copyOptional(Object source, Class<T> clazz) {
        if (source != null) {
            T t;
            try {
                t = clazz.newInstance();
                org.springframework.beans.BeanUtils.copyProperties(source, t);
                return Optional.of(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    /**
     * 两个类相同属性值复制并返回新对象
     *
     * @param sources 复制源
     * @param clazz   目标类
     * @author hunter
     * @since 2018年4月3日 上午11:13:40
     */
    public static <T> List<T> copyList(List<?> sources, Class<T> clazz) {
        if (sources != null && sources.size() > 0) {
            List<T> items = new ArrayList<>();
            try {
                T t = null;
                for (Object source : sources) {
                    t = clazz.newInstance();
                    org.springframework.beans.BeanUtils.copyProperties(source, t);
                    items.add(t);
                }
                return items;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    /**
     * JSON 格式字符串转换为对象
     *
     * @param json  json格式字符串
     * @param clazz 对象
     * @author hunter
     * @since 2018年4月11日 上午11:55:21
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        if (!StringUtils.isEmpty(json)) {
            return JSON.parseObject(json, clazz);
        }
        return null;
    }

    /**
     * JSON 格式字符串转换为对象集合
     *
     * @param jsonStr json格式字符串数组
     * @param clazz   对象
     * @author hunter
     * @since 2018年4月11日 上午11:58:55
     */
    public static <T> List<T> parseList(String jsonStr, Class<T> clazz) {
        if (!StringUtils.isEmpty(jsonStr)) {
            List<T> result = new ArrayList<>();
            JSONArray array = JSONArray.parseArray(jsonStr);
            for (int i = 0; i < array.size(); i++) {
                result.add(JSON.toJavaObject((JSONObject) array.get(i), clazz));
            }
            return result;
        }
        return null;
    }

    /**
     * 获取对象指定属性值
     *
     * @param bean 目标对象
     * @param name 属性名称
     * @author hunter
     * @since 2018年4月3日 下午3:01:10
     */
    public static String getProperty(Object bean, String name) {
        try {
            return BeanUtils.getProperty(bean, name);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 算出待删除记录ID
     *
     * @param news 重新编辑的集合
     * @param olds 上一版本集合
     * @author hunter
     * @since 2018年4月26日 下午4:23:12
     */
    public static List<Long> removeDuplicate(List<?> news, List<?> olds) {
        List<Long> newIds = new ArrayList<>();
        List<Long> oldsIds = new ArrayList<>();
        if (news != null && news.size() > 0) {
            for (Object object : news) {
                if (!StringUtils.isEmpty(getProperty(object, "id"))) {
                    newIds.add(Long.valueOf(getProperty(object, "id")));
                }
            }
        }
        if (olds != null && olds.size() > 0) {
            for (Object object : olds) {
                if (!StringUtils.isEmpty(getProperty(object, "id"))) {
                    oldsIds.add(Long.valueOf(getProperty(object, "id")));
                }
            }
        }
        oldsIds.removeAll(newIds);
        return oldsIds;
    }

    /**
     * Object 数组转换为实体对象工具方法
     *
     * @param objs Object 数组
     * @param clz  实体类
     * @author hunter
     * @since 2018/10/12 16:24
     **/
    public static <T> T transEntity(Object[] objs, Class<T> clz) {
        T entity = null;
        try {
            // 获取泛型实例
            entity = clz.newInstance();
            // 获取所有属性，按照属性顺序来赋值
            Field[] fields = clz.getDeclaredFields();
            for (int j = 0; j < fields.length; j++) {
                // 实时数据个数大于字段下标时赋值
                if (objs.length > j) {
                    // 解决 No value specified for 'Date'异常
                    ConvertUtils.register(new DateConverter(null), java.util.Date.class);
                    // 解决 No value specified for 'BigDecimal'异常
                    BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
                    BeanUtils.setProperty(entity, fields[j].getName(), objs[j]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    /**
     * 将map转换为实体类
     * 注意map的key必须为实体的属性名
     *
     * @param map
     * @param clz
     * @return: T
     * @author: zhaojiaxing
     * @createTime: 2019/10/23 0023 14:39
     */
    public static <T> T convertMap(Map map, Class<T> clz) {
        T entity = null;
        try {
            // 获取泛型实例
            entity = clz.newInstance();
            // 获取所有属性，按照属性顺序来赋值
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                String fieldName = field.getName();
                // 获取参数类型名字
                String filedTypeName = field.getType().getName();
                // 解决 No value specified for 'Date'异常
                ConvertUtils.register(new DateConverter(null), java.util.Date.class);
                // 解决 No value specified for 'BigDecimal'异常
                BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
                Object value = map.get(fieldName);
                // 判断是否为时间类型，使用equalsIgnoreCase比较字符串，不区分大小写
                if (filedTypeName.equalsIgnoreCase("java.util.date")) {
                    String dateTimestamp = value.toString();
                    if (!dateTimestamp.equalsIgnoreCase("null")) {
                        value =  DateTimeUtil.strToDate(dateTimestamp,DateTimeUtil.YYYY_MM_DDHHMMSS);
                    }
                }
                BeanUtils.setProperty(entity, fieldName, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }


    /**
     * 数组对象转实体集合工具方法
     *
     * @param items 数组对象
     * @param clz   实体类
     * @author hunter
     * @since 2018/10/12 16:29
     **/
    public static <T> List<T> transCollects(List<Object[]> items, Class<T> clz) {
        List<T> result = new ArrayList<>();
        try {
            if (null != items && items.size() > 0) {
                // 循环调用数组转对象接口
                items.forEach(item -> result.add(transEntity(item, clz)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    private static String format(Date date){
        DateFormat df2 = DateFormat.getDateTimeInstance();
        return df2.format(date);
    }

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("userAccountId", "asd");
//        map.put("otherAccountId", "zxc");
//        map.put("date", DateTimeUtil.dateToStr(new Date(),DateTimeUtil.YYYY_MM_DDHHMMSS));
//        Account account = convertMap(map, Account.class);
//
////        Object[] obj = {"asd","zxc","2019-10-23 14:55:48"};
////        Account account = transEntity(obj, Account.class);
//        System.out.println(account);

        List<Date> dates = new ArrayList<Date>(){{
            add(DateTimeUtil.transDatetimeToDate(new Date(119,6,12)));
            add(DateTimeUtil.transDatetimeToDate(new Date(119,6,12)));
            add(DateTimeUtil.transDatetimeToDate(new Date(119,6,12)));
            add(DateTimeUtil.transDatetimeToDate(new Date(119,7,12)));
            add(DateTimeUtil.transDatetimeToDate(new Date(119,7,12)));
        }};
        Set<Date> distinct = dates.stream().collect(Collectors.toSet());
        System.out.println(distinct);
    }

}
