package com.cao.collection;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection集合遍历/迭代
 */
public class CollectionAPITest02 {
    public static void main(String[] args) {
        Collection c  = new ArrayList();
        c.add("adb");
        c.add("world");
        c.add(12121);
        c.add(new Object());
        //第一步：获取集合的迭代器对象
        Iterator it = c.iterator();
        //第二步：通过迭代器对象遍历集合
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
