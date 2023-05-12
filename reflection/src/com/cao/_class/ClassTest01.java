package com.cao._class;

import org.junit.Test;

/**
 * 获取Class实例的三种方法
 */
public class ClassTest01 {
    @Test
    public void test01() throws ClassNotFoundException {
        //调用运行时类的class属性
        Class clazz1 = User.class;

        //调用运行类对象的getClass()方法
        User user = new User();
        Class clazz2 = user.getClass();
        System.out.println(clazz2 == clazz1);//true
        //调用Class的静态方法forName(String 全类名)
        Class clazz3 = Class.forName("com.cao._class.User");
        System.out.println(clazz2 == clazz3);//true

        //通过类加载器获取Class实例(了解)
        Class clazz4 = ClassLoader.getSystemClassLoader().loadClass("com.cao._class.User");
        System.out.println(clazz4 == clazz3);//true
    }
    @Test
    public void test02(){

    }
}
