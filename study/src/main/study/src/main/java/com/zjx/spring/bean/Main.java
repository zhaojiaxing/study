package com.zjx.spring.bean;

import com.zjx.spring.bean.DiConfig;
import com.zjx.spring.bean.UseFunctionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2020/01/03 15:15
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("di"));
        context.close();
    }
}
