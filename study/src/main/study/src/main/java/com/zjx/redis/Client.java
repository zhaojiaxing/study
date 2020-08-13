package com.zjx.redis;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @author zhaojiaxing
 * @date 2020-03-27 21:13
 */
public class Client {
    public static void main(String[] args) throws Exception{
        //连接上server
        Socket socket = new Socket("127.0.0.1",8888);
        //获得输出流
        OutputStream writer = socket.getOutputStream();

        //发送消息到服务端
        writer.write("hello I`m zjx".getBytes());
        socket.close();
    }
}
