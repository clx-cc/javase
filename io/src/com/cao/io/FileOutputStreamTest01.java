package com.cao.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//文件字节输出流
public class FileOutputStreamTest01 {
    public static void main(String[] args) {
        File file = new File("E:\\clx\\java\\IOTest\\fileoutputstream.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file, false);
            fos.write(1);
            fos.write(2);
            fos.write(3);
            fos.write(4);
            fos.flush();//刷新缓冲区
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
