package com.zjx.juc;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch: 闭锁，在完成某些运算时，只有其他所有线程的运算全部完成当前线程才执行。
 * @author zhaojiaxing
 * @date 2020-02-25 21:59
 */
public class TestCountDownLatch {
    public static void main(String[] args) {

        final  CountDownLatch latch = new CountDownLatch(5);
        LatchDemo ld = new LatchDemo(latch);

        long start = System.currentTimeMillis();
        for(int i = 0; i < 5 ; i++){
            new Thread(ld).start();
        }

        try {
            //线程等待，等其他线程执行完后才执行当前线程
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("耗时时间为："+(System.currentTimeMillis() - start));
    }
}

class LatchDemo implements Runnable{

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {

        synchronized (this){
            try {
                for(int i = 0; i < 50000; i++){
                    if(i % 2 == 0){
                        System.out.println(i);
                    }
                }
            } finally {
                latch.countDown();
            }
        }

    }
}
