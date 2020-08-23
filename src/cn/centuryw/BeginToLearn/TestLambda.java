package cn.centuryw.BeginToLearn;

import cn.centuryw.BeginToLearn.ThreadCommunication.ThreadSave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda表达式的概述。
 * 什么是Lambda表达式?
 *      Lambda表达式是JDK1.8开始之后的新技术，是一种代码的新语法,是一种特殊写法.
 * 作用:核心目的是为了简化胜名内部类的代码写法”。
 *
 * Lambda表达式的格式:
 *      (匿名内部类被重写方法的形参列表术）-> {
 *          被重写方法的方法体代码。
 *      }
 * ->就是一个新语法，没有实际含义，但是不能省略!
 *
 * Lambda表达式的使用前提;
 *      1）Lambda及达式并不能简化所有匿名内部类的写法。
 *      2）Lambda表达式只能简化接口中只有一个抽象方法的匿名内部类形式。
 *
 * Lambda表达式只能简化函数式接口的匿名内部类写法:
 *   必须是接口
 *   接口中只能有一个抽象方法
 *
 * 小结:
 * Lambda表达式只能简化接口中只有一个抽象方法的匿名内部类写法。
 * 接口中只有一个抽象方法的接口称为函数式接口。
 * Lambda只能简化函数式接口的匿名内部类写法。
 *
 * Lambda表达式的省略写法:
 * (1）如果Lambda表达式的方法体代码只有一行代码。可以省略大括号不写,同时要省略分号!
 * (2）如果Lambda表达式的方法体代码只有一行代码。可以省略大括号不写。
 *      此时，如果这行代码是return语句，必须省略return不写，同时也必须省略";"不写
 * (3）参数类型可以省略不写。
 * (4）如果只有一个参数，参数类型可以省略，同时()也可以省略。
 *
 *
 *
 */
public class TestLambda {
    public static void main(String[] args) {
        // 匿名内部类
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行...");
            }
        });
        t1.start();
        // lambda
        Thread t2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"执行...");
        });
        t2.start();
        // 继续简化
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"执行...");
        }).start();
        // 再次简化
        new Thread(()-> System.out.println(Thread.currentThread().getName()+"执行...")).start();


        // lambda简化Comparator接口匿名内部类写法
        List<Student>list = new ArrayList<>();
        Student s1 = new Student(20,"张三");
        Student s2 = new Student(19,"里斯");
        Student s3 = new Student(21,"网无");
        Collections.addAll(list,s1,s2,s3);
        // 按照年龄进行升序排序
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getAge() - s2.getAge();
            }
        });
        System.out.println(list);
        // lambda简化 按照年龄进行降序排序
        list.sort((o1,o2)->{
            return o2.getAge() - o1.getAge();
        });
        System.out.println(list);
        // 进一步简化
        list.sort((b1,b2)->b1.getAge()-b2.getAge());
        System.out.println(list);


    }

    static class Student{
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return ""+this.name+":"+this.age;
        }

    }

}
