package com.zjx.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author zhaojiaxing
 * @date 2020-02-04 22:15
 */
public class TestNonBlockingNIO2 {
    public static void main(String[] args) throws Exception{
         send();
    }

    public static void send() throws IOException{
        DatagramChannel dc = DatagramChannel.open();

        dc.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String str = scanner.next();
            buffer.put(str.getBytes());
            buffer.flip();
            dc.send(buffer,new InetSocketAddress("127.0.0.1",9898));
            buffer.clear();
        }
        dc.close();
    }

}

class TestServer{

    public static void main(String[] args) throws Exception{
        receive();
    }

    public static void receive() throws IOException{
        DatagramChannel dc = DatagramChannel.open();

        dc.configureBlocking(false);

        dc.bind(new InetSocketAddress(9898));

        Selector selector = Selector.open();

        dc.register(selector, SelectionKey.OP_READ);

        while(selector.select() > 0){
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

            while (it.hasNext()){
                SelectionKey selectionKey = it.next();

                if(selectionKey.isReadable()){
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    dc.receive(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(),0,buffer.limit()));
                    buffer.clear();
                }
            }
            it.remove();
        }
    }
}
