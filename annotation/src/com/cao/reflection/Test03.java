package com.cao.reflection;


//类的初始化
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("main类被加载");
//        Class.forName("com.cao.reflection.Son");
        int m = Son.M;



    }
}

class Father{
    static int b = 1;
    static {
        System.out.println("父类的静态代码被加载");
    }

}
class Son extends Father{
    static {
        System.out.println("子类的静态代码被加载");
    }
    static int m = 10;
    static final int M = 1;
}
