package com.cao.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Collection集合的contains方法
 *      底层采用的是equals方法比较的是内容
 */
public class CollectionAPITest03 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        //创建用户对象
        User user1 = new User("jack");
        //添加元素
        c.add(user1);
        //判断集合中是否包含user2
        User user2 = new User("jack");
        //没有重写equals之前，这个结果是false
        System.out.println(c.contains(user2));//false
        //重写equals方法之后，这个结果是true


    }
}
class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }


}
