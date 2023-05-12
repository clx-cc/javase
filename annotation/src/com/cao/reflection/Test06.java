package com.cao.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//执行效率
public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        test01();
        test02();
        test03();

    }
    public static void test01(){
        Person p = new Person();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <1000000000 ; i++) {
            p.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方式"+(endTime-startTime)+"ms");
    }
    public static void test02() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c1 = Class.forName("com.cao.reflection.Person");
        Person p = (Person)c1.newInstance();
        Method getName = c1.getDeclaredMethod("getName", null);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <1000000000 ; i++) {
            getName.invoke(p,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射"+(endTime-startTime)+"ms");
    }
    public static void test03() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c1 = Class.forName("com.cao.reflection.Person");
        Person p = (Person)c1.newInstance();
        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <1000000000 ; i++) {
            getName.invoke(p,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("关闭检查"+(endTime-startTime)+"ms");
    }
}
