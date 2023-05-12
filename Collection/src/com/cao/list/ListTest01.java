package com.cao.list;

import java.util.*;

public class ListTest01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        //通过迭代器遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //通过下标遍历（List集合特有的遍历方式，Set集合没有)
        for (int i = 0; i < list.size(); i++) {
            Object elt = list.get(i);
            System.out.println(elt);
        }



    }
}
