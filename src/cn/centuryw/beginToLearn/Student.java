package cn.centuryw.beginToLearn;

/**
 * 测试类的基本使用
 *  创建一个对象分为四步
 *      1.分配对象公积金按，并将对象成员变量初始化为0或空
 *      2.执行属性值的显式初始化
 *      3.执行构造方法
 *      4.返回对象的地址给相关的变量
 * @author centuryw
 */
//类
public class Student {
    //属性
    int id;
    String name;
    int age;
    Computer comp;  //计算机

    //方法
    void study() {
        System.out.println("正在学习！使用" + comp.brand + "电脑");
    }

    //构造方法，用于创建这个类的对象，无参的构造方法可以由系统自动创建
    Student() {
    }

    //程序执行入口
    public static void main(String[] args) {
        Student stu = new Student();    //创建一个对象
        stu.id = 1;
        stu.name = "世纪";
        stu.age = 20;
        Computer c1 = new Computer();
        c1.brand = "惠普";
        stu.comp = c1;
        stu.study();
    }
}
//一个.java文件可以创建多个类，但只能有一个public类
class Computer {
    String brand;
}