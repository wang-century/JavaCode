package cn.centuryw.BeginToLearn;

/**
 * 测试This的使用
 * this的本质就是”创建好的对象的地址“，由于在构造方法调用前，对象已经创建，因此，在构造方法中也可以使用this代表”当前对象“
 *
 * @author centuryw
 */
public class TestThis {
    int a, b, c;

    TestThis() {
        System.out.println("正要初始化一个对象");
    }

    TestThis(int a, int b) {
        //TestThis();这样是无法调用方法的
        this(); //调用无参的构造方法，并且必须位于第一行
        //a = a;  //这里都是指的局部变量而不是成员变量
        //这样就区分了成员变量和局部变量，这种情况占了this使用情况大多数
        this.a = a;
        this.b = b;
    }

    TestThis(int a, int b, int c) {
        this(a, b);  //调用带参的构造方法，并且必须位于第一行
        this.c = c;
    }

    void sing() {
        System.out.print("正在喊话:");
    }

    void eat() {
        this.sing();
        System.out.println("你妈喊你回家吃饭");
    }

    public static void main(String[] args) {
        TestThis mod = new TestThis(1, 2);
        mod.eat();
    }

}
