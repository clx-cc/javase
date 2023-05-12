package com.cao.net.tcpudp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//实现Tcp通信
public class TcpDemo03 {

    //客户端
    @Test
    public void client(){
        InetAddress serverIp = null;
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        OutputStreamWriter osw = null;
        InputStreamReader isr = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        int port = 9999;

        try {
            serverIp = InetAddress.getLocalHost();
            //指定服务器端的IP地址和端口号
            socket = new Socket(serverIp,port);
            //发送数据到服务器
            os = socket.getOutputStream();
            //将字节输出流转化为字符输出流
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            bw.write("你好,服务器");
            bw.flush();
            //表示数据发送完毕
            socket.shutdownOutput();
            //接收服务器发送回来的数据
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            char[] cbuf = new char[1024];
            int len = 0;
            System.out.println("服务器端发送回来的数据如下:");
            while ((len = br.read(cbuf)) != -1){
                System.out.println(new String(cbuf,0,len));
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
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        int port = 9999;
        ServerSocket serverSocket = null;
        try {
            //指定服务器端的端口号
            serverSocket = new ServerSocket(port);
            //接收请求
            socket = serverSocket.accept();
            //获取字节输入流
            is = socket.getInputStream();
            //将字节输入流转化为字符输入流
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            char[] cbuf = new char[1024];
            int len = 0;
            while ((len = br.read(cbuf)) != -1){
                System.out.println(new String(cbuf,0,len));
            }
            //发送数据给客户端
            os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            bw.write("你好,客户端!");
            bw.flush();
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
