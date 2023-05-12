package com.cao.net.tcpudp.home1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        String res = null;
        String answer = "";
        while ((res = br.readLine()) != null){
            System.out.println(res);
            if ("name".equals(res)){
                answer = "我是ccc";

            }else if ("hobby".equals(res)){
                answer = "编写java程序";
            }else{
                answer = "你在说什么？";
            }
            bw.write(answer);
            bw.newLine();
            bw.flush();
        }
        br.close();
        bw.close();
        accept.close();
    }
}
