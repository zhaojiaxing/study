package com.zjx;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/09 11:26
 */
public class StreamToMap {

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>() {{
            add(new User(2, "张三"));
            add(new User(2, "张三2"));
            add(new User(3, "张三3"));
            add(new User(4, "李四"));
            add(new User(5, "李四2"));
            add(new User(6, "王五"));
            add(new User(7, "王五2"));
        }};

        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(User::getId, a -> a, (k1, k2) -> k2));
        User user = userMap.get(2l);
        if (user != null) {
            user.setUserName("test");
        }
//        Iterator<Map.Entry<Long,User>> entries  = userMap.entrySet().iterator();
//        while (entries.hasNext()) {
//            Map.Entry<Long, User> entry = entries.next();
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        }
//        for (User user1 : users){
//            System.out.println(user1);
//        }


    }
}
