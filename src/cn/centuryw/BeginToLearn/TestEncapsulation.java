package cn.centuryw.BeginToLearn;

/**
 * 封装的实现-使用访问控制符
 * 1.private表示私有，只有自己类能访问
 * 2.default表示没有修饰符修饰，只有同一个包的类能访问
 * 3.protected表示可以被同一个包的类以及其他包中的子类访问
 * 4.public表示可以被该项目的所有包中的所有类访问
 *
 * @author centuryw
 */
public class TestEncapsulation {
    public static void main(String[] args) {
        Human h = new Human();
        // h.age = 13; 使用private修饰后不可在此调用
        h.sayAge();
        Girl g = new Girl();
        g.setAge(14);
        g.sayAge();
        g.setName("小米");
        System.out.println(g.getName());
    }
}

class Human {
    private int age;
    String name;

    void sayAge() {
        System.out.println("我的年龄是:" + age);
    }
}

class Girl {
    private String name;    //一般都设置为私有属性，然后通过方法修改属性值
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 00 && age < 130) {
            this.age = age;
        } else {
            System.out.println("请输入正常的年龄！");
        }

    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    void sayAge() {
        System.out.println("我的年龄是:" + age);
    }

}