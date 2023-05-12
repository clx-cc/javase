package com.cao.net.tcpudp;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//实现Tcp通信
public class TcpDemo01 {

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
            //发送数据
            os = socket.getOutputStream();
            os.write("hello,world!".getBytes());
            os.flush();
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
            is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1){
                System.out.println(new String(bytes,0,len));
            }

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
