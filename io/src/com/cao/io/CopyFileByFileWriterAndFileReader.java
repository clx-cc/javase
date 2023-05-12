package com.cao.io;

import java.io.*;

//使用文件字符流复制文件
public class CopyFileByFileWriterAndFileReader {
    public static void main(String[] args) {
        //创建File对象：指明读入的文件和写出的文件路径
        File fileRead = new File("E:\\clx\\java\\IOTest\\copy.txt");
        File fileWrite = new File("E:\\clx\\java\\IOTest\\copyresult.txt");
        //创建FileReader和FileWriter流对象，读取和写入数据
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(fileRead);
            fw = new FileWriter(fileWrite);
            //读取和写出的操作
            char[] ubuf = new char[5];
            int len;
            while ((len = fr.read(ubuf)) != -1){
                fw.write(ubuf,0,len);
                fw.flush();
            }
            System.out.println("copy OK!");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //流的关闭
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
