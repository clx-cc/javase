package com.cao.net.tcpudp.home02;

import java.io.File;

public class test {
    public static void main(String[] args) {
        File music = new File("net/src");
        File[] musics = music.listFiles();
        for (File file : musics) {

            if (file.isFile()){
                String name = file.getName();
                String[] split = name.split("//.");
                System.out.println(split.length);
                System.out.println(file.getName());

            }
        }

    }
}
