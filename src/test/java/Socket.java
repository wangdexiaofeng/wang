import org.junit.Test;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Socket {
    @Test
    public void client(){
        try {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8888));
            //读取文件
            FileChannel fileChannel = FileChannel.open(Paths.get("D:/1.jpg"), StandardOpenOption.READ);
            //创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(buffer)!=-1){
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
            }
            socketChannel.shutdownOutput();//避免读写僵持
            //客户端接收数据
            StringBuffer stringBuffer = new StringBuffer();
            int len=0;
            while ((len=socketChannel.read(buffer))!=-1){
                buffer.flip();
                stringBuffer.append(new String(buffer.array()),0,len);
                buffer.clear();

            }
            System.out.println(stringBuffer.toString());
            fileChannel.close();
            socketChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void service(){
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8888));
            SocketChannel socketChannel = serverSocketChannel.accept();
            FileChannel fileChannel = FileChannel.open(Paths.get("D:/2.jpg"),StandardOpenOption.CREATE,StandardOpenOption.WRITE);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (socketChannel.read(buffer)!=-1){
               buffer.flip();
               fileChannel.write(buffer);
               buffer.clear();
            }
            //往客户端回写字符串数据
            socketChannel.write(buffer.wrap("wangxiaofeng".getBytes()));
            fileChannel.close();
            socketChannel.close();
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
