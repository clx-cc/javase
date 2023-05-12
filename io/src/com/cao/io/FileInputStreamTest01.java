package com.cao.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    文件字节输入流：万能流，任何类型的文件都可以读取
        输入流，表示从硬盘到内存


 */
public class FileInputStreamTest01 {
    public static void main(String[] args) {
        //创建文件字节输入流对象
        FileInputStream fis = null;
        try {
            fis =  new FileInputStream("E:\\clx\\java\\IOTest\\temp");
            //开始读取文件
            int read;
            while ((read = fis.read()) != -1){
                System.out.println(read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
