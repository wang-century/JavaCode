package cn.centuryw.beginToLearn;

/**
 * 抽象类与抽象方法
 *
 * 抽象类的使用要点：
 *      1.有抽象方法的类只能定义成抽象类
 *      2.抽象类不能实例化，即不能用new来实例化抽象类
 *      3.抽象类可以包含属性、方法、构造方法。但是构造方法不能用来new实例，只能用来被子类调用
 *      4.抽象类只能用来被继承
 *      5.抽象方法必须被子类实现
 */
abstract class TheAnimal{
    //没有实现  子类必须实现
    abstract public void shout();
    public void run(){
        System.out.println("跑！");
    }
}

class TheDog extends TheAnimal{
    @Override
    public void shout() {
        System.out.println("汪汪！");
    }
}

public class TestAbstract {
    public static void main(String[] args) {
        TheDog dog = new TheDog();
        dog.run();
        dog.shout();
    }

}
