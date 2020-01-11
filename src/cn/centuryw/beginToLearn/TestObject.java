package cn.centuryw.beginToLearn;

/**
 * Object类的用法 重写toString方法
 *
 * @author centuryw
 */
public class TestObject {
    public static void main(String[] args) {
        Person1 p = new Person1();
        p.age = 20;
        p.name = "小龙";
        System.out.println("信息:" + p.toString());
    }
}

class Person1 {
    String name;
    int age;

    @Override
    public String toString() {
        return name + ",年龄:" + age;
    }
}
