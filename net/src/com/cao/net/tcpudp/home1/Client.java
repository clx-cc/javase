package com.cao.net.tcpudp.home1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader sc = new BufferedReader(isr);
        String str = sc.readLine();
        bw.write(str);
        bw.flush();
        socket.shutdownOutput();
        String res = null;
        while ((res = br.readLine()) != null){
            System.out.println(res);
        }
        bw.close();
        br.close();
        socket.close();
    }
}
