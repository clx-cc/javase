package com.cao.io;

import com.cao.util.logUtil;
import org.junit.Test;

import java.io.*;


public class OtherStreamTest {

    //测试标准输入流
    @Test
    public void test01() throws IOException {
        //我们从键盘上输入的全是字符，而inputStream是字节输入流，所以将其转换为字符输入流
        //所标准输入流包这个字节流包装成字符流，再包装成缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        System.out.println("请输入数据：");
        while ((s = br.readLine()) != null){
            if (s.equals("e") || s.equals("exit")){
                System.out.println("安全退出");
                break;
            }
            System.out.println(s.toUpperCase());
        }

    }
    @Test
    public void test02() throws FileNotFoundException {
        //标准输出流不再指向控制台，而是指向log.txt文件
        PrintStream ps = new PrintStream("E:\\clx\\java\\IOTest\\log.txt");
        //改变输出位置，将数据输出到log文件中
        System.setOut(ps);
        //输出：发现数据输出到文件中
        System.out.println("hello world!");
    }
    @Test
    public void test03() throws FileNotFoundException {
        //标准输出流不再指向控制台，而是指向log.txt文件
        PrintStream ps = new PrintStream("E:\\clx\\java\\IOTest\\log.txt");
        //使用打印流输出
        ps.println("hello world");
    }
    //测试自定义的日志工具类
    @Test
    public void test04(){
        logUtil.log("测试一下");
    }
}
