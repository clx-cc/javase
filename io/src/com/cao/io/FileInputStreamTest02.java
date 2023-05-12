package com.cao.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//文件字节输入流
public class FileInputStreamTest02 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("E:\\clx\\java\\IOTest\\temp"));
            byte[] ubuf = new byte[5];//每次读取5个字节
            int len;//返回的是读取字节的个数
            while ((len = fis.read(ubuf)) != -1){
                System.out.println(new String(ubuf,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null) {
                try {
                    fis.close();//关闭流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
