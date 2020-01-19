package com.zjx.spring.bean;

import com.zjx.spring.bean.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2020/01/03 15:11
 */
@Service
public class UseFunctionService {
    @Autowired
    private FunctionService functionService;

    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}
