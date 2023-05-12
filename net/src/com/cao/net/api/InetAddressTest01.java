package com.cao.net.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress的使用
 */
public class InetAddressTest01 {
    public static void main(String[] args) {
        //实例化
        //getByName(String host)
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.23.31");
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
            //getLocalHost：获取本地的IP地址
            InetAddress inet3 = InetAddress.getLocalHost();
            System.out.println(inet3);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
