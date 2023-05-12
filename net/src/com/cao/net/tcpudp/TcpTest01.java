package com.cao.net.tcpudp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 例1：客户端发送内容给服务器，服务器接收并将其打印到控制台
 */
public class TcpTest01 {

    //客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        OutputStreamWriter osw = null;
        try {
            InetAddress inet = InetAddress.getByName("192.168.5.77");//声明服务器端的ip地址
            int port = 111;//声明服务器端的端口号
            //创建一个Socket
            socket = new Socket(inet,port);
            //发送数据
            os = socket.getOutputStream();
            /*
                //发送的是字节数据，有可能乱码
                os.write("你好，我是客户端发送过来的数据。。。".getBytes(StandardCharsets.UTF_8));
                os.flush();
             */
            /*
                可以使用转换流发送数据
                osw = new OutputStreamWriter(os);
                osw.write("你好，我是客户端发送过来的数据。。。");
                osw.flush();//刷新缓冲区
             */
            os.write("你好，我是客户端发送过来的数据。。。".getBytes(StandardCharsets.UTF_8));
            os.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭流
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭socket
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }
    //服务器
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        InputStream is = null;
        InputStreamReader isr = null;
        int port = 111;//声明端口号
        //创建一个ServerSocket
        try {
            serverSocket = new ServerSocket(port);
            //调用accept(),接收客户端的Socket
            clientSocket = serverSocket.accept();//阻塞式的方法（一直等待客户端的连接请求）
            //接收数据
            is = clientSocket.getInputStream();
            /*
                错误的，可能会出现乱码，如果字节数组小的话
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = is.read(bytes)) != -1){
                    System.out.print(new String(bytes,0,len));
                }
             */
            byte[] bytes = new byte[5];
            int len = 0;
            //内部维护了一个byte数组
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len = is.read(bytes)) != -1){
                baos.write(bytes,0,len);//实际上就是复制到了内存中
            }
            System.out.println(baos.toString());
            System.out.println("接收到了来自于"+clientSocket.getInetAddress().getHostAddress()+"连接");
            /*
                可以使用转换流解决乱码问题
                isr = new InputStreamReader(is);
                char[] chars = new char[5];
                int len = 0;
                while ((len = isr.read(chars)) != -1){
                    System.out.print(new String(chars,0,len));
                }
             */
            System.out.println("数据传输完成");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭socket
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
