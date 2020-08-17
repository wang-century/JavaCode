package cn.centuryw.BeginToLearn;

/**
 * 测试内部类(静态内部类和非静态内部类、匿名内部类、方法内部类)
 *
 * 注：
 *  匿名内部类适合那种只需要使用一次的类，如键盘监听操作等.
 *
 * 匿名内部类语法：
 * new 父类构造器(实参类表) \ 实现接口(){
 *     //匿名内部类类体
 * }
 */
public class TestInnerClass {
    public static void main(String[] args) {
        //创建内部类对象
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
        //创建静态内部类对象
        Outer.Inner2 inner2 = new Outer.Inner2();
        //使用匿名内部类
        TestAnonymousInnerClass.tests01(new AA(){
            @Override
            public void aa() {
                System.out.println("测试匿名内部类");
            }
        });

    }
}



class Outer{
    private int age = 10;
    /* 内部类 */
    class Inner{
        int age = 20;
        public void show(){
            int age=30;
            System.out.println("外部类成员变量age:"+Outer.this.age);
            System.out.println("内部类成员变量age:"+this.age);
            System.out.println("局部变量age:"+age);
        }

    }
    /* 静态内部类 */
    static class Inner2{
    }
}

/* 测试匿名内部类 */
interface AA{
    void aa();
}

class TestAnonymousInnerClass{
    public static void tests01(AA a){
        a.aa();
    }
}

