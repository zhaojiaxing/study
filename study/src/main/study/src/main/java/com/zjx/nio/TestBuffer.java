package com.zjx.nio;

import java.nio.ByteBuffer;

/**
 * 一、缓冲区（Buffer）：在java NIO中负责数据的存取。缓冲区就是数组，用于存储不同数据类型的数据
 * 根据数据类型不同，提供了相应类型的缓冲区：
 *ByteBuffer
 * CharBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过allocate()获取缓冲区
 *
 * 二、缓冲区存取数据的两个核心方法：
 *
 * put():存入数据到缓冲区
 * get():获取缓冲区的数据
 * @author zhaojiaxing
 * @date 2020-02-02 21:50
 */
public class TestBuffer {
    public static void main(String[] args) {
//        testBuffer();
        testMark();
    }

    /**
     * 测试buffer
     */
    public static void testBuffer(){
        // 1. 分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        System.out.println("------------allocate()--------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //2. 利用put存入数据
        String str = "abcde";
        buf.put(str.getBytes());

        System.out.println("------------put()--------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //3. 切换到读取数据模式
        buf.flip();

        System.out.println("------------flip()--------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //4. 读取数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst,0,dst.length));

        System.out.println("------------get()--------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //5. rewind() 可重复读数据
        buf.rewind();

        System.out.println("------------rewind()--------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        // 6. clear() 清空缓冲区,但是缓冲区的数据依然存在，但是处于“被遗忘”状态
        buf.clear();

        System.out.println("------------clear()--------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println((char)buf.get());
    }

    public static void testMark(){
        // 1. 分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        String str = "abcde";
        buf.put(str.getBytes());

        buf.flip();

        byte[] dst = new byte[1024];
        buf.get(dst,0,2);
        System.out.println(new String(dst,0,2));
        System.out.println(buf.position());

        //mark():标记
        buf.mark();

        buf.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println(buf.position());

        //reset()，恢复到mark标记的位置
        buf.reset();
        System.out.println(buf.position());

        //缓冲区是否有可操作的字节
        if(buf.hasRemaining()){
            //打印还有多少可操作的字节
            System.out.println(buf.remaining());
        }
    }

}
