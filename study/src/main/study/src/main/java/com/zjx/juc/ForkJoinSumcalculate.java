package com.zjx.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author zhaojiaxing
 * @date 2020-03-03 22:15
 */
public class ForkJoinSumcalculate extends RecursiveTask<Long> {

    private long start;

    private long end;

    //临界值
    private static final long THURSHOLD = 10000L;

    public ForkJoinSumcalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if(length <= THURSHOLD){
            long sum = 0L;
            for(long i = start; i <= end; i++){
                sum+=i;
            }
            return sum;
        }else {
            long middle = (start+end)/2;
            //进行拆分，同时压入线程队列
            ForkJoinSumcalculate left = new ForkJoinSumcalculate(start,middle);
            left.fork();

            ForkJoinSumcalculate right = new ForkJoinSumcalculate(middle+1,end);
            right.fork();

            return left.join()+right.join();
        }
    }
}

class TestForkJoinPool{
    public static void main(String[] args) {
        testForkJoin();
//        test1();
        test2();
    }

    public static void testForkJoin(){
        long start = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSumcalculate(0,10000000000L);

        Long sum = pool.invoke(task);
        System.out.println(sum);
        System.out.println("fork join总计耗时："+ (System.currentTimeMillis() - start));
    }

    public static void test1(){
        long start = System.currentTimeMillis();
        long sum = 0;
        for(int i = 0; i <= 10000000000L;i++){
            sum += i;
        }
        System.out.println(sum);
        System.out.println("普通方法总计耗时："+ (System.currentTimeMillis() - start));
    }

    /**
     * java 8 新特性
     */
    public static void test2(){
        long start = System.currentTimeMillis();
        Long sum = LongStream.rangeClosed(0L,10000000000L).parallel().reduce(0L,Long::sum);
        System.out.println(sum);
        System.out.println("java8 新特性总计耗时："+ (System.currentTimeMillis() - start));
    }
}
