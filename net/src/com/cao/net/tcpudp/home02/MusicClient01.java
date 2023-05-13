package com.cao.net.tcpudp.home02;

import jdk.nashorn.internal.ir.CallNode;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MusicClient01 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入您想下载的音乐名：");
        String fileName = sc.readLine();
        //向服务器发送数据
        bw.write(fileName);
        bw.flush();
        socket.shutdownOutput();
        //接收返回的歌曲,并下载到本地
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("net\\src\\" + fileName + "c.mp3")));
        int len = 0;
        byte[] buf = new byte[1024];
        while ((len = bis.read(buf)) != -1){
            bos.write(buf,0,len);
        }
        bos.flush();
        //关闭流
        bos.close();
        socket.close();
    }
}
