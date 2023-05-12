package com.cao.singleton;

import java.awt.*;

/**
 * 单例模式实现方式之二：懒汉式
 */
public class SingletonTest02 {
    public static void main(String[] args) {
        //通过静态方法得到该类的实例
        GirlFriend instance = GirlFriend.getInstance();
    }
}
class GirlFriend{
    //构造器私有化
    private GirlFriend(){}
    //声明当前类的实例
    private static GirlFriend instance = null;

    //通过静态方法获取类的实例：
    public static GirlFriend getInstance(){
        //如果未创建对象，在方法内部进行创建
        if (instance == null){
            instance = new GirlFriend();
        }
        //如果已经创建，直接返回该对象
        return instance;
    }
}
