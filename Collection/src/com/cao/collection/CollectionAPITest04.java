package com.cao.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 关于迭代器对象的remove方法：
 *
 */
public class CollectionAPITest04 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("abc");
        c.add("def");
        c.add("xyz");
        Iterator it = c.iterator();
        while (it.hasNext()){
            Object o = it.next();
//            c.remove(o);//不能使用Collection对象的remove方法删除元素，因为集合的结构发生了改变，需要重新获取迭代器对象
//            it = c.iterator();
            //使用迭代器对象的remove方法删除元素
            it.remove();
            System.out.println(o);
        }
        System.out.println(c.size());
    }
}
