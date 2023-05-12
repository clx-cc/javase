package com.cao.io;

import java.io.*;

//使用FileInputStream和FileOutputStream实现对非文本文件的复制（图片、视频等等）
public class CopyFileByFileInputStreamAndFileOutputStream {
    public static void main(String[] args) {
        //创建File对象：指明读入的文件和写出的文件路径
        File fileRead = new File("C:\\Users\\26390\\Pictures\\Camera Roll\\1.jpg");
        File fileWrite = new File("C:\\Users\\26390\\Pictures\\Camera Roll\\2.jpg");
        //创建FileInputStream和FileOutputStream对象进行输入和输出操作
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(fileRead);
            fos = new FileOutputStream(fileWrite);
            int len;
            byte[] ubuf = new byte[1024];
            while ((len = fis.read(ubuf)) != -1){
                fos.write(ubuf,0,len);
                fos.flush();
            }
            System.out.println("copy OK!");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //流的关闭
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
