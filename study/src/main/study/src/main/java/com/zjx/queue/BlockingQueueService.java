package com.zjx.queue;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/12/30 11:07
 */
public class BlockingQueueService implements Runnable {

    private static LinkedBlockingDeque<String> linkedBlockingQueue = new LinkedBlockingDeque<>();

    public static LinkedBlockingDeque<String> getBlockingQueue() {
        return linkedBlockingQueue;
    }

    @Override
    public void run() {
        while (linkedBlockingQueue.peek() != null){
            linkedBlockingQueue.poll();
        }

    }
}
