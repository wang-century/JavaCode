package cn.centuryw.BeginToLearn;

import java.util.Objects;

public class TestObjects {
    /**
     * Objects类的使用
     * 包含两个：
     *      equals()    比较两个对象，底层进行非空判断，可以避免空指针异常
     *      isNull      判断变量是否为null
     */

    public static void main(String[] args) {
        Student stu1 = new Student();   // 创建空对象
        Student stu2 = new Student();
        System.out.println(Objects.equals(stu1,stu2));
        System.out.println(Objects.isNull(stu1));
    }

    private static class Student{
        int age;
        String name;
    }


}
