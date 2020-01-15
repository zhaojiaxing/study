package com.zjx.spring.bean;

import org.springframework.stereotype.Service;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2020/01/03 15:06
 */
@Service
public class FunctionService {

    public String sayHello(String word){
        return "Hello " + word + " !";
    }
}
