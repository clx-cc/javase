package com.cao.comparable;

import com.cao.bean.Student;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ComparableTest01 {
    public static void main(String[] args) {
        Student zhangsan = new Student("zhangsan",33);
        Student lisi = new Student("lisi",99);

        int compareTo = zhangsan.compareTo(lisi);
        if (compareTo > 0){
            System.out.println("zhangsan年龄大");
        }else if (compareTo < 0){
            System.out.println("lisi年龄大");
        }else{
            System.out.println("年龄一样大");
        }

        //第二种比较器：
//        Set<Student> set = new TreeSet<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge() - o2.getAge();//自定义比较规则
//            }
//        });
//        set.add(zhangsan);
//        set.add(lisi);
//        for (Student student : set) {
//            System.out.println(student);
//        }

    }
}
