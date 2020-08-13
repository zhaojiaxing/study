package com.zjx.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口
 * 相较于实现Runnable接口的方式，方法可以有返回值。并且可以抛出异常
 * @author zhaojiaxing
 * @date 2020-02-26 20:43
 */
public class TestCallable {

    public static void main(String[] args) {
        ThreadCallableDemo demo = new ThreadCallableDemo();

        //执行Callable方式，需要FutureTask 实现类的支持，用于接收运算结果。FutureTask是Future接口的实现类
        FutureTask<Integer> result = new FutureTask<>(demo);
        new Thread(result).start();

        try {
            Integer sum = result.get();
            System.out.println(sum);
            System.out.println("--------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ThreadCallableDemo implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 0; i <= 100;i++){
            sum += i;
        }
        return sum;
    }
}
