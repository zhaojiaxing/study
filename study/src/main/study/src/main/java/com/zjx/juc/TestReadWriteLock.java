package com.zjx.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 1. ReadWriteLock: 读写锁
 * 写写/读写 需要互斥
 * @author zhaojiaxing
 * @date 2020-02-27 22:17
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.set((int)(Math.random()*101));
            }
        },"Write:").start();

        for(int i = 0; i < 100; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.get();
                }
            }).start();
        }
    }
}

class ReadWriteLockDemo{

    public int number = 0;

    public ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 读
     */
    public void get(){
        // 上锁
        lock.readLock().lock();


        try {
            System.out.println(Thread.currentThread().getName()+ " : "+ number);
        } finally {
            //释放锁
            lock.readLock().unlock();
        }

    }

    //写
    public void set(int number){
        //上锁
        lock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        } finally {
            lock.writeLock().unlock();
        }

    }

}
