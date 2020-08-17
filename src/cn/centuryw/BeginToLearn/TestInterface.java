package cn.centuryw.BeginToLearn;

/**
 * 接口
 * 接口就是比抽象类还抽象的抽象类，可以更加规范的对子类进行约束，全面专业的实现了：规范和具体实现的分离。
 *
 * 注意：
 *      接口内只能定义常量
 */
public interface TestInterface {
    public static void main(String[] args) {
        Angel a = new Angel();
        a.fly();
        a.helpOthers();
    }
}

/**飞行接口*/
interface Volant{
    int FLY_HEIGHT = 100;   //默认public static final类型
    void fly(); //默认public abstract类型
}

/**善良接口*/
interface Honest{
    void helpOthers();
}


class Angel implements Volant,Honest{   //可以继承多个接口
    @Override
    public void fly() {
        System.out.println("飞行中");
    }

    @Override
    public void helpOthers() {
        System.out.println("扶老奶奶过马路");
    }
}

/**接口可以多继承*/
interface A{
    void testa();
}
interface B{
    void testb();
}
interface C extends A,B{
    void testc();
}
class D implements C{
    @Override
    public void testa() {
    }
    @Override
    public void testb() {
    }
    @Override
    public void testc() {
    }
}
