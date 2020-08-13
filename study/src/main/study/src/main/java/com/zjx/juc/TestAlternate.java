package com.zjx.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，开启 3 个线程，这三个线程的 ID 分别为A、B、C，每个线程将自己的 ID 在屏幕上打印 10 遍，要求输出的结果必须按顺序显示。
 *
 * @author zhaojiaxing
 * @date 2020-02-27 21:52
 */
public class TestAlternate {
    public static void main(String[] args) {
        AlternateDemo demo = new AlternateDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    demo.loopA(i);
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    demo.loopB(i);
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    demo.loopC(i);
                }
            }
        }, "C").start();
    }
}

class AlternateDemo {

    /**
     * 当前正在执行线程的标记
     */
    private int number = 1;

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    /**
     * totalLoop 循环第几轮
     *
     * @param totalLoop
     */
    public void loopA(int totalLoop) {
        lock.lock();

        try {
            //1. 判断
            if (number != 1) {
                condition1.await();
            }
            //2.打印
            System.out.println(Thread.currentThread().getName() + "\t" + totalLoop);


            //唤醒
            number = 2;
            condition2.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    /**
     * totalLoop 循环第几轮
     *
     * @param totalLoop
     */
    public void loopB(int totalLoop) {
        lock.lock();

        try {
            //1. 判断
            if (number != 2) {
                condition2.await();
            }
            //2.打印
            System.out.println(Thread.currentThread().getName() + "\t" + totalLoop);

            //唤醒
            number = 3;
            condition3.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    /**
     * totalLoop 循环第几轮
     *
     * @param totalLoop
     */
    public void loopC(int totalLoop) {
        lock.lock();

        try {
            //1. 判断
            if (number != 3) {
                condition3.await();
            }
            //2.打印
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + totalLoop);
            }

            System.out.println("---------------------------------------------------------------");

            //唤醒
            number = 1;
            condition1.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}
