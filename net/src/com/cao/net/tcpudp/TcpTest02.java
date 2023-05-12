package com.cao.net.tcpudp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 例2：客户端发送文件给服务器，服务器接收并将文件保存到本地
 */
public class TcpTest02 {

    //客户端
    @Test
    public void client() {
        OutputStream os = null;
        Socket socket = null;
        BufferedInputStream bis = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");//声明服务器ip地址
            int port = 111;//声明服务器端口号
            //创建Socket对象
            socket = new Socket(inet,port);
            //发送文件
            os = socket.getOutputStream();//获取输出流
            File file = new File("E:\\1.jpg");
            bis = new BufferedInputStream(new FileInputStream(file));
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1){
                os.write(bytes,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
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
    //服务端
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        File file = new File("E:\\2.jpg");
        try {
            //创建ServerSocket
            int port = 111;//声明端口号
            serverSocket = new ServerSocket(port);
            //接收客户端socket
            socket = serverSocket.accept();
            //接收数据
            is = socket.getInputStream();
            bos = new BufferedOutputStream(new FileOutputStream(file));
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = is.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
            bos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
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
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
