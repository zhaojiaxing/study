package com.zjx.algorithm;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/10/31 21:56
 */
public class MyQueue {
    //表示队列的数组
    private int[] queue;
    //头部下标
    private int head;
    //尾部下标
    private int tail;

    public MyQueue(int n) {
        queue = new int[n];
        head = -1;
        tail = -1;
    }

    /**
     * 判断队列为空
     *
     * @return:
     * @author: zhaojiaxing
     * @createTime: 2019/10/31 0031 22:02
     */
    public boolean isEmpty() {
        return head == tail ? true : false;
    }

    /**
     * 判断队列是否已满
     *
     * @return:
     * @author: zhaojiaxing
     * @createTime: 2019/10/31 0031 22:04
     */
    public boolean isFull() {
        if (head >= queue.length - 1) {
            return true;
        }
        return false;
    }

    /**
     * 向队列中放元素
     *
     * @param num
     * @return: int
     * @author: zhaojiaxing
     * @createTime: 2019/10/31 0031 22:12
     */
    public int add(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满，不能再添加元素");
        }
        head++;
        queue[head] = num;
        return queue[head];
    }

    /**
     * 向队列中取元素
     * @param
     * @return: int
     * @author: zhaojiaxing
     * @createTime: 2019/10/31 0031 22:15
     */
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能再获取元素");
        }
        tail++;
        return queue[tail];
    }

    /**
     * 打印队列
     * @return:
     * @author: zhaojiaxing
     * @createTime: 2019/10/31 0031 22:20
     */
    public void searchQueue(){
        if(isEmpty()){
            System.out.println("队列 为空");
        }
        for(int i = tail+1;i<=head;i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        //初始化队列
        MyQueue queue = new MyQueue(10);
        //向队列中添加元素
        try {
            for(int i = 0;i < 12;i++){
                queue.add((int)((Math.random()+1)*20));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        queue.searchQueue();

        //从队列中读取元素
        try {
            System.out.println("向队列中获取元素");
            for(int i = 0;i < 12;i++) {
                System.out.println(queue.get());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        queue.searchQueue();
    }
}
