package com.cao.net.tcpudp.home02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 这是一个存放音乐的服务器：客户端发送音乐文件名给服务器，如果此音乐存在，则返回,否则，返回默认音乐。
 */
public class MusicServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("正在等待连接。。。");
        Socket socket = serverSocket.accept();
        //接收客户端的歌曲名
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        int len = 0;
        char[] cbuf = new char[1024];
        String downLoadFileName = "";
        while ((len = br.read(cbuf)) != -1){
            downLoadFileName += new String(cbuf,0,len);
        }
        System.out.println("客户端希望下载的歌曲是：" + downLoadFileName);
        //遍历歌曲目录，查看是否存在此歌曲
        File resFile = new File("net\\src\\无名.mp3");
        File musicFile = new File("net\\src\\");
        File[] musics = musicFile.listFiles();
        for (File music : musics) {
            if (music.isFile()) {
                String[] split = music.getName().split("\\.");

                if (downLoadFileName.equals(split[0])){
                    System.out.println("正确");
                    resFile = music;
                    break;
                }
            }
        }
        System.out.println(resFile);
        //将文件发送给客户端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFile));
        byte[] buf = new byte[1024];
        while ((len = bis.read(buf)) != -1){
            bos.write(buf,0,len);
        }
        bos.flush();
        socket.shutdownOutput();
        //关闭流
        bis.close();
        socket.close();



    }
}
