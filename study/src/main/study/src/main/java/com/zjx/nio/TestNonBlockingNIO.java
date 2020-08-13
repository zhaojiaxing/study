package com.zjx.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zhaojiaxing
 * @date 2020-02-04 21:07
 */
public class TestNonBlockingNIO {

    public static void main(String[] args) throws Exception{
        client();
    }

    /**
     * 客户端
     * @throws Exception
     */
    public static void client() throws Exception{
        // 1.获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));

        //2. 切换非阻塞模式
        socketChannel.configureBlocking(false);

        //3. 分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //4. 发送数据给服务端
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.next();
            buffer.put((new Date().toString() + "\n" + str).getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        //5. 关闭通道
        socketChannel.close();

    }
}

class NonBlockingNIOServer{
    public static void main(String[] args) throws Exception{
        server();
    }

    /**
     * 服务端
     * @throws Exception
     */
    public static void server() throws Exception{
        //1. 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //2. 切换非阻塞模式
        serverSocketChannel.configureBlocking(false);

        //3. 绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));

        //4. 获取选择器
        Selector selector = Selector.open();

        //5.将通道注册到选择器，指定监听事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6.轮询式地获取选择器上准备就绪的事件
        while(selector.select() > 0){
            //7. 获取当前选择器中所有注册的“选择键”（已就绪的监听事件）
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //8.迭代获取
            Iterator<SelectionKey> it = selectionKeys.iterator();
            while (it.hasNext()){
                SelectionKey selectionKey = it.next();
                //9. 判断具体是什么事件就绪
                if(selectionKey.isAcceptable()){
                    //10. 若“接收就绪”，获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    //11. 切换非阻塞模式
                    socketChannel.configureBlocking(false);

                    //12. 将通道注册到选择器上
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    // 13.获取当前选择器上“读就绪”状态的通道
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();

                    //14. 读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    int len = 0;
                    while((len = socketChannel.read(buffer)) > 0){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
            }

            //15. 取消选择键 SelectionKey
            it.remove();
        }
    }
}
