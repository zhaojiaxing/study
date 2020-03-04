package com.zjx.juc;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 测试线程调度
 * @author zhaojiaxing
 * @date 2020-03-03 21:57
 */
public class TestScheduledTreadPool {
    public static void main(String[] args) throws Exception{
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        for(int i = 0; i < 10;i++){
            Future future = pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    //生成随机数
                    int num = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName()+" : "+num);
                    return num;
                }
            },1, TimeUnit.SECONDS);

            System.out.println(future.get());
        }

        pool.shutdown();

    }
}
