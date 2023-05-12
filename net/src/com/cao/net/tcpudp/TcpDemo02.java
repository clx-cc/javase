package com.cao.net.tcpudp;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//实现Tcp通信
public class TcpDemo02 {

    //客户端
    @Test
    public void client(){
        InetAddress serverIp = null;
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        int port = 9999;

        try {
            serverIp = InetAddress.getLocalHost();
            //指定服务器端的IP地址和端口号
            socket = new Socket(serverIp,port);
            //发送数据到服务器
            os = socket.getOutputStream();
            os.write("hello,server!".getBytes());
            //表示数据发送完毕
            socket.shutdownOutput();
            //接收服务器发送回来的数据
            is = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            System.out.println("服务器端发送回来的数据如下:");
            while ((len = is.read(buf)) != -1){
                System.out.println(new String(buf,0,len));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    //服务器端
    @Test
    public void Server(){
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        int port = 9999;
        ServerSocket serverSocket = null;
        try {
            //指定服务器端的端口号
            serverSocket = new ServerSocket(port);
            //接收请求
            socket = serverSocket.accept();
            //接收数据通道中的数据
            is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1){
                System.out.println(new String(bytes,0,len));
            }
            //发送数据给客户端
            os = socket.getOutputStream();
            os.write("hello,client".getBytes());
            //表示数据发送完毕
            socket.shutdownOutput();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
