package com.zjx.algorithm;

/**
 * 环形队列
 */
public class CircleArray {

    /**
     * 表示数组最大容量
     */
    private int maxSize;
    /**
     * 队列头 初始值为0
     */
    private int front;

    /**
     * 队列尾 初始值为0
     */
    private int rear;

    /**
     * 该数据用于存放数据，模拟队列
     */
    private int[] arr;

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    /**
     * 判断队列为空
     * @return
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 添加数据到队列
     * @param n
     */
    public void addQueue(int n){
        //判断队列满
        if(isFull()){
            System.out.println("队列满，不能添加元素");
            return;
        }

        //直接将数据加入
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear+1)%maxSize;
    }

    /**
     * 获取队列的数据，出队列
     * @return
     */
    public int getQueue(){
        //判断队列空
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移,后移的时候考虑取模
        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front+1) % maxSize;
        return value;
    }

    /**
     * 显示队列
     */
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        //思路，从front开始遍历，遍历多少个元素
        for(int i =front; i < front+size();i++){
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i]);
        }
    }

    /**
     * 返回当前队列的有效个数
     * @return
     */
    private int size(){
        return (rear - front + maxSize) % maxSize;
    }




}
