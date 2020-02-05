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
 * @date 2020-02-04 17:59
 */
public class TestBlockingNIO2 {
    public static void main(String[] args) throws Exception {
        client();
    }

    public static void client() throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        FileChannel inChannel = FileChannel.open(Paths.get("e:\\demo\\study.txt"), StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        //阻断
        socketChannel.shutdownOutput();

        //接收服务端的反馈
        int len = 0;
        while ((len = socketChannel.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();
        }

        inChannel.close();
        socketChannel.close();
    }


}

class Server2{
    public static void main(String[] args) throws Exception{
        server();
    }
    public static void server() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        FileChannel outChannel = FileChannel.open(Paths.get("e:\\demo\\copy\\2.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        serverSocketChannel.bind(new InetSocketAddress(9898));

        SocketChannel socketChannel = serverSocketChannel.accept();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (socketChannel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        //发送反馈给客户端
        buffer.put("服务端接收客户端数据成功".getBytes());
        buffer.flip();
        socketChannel.write(buffer);

        socketChannel.close();
        outChannel.close();
        serverSocketChannel.close();
    }
}
