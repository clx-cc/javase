package com.cao.io;

import java.io.*;

//使用字节缓冲流处理进行非文本文件的复制
public class CopyByBufferedStreamTest01 {
    public static void main(String[] args) {
        //创建File对象：指明读入的文件和写出的文件路径
        File fileRead = new File("C:\\Users\\26390\\Pictures\\Camera Roll\\1.jpg");
        File fileWrite = new File("C:\\Users\\26390\\Pictures\\Camera Roll\\3.jpg");
        //实例化缓冲流对象：缓冲流是套在文件流之上的
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(fileRead));
            bos = new BufferedOutputStream(new FileOutputStream(fileWrite));
            //使用字节缓冲流进行输入和输出操作
            int len;
            byte[] bytes =  new byte[1024];
            while ((len = bis.read(bytes)) != -1){
                bos.write(bytes,0,len);
                bos.flush();
            }
            System.out.println("copy OK!");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流
            if (bis != null) {
                try {
                    bis.close();
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
        }
    }
}
