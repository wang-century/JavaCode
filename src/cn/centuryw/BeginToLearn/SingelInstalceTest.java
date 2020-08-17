package cn.centuryw.BeginToLearn;

public class SingelInstalceTest {
    public static void main(String[] args) {
        SingleInstance1 singleInstance1_1 = SingleInstance1.getInstance();
        SingleInstance1 singleInstance1_2 = SingleInstance1.getInstance();
        System.out.println(singleInstance1_1 == singleInstance1_2);

        SingleInstance2 singleInstance2_1 = SingleInstance2.getInstance();
        SingleInstance2 singleInstance2_2 = SingleInstance2.getInstance();
        System.out.println(singleInstance2_1 == singleInstance2_2);
    }
}

class SingleInstance1 {
    /**
     * 饿汉单例设计模式
     */
    // 定义一个静态成员变量用于存储一个对象（饿汉单例在返回对象的时候，对象要已经做好）
    public static SingleInstance1 ins = new SingleInstance1();

    // 把类的构造器私有，构造器只能在本类中访问
    private SingleInstance1() {

    }

    // 提供方法返回单例对象
    public static SingleInstance1 getInstance() {
        return ins;
    }
}

class SingleInstance2 {
    /**
     * 懒汉单例设计模式
     */
    // 定义一个静态成员变量用于存储一个对象（懒汉单例不能直接创建对象，必须需要的时候才创建）
    public static SingleInstance2 ins;

    // 把类的构造器私有，构造器只能在本类中访问
    private SingleInstance2() {

    }

    // 提供方法返回单例对象，不存在对象才创建
    public static SingleInstance2 getInstance() {
        if (ins == null) {
            ins = new SingleInstance2();
        }
        return ins;
    }
}