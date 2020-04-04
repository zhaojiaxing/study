package com.zjx.redis;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 通过socket遵循RESP协议手写Jedis
 * @author zhaojiaxing
 * @date 2020-03-27 22:00
 */
public class MyJedis {
    Socket socket;
    InputStream reader;
    OutputStream writer;

    public MyJedis() throws Exception{
        socket = new Socket("127.0.0.1",6379);
        reader = socket.getInputStream();
        writer = socket.getOutputStream();
    }

    /**
     * set方法，向redis写入数据(字符串)
     * set key value
     * @param k
     * @param v
     * @return
     * @throws Exception
     */
    public String set(String k,String v) throws Exception{
        StringBuffer command = new StringBuffer();
        //  * 数组 $字符串
        // set key value 三位数组
        command.append("*3").append("\r\n");
        //长度为3的字符串
        command.append("$3").append("\r\n");
        command.append("SET").append("\r\n");
        //长度为k.getBytes().length的字符串
        command.append("$").append(k.getBytes().length).append("\r\n");
        command.append(k).append("\r\n");
        //长度为v.getBytes().length的字符串
        command.append("$").append(v.getBytes().length).append("\r\n");
        command.append(v).append("\r\n");

        writer.write(command.toString().getBytes());

        byte[] response = new byte[1024];
        reader.read(response);

        return new String(response);
    }

    /**
     * get方法，向redis读取数据(字符串)
     * set key value
     * @param k
     * @return
     * @throws Exception
     */
    public String get(String k) throws Exception{
        StringBuffer command = new StringBuffer();
        // gey key  * 数组 $字符串
        command.append("*2").append("\r\n");
        command.append("$3").append("\r\n");
        command.append("GET").append("\r\n");
        command.append("$").append(k.getBytes().length).append("\r\n");
        command.append(k).append("\r\n");

        writer.write(command.toString().getBytes());

        byte[] response =new byte[1024];

        reader.read(response);

        return new String(response);

    }
}
