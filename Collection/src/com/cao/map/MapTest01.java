package com.cao.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest01 {
    public static void main(String[] args) {

        //
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"zhangsan");
        map.put(2,"lisi");
        map.put(3,"wangwu");
        map.put(4,"zhaosi");
        //Map集合的遍历方式
        //一：通过key获取value
        //获取所有的key
        Set<Integer> keys = map.keySet();
        //通过key获取value:增强for
        for (Integer key : keys) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
        //通过key获取value：迭代器
        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()){
            Integer key = it.next();
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
        //方式二：Set<Map.Entry<K,V>> entrySet()，将Map集合转换成Set集合
            //Set集合中的元素类型是Map.Entry<K,V>
        //遍历set集合，每次取出一个Map.Entry类型的数据(node)，再从这个数据中取出key和value
        //foreach
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        for (Map.Entry<Integer, String> node : set) {
            System.out.println(node.getKey() + "=" + node.getValue());
        }
        //迭代器
        Iterator<Map.Entry<Integer, String>> its = set.iterator();
        while (its.hasNext()) {
            Map.Entry<Integer, String> node = its.next();
            Integer key = node.getKey();
            String value = node.getValue();
            System.out.println(key + "=" + value);
        }

    }
}
