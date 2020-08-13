package com.zjx.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池
 *
 * @author zhaojiaxing
 * @date 2020-03-03 21:06
 */
public class TestThreadPool {

    public static void main(String[] args) throws Exception {

        //1. 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;

                    for (int i = 0; i <= 100; i++) {
                        sum += i;
                    }
                    return sum;
                }
            });
            list.add(future.get());
        }

        for(Integer i : list){
            System.out.println(i);
        }


//        ThreadPoolDemo demo = new ThreadPoolDemo();
//
//        for(int i = 0; i < 10; i++){
//            //2. 为线程池中的线程分配任务
//            executorService.submit(demo);
//        }

        //3. 关闭线程池
        executorService.shutdown();
    }

}

class ThreadPoolDemo implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        while (i <= 100) {
            System.out.println(Thread.currentThread().getName() + " : " + i++);
        }
    }
}
