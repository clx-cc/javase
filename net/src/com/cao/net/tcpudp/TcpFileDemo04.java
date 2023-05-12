package com.cao.net.tcpudp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
    客户端发送图片给服务器
    服务器接收图片保存到当前目录并返回接收成功
 */
public class TcpFileDemo04 {

    //客户端
    @Test
    public void client() throws Exception{
        //指定服务器的IP和port
        InetAddress serverIP = InetAddress.getLocalHost();
        int port = 8888;
        //实例化Socket对象
        Socket socket = new Socket(serverIP, port);
        //获取输出流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("src/client.jpg")));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        int len = 0;
        byte[] buf = new byte[1024];
        //从当前目录读取图片
        while ((len = bis.read(buf)) != -1){
            //向服务器端发送图片
            bos.write(buf,0,len);
        }
        bos.flush();
        socket.shutdownOutput();
        //接收服务器端的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        char[] cbuf = new char[1024];
        while ((len = br.read(cbuf)) != -1){
            System.out.println(new String(cbuf,0,len));
        }
        //关闭连接
        socket.close();
        bis.close();


    }
    //服务端
    @Test
    public void server() throws Exception{
        //端口号
        int port = 8888;
        ServerSocket serverSocket = new ServerSocket(port);
        //接收连接请求
        Socket socket = serverSocket.accept();
        //获取输入流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("src/server.jpg")));
        int len = 0;
        byte[] buf = new byte[1024];
        while ((len = bis.read(buf)) != -1){
            bos.write(buf,0,len);
        }
        bos.flush();
        //向客户端发送接收成功
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到成功");
        bw.flush();
        socket.shutdownOutput();
        //关闭流
        socket.close();
        bos.close();

    }
}
