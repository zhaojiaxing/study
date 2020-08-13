package com.zjx.redis;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaojiaxing
 * @date 2020-03-29 20:54
 */
public class RedisProxy {
    private static List<String> servers = new ArrayList<>();
    static {
        servers.add("127.0.0.1:6379");
        servers.add("127.0.0.1:6380");
        servers.add("127.0.0.1:6381");
    }

    /**
     * 最简单的代理实现负载均衡
     * @param args
     */
    public static void main(String[] args) throws Exception{
        //监听端口
        ServerSocket serverSocket = new ServerSocket(19000);
        Socket socket;
        while((socket = serverSocket.accept()) != null){
            while(true){

                System.out.println("一个链接.....");
                InputStream inputStream = socket.getInputStream();
                byte[] request = new byte[1024];
                inputStream.read(request);
                //解析请求resp
                String req = new String(request);
                System.out.println("收到请求：");

                System.out.println(req);

                String[] params = req.split("\r\n");
                //获取key的长度
                int keyLength = Integer.parseInt(params[3].split("\\$")[1]);
                //根据key的长度取模
                int mod = keyLength % servers.size();
                //根据取模结果获取地址
                System.out.println("根据算法选择服务器："+servers.get(mod));
                String[] serverInfo = servers.get(mod).split(":");
                //处理请求
                Socket client = new Socket(serverInfo[0],Integer.parseInt(serverInfo[1]));
                client.getOutputStream().write(request);
            }
        }
    }
}
