package com.cao.reflection;

import java.lang.reflect.Parameter;

//获取类加载器
public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException {
        //    获取系统类加载器
        ClassLoader SystemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(SystemClassLoader);
        //获取系统类加载器的父类，扩展类加载器
        ClassLoader parent = SystemClassLoader.getParent();
        System.out.println(parent);
        //获取扩展类加载器的父类，根加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是哪个加载器加载的——系统加载器
        ClassLoader classLoader = Class.forName("com.cao.reflection.Test04").getClassLoader();
        System.out.println(classLoader);

        //测试内置内置类是哪个加载器加载的——根加载器
        ClassLoader object = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(object);

        //获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
    }


}
