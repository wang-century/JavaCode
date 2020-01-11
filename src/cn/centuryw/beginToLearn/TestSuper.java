package cn.centuryw.beginToLearn;

/**
 * 测试super的使用
 * super是直接父类对象的引用，可以通过super来访问父类中被子类覆盖的方法或属性
 *
 * @author centuryw
 */
public class TestSuper {
    public static void main(String[] args) {
        new ChildClass().f();
    }
}

class FatherClass {
    public int value;

    public void f() {
        value = 100;
        System.out.println("FatherClass.value=" + value);
    }
}

class ChildClass extends FatherClass {
    public int value;

    public void f() {
        super.f();  //调用父类对象的方法
        value = 200;
        System.out.println("ChildClass.value=" + value);
        System.out.println(super.value);    //输出父类成员变量
    }
}