package com.zjx.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子变量与CAS
 *
 * i++的原子性问题：i++的操作实际分为三个步骤：“读-改-写”
 * i++在底层执行以下操作：
 * int temp = i;
 * i = i+1;
 * i = temp;
 * @author zhaojiaxing
 * @date 2020-02-24 21:58
 */
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();

        for(int i = 0; i <10; i++){
            new Thread(atomicDemo).start();
        }
    }
}

class AtomicDemo implements Runnable{

    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+": "+getSerialNumber());
    }

    public int getSerialNumber(){
        return serialNumber.getAndIncrement();
    }
}
