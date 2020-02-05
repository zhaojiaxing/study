package com.zjx.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 通道（Channel）：用于源节点与目标节点的连接。
 * 在java NIO中负责缓冲区的数据传输。Channel本身不存在数据，因此需要配合缓冲区进行传输。
 *
 * @author zhaojiaxing
 * @date 2020-02-03 11:45
 */
public class TestChannel {

    public static void main(String[] args) throws Exception{
//        copyFile();
//        copyFileByChannel();
//        transfer();
//        randomAccess();
        charset();
    }

    public static void charset() throws Exception{
        //查看支持的字符集列表
//        Map<String, Charset> map = Charset.availableCharsets();
//        for(Map.Entry <String, Charset> entry : map.entrySet()){
//            System.out.println(entry.getKey()+"="+entry.getValue());
//        }
        //指定编码集
        Charset c = Charset.forName("GBK");

        //获取编码器
        CharsetEncoder ce = c.newEncoder();

        //获取解码器
        CharsetDecoder cd = c.newDecoder();

        CharBuffer cuf = CharBuffer.allocate(1024);
        cuf.put("好好学习，天天向上");
        cuf.flip();

        //编码
        ByteBuffer buffer = ce.encode(cuf);

        for(int i = 0;i < 18; i++){
            System.out.println(buffer.get());
        }

        //解码
        buffer.flip();
        CharBuffer charBuffer = cd.decode(buffer);
        System.out.println(charBuffer.toString());

        System.out.println("--------------------------------");
        Charset cs2 = Charset.forName("UTF-8");
        buffer.flip();
        CharBuffer charBuffer1 = cs2.decode(buffer);
        System.out.println(charBuffer1.toString());


    }

    /**
     * 利用通道实现文件的复制(非直接缓冲区)
     */
    public static void copyFile() {
        long start = System.currentTimeMillis();
        FileChannel outChannel = null;
        FileChannel inChannel = null;

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("E:\\demo\\Java网络编程(第4版).pdf");
            fos = new FileOutputStream("E:\\demo\\Java网络编程(第4版copy).pdf");

            //1. 获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            //分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //将通道中的数据存入缓冲区
            while (inChannel.read(buf) != -1) {
                //切换到读取数据模式
                buf.flip();

                //将缓冲区的数据写入通道中
                outChannel.write(buf);
                //清空缓冲区
                buf.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("耗费时间："+(System.currentTimeMillis() - start));
    }

    /**
     * 使用直接缓冲区实现文件的复制（内存映射文件）
     */
    public static void copyFileByChannel(){
        long start = System.currentTimeMillis();
        try {
            //获取通道
            FileChannel inChannel = FileChannel.open(Paths.get("e:\\demo\\Java网络编程(第4版).pdf"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("e:\\demo\\Java网络编程(第4版copy).pdf"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

            //内存映射文件
            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

            //直接对缓冲区进行数据的读写操作
            byte[] dst = new byte[inMappedBuf.limit()];
            inMappedBuf.get(dst);
            outMappedBuf.put(dst);

            inChannel.close();
            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("耗费时间："+(System.currentTimeMillis() - start));
    }

    /**
     * 通道之间的数据传输（直接缓冲区）
     */
    public static void transfer(){
        long start = System.currentTimeMillis();
        try {
            FileChannel inChannel = FileChannel.open(Paths.get("e:\\demo\\Java网络编程(第4版).pdf"),StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("e:\\demo\\Java网络编程(copy).pdf"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

            inChannel.transferTo(0,inChannel.size(),outChannel);

            inChannel.close();
            outChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("耗费时间："+(System.currentTimeMillis() - start));
    }

    /**
     * 分散读取和聚集写入
     */
    public static void randomAccess(){
        try {
            RandomAccessFile fromFile = new RandomAccessFile("e:\\demo\\test.txt","rw");

            // 1. 获取通道
            FileChannel inChannel = fromFile.getChannel();

            //2、分配指定大小的缓冲区
            ByteBuffer buf1 = ByteBuffer.allocate(512);
            ByteBuffer buf2 = ByteBuffer.allocate(10240);

            //分散读取
            ByteBuffer[] bufs = {buf1,buf2};
            inChannel.read(bufs);

            for(ByteBuffer byteBuffer : bufs){
                byteBuffer.flip();
            }
            System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
            System.out.println("----------------");
            System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));

            //聚集写入
            RandomAccessFile toFrom = new RandomAccessFile("e:\\demo\\testCopy.txt","rw");
            FileChannel outChannel = toFrom.getChannel();

            outChannel.write(bufs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
