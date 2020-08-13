package com.zjx.redis;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhaojiaxing
 * @date 2020-03-27 21:06
 */
public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8888);
        //代码阻塞（等待客户端连接）
        Socket socket = serverSocket.accept();

        //把消息读到byte数组里面
        InputStream reader = socket.getInputStream();
        byte[] request = new byte[1024];
        reader.read(request);

        //转化为String输出
        String req = new String(request);
        System.out.println(req);

        //关闭
        serverSocket.close();
    }
}
