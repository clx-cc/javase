package com.cao.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionAPITest01 {
    public static void main(String[] args) {
        //创建一个集合对象
//        Collection c = new Collection();//接口是抽象的，不能new对象
        //多态
        Collection c = new ArrayList();
        //测试常用方法
        c.add(1200);//自动装箱：实际上是放了一个对象的内存地址：Integer x = new Integer(1200);
        c.add(3.14);//自动装箱
        c.add(false);
        //获取集合中元素的个数
        System.out.println("集合中元素个数：" + c.size());
        //清空集合
        c.clear();
        System.out.println("集合中元素个数：" + c.size());
        //添加
        c.add("hello");//添加的是内存地址："hello"这个字符串的内存地址
        c.add("world");
        c.add("浩克");
        //删除某个元素
        c.remove("world");
        System.out.println(c);
        //判断是否为空
        System.out.println("集合是否为空：" + c.isEmpty());
        //清空
        c.clear();
        System.out.println("集合是否为空：" + c.isEmpty());

    }
}
