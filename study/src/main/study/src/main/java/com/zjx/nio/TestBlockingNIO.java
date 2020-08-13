package com.zjx.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author zhaojiaxing
 * @date 2020-02-04 17:32
 */
public class TestBlockingNIO {

    public static void main(String[] args) throws Exception{
        client();
    }

    //客户端
    public static void client() throws Exception{
        System.out.println("client start");
        //1. 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
        FileChannel inChannel = FileChannel.open(Paths.get("e:\\demo\\study.txt"), StandardOpenOption.READ);

        //2.分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //3.读取本地文件，发送到服务器
        while (inChannel.read(buf) != -1){
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }

        //4. 关闭通道
        inChannel.close();
        socketChannel.close();
        System.out.println("client stop");
    }


}

class Server{
    public static void main(String[] args) throws Exception{
        server();
    }
    //服务端
    public static void server() throws Exception{
        System.out.println("server start");
        //1.获取通道
        ServerSocketChannel serverSocket = ServerSocketChannel.open();

        FileChannel outChannel = FileChannel.open(Paths.get("e:\\demo\\copy\\2.txt")
                ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //2. 绑定连接
        serverSocket.bind(new InetSocketAddress(9898));

        //3. 获取客户端的通道
        SocketChannel socketChannel = serverSocket.accept();

        //4. 分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //5.接收客户端的数据，并保存到本地
        while(socketChannel.read(buffer) != -1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        //6.关闭通道
        socketChannel.close();
        outChannel.close();
        serverSocket.close();

        System.out.println("server stop");
    }
}
