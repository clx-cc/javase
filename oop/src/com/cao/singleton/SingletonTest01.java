package com.cao.singleton;

/**
 * 单例模式的实现方法之一：饿汉式
 */
public class SingletonTest01 {
    public static void main(String[] args) {
        //通过静态方法获取该类的实例
        Bank instance1 = Bank.getInstance();
        Bank instance2 = Bank.getInstance();
        //不管获得次Bank类的实例，都是同一个对象
        System.out.println(instance1 == instance2);

    }
}
class Bank{
    //构造器私有化
    private Bank(){}
    //创建当前类的实例
    private static Bank instance = new Bank();

    //定义一个静态方法，可以在类的外部用类名获取该类的实例对象
    public static Bank getInstance() {
        //因为静态方法只能访问静态成员变量，所以instance也必须定义成静态的
        return instance;
    }

}
