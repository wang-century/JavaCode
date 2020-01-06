package com.company;

/**
 * 测试变量
 * @author centuryw
 */
public class TestVariable {
    int a;  //成员变量，成员变量会自动被初始化，从属于对象
    static int size;    //静态变量，从属于类
    public static void main(String[] args) {
        int age;    //局部变量，从属于方法
        age = 18;
        int salary = 3000;
        int gao = 13;
        System.out.println("工资:"+salary);
    }
}
