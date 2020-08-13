package com.zjx.juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList 写入并复制，适合迭代操作
 * 注意：添加操作多时效率低，因为每次添加时都会进行复制，开销会非常大。
 * 并发迭代多时可以选择
 * @author zhaojiaxing
 * @date 2020-02-25 21:45
 */
public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        for(int i = 0; i < 10; i++){
            new Thread(helloThread).start();
        }
    }
}

class HelloThread implements Runnable{
//    public static List<String> list = Collections.synchronizedList(new ArrayList<>());
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }
    @Override
    public void run() {
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            list.add("AA");
        }
    }
}
