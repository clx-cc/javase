package com.cao.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            //1、实例化File类的对象，指明要操作的文件
            File file = new File("E:\\clx\\java\\IOTest\\temp");
            //2、提供具体的流
            fr = new FileReader(file);//此文件一定要存在
            //3、数据的读入
            //  read():返回读入的一个字符。如果文件达到末尾返回-1
            int read = fr.read();
            while(read!=-1){
                System.out.print((char) read);
                read = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、流的关闭
            try {
                if(fr!=null)//防止空指针异常：如果还没有实例化时文件找不到就会出现异常，那么就会报空指针异常
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
