package com.zjx.juc;

/**
 * volatile关键字
 * @author zhaojiaxing
 * @date 2020-02-24 21:18
 */
public class TestVolatile {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        new Thread(threadDemo).start();

        while(true){
            if(threadDemo.isFlag()){
                System.out.println("---------------------------------");
                break;
            }
        }
    }
}

class ThreadDemo implements Runnable{

    /**
     * volatile关键字保证变量的内存可见性
     */
    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;

        System.out.println("flag="+isFlag());
    }

    public boolean isFlag(){
        return flag;
    }
}
