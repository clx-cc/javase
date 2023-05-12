package com.cao.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest02 {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            //1、File类的实例化
            File file = new File("E:\\clx\\java\\IOTest\\temp");
            //2、FileReader流的实例化
            fr = new FileReader(file);
            //3、读入的操作
            char[] ubuf = new char[5];//因为读入的是字符，所以使用char型数组来接，如果是字节，使用byte
            int len;
            while((len=fr.read(ubuf))!=-1){//每次会返回读入数组中字符的个数，如果读到末尾返回-1.
                /*
                   方法一：
                    for (int i = 0; i <len ; i++) {
                        System.out.print(ubuf[i]);
                    }
                 */
                //方式二：
                System.out.println(len);
                String str = new String(ubuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、流的关闭
            try {
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
