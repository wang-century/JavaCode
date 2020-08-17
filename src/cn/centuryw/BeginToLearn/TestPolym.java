package cn.centuryw.BeginToLearn;

/**
 * 多态
 * 多态的要点
 *      1.多态是方法的多态，不是属性的多态
 *      2.多态的存在有三个必要条件：继承、方法重写、父类引用指向子类对象
 *      3.父类引用指向子类对象后，用该父类引用调用子类重写的方法，此时多态就出现了
 */
public class TestPolym {
    public static void main(String[] args) {
        Animal a1 = new Cat();  //向上可以自动转型
        //传的具体是哪一个类就调用哪一个类的方法，大大提高了程序可扩展性
        animalShout(a1);
        Animal a2 = new Dog();
        animalShout(a2);    //a2为编译类型，Dog对象才是运行时的类型
        //编写程序时，如果想调用运行时类型的方法，只能进行强制类型转换，否则不能通过编译器检查
        Dog dog = (Dog)a2;  //向下需要强制类型转换
        dog.seeDoor();
    }
    static void animalShout(Animal a){
        a.shout();
    }
}
class Animal{
    public void shout(){
        System.out.println("交了一声");
    }
}

class Dog extends Animal{
    public void shout(){
        System.out.println("旺！");
    }
    public void seeDoor(){
        System.out.println("看门中...");
    }
}
class Cat extends Animal{
    public void shout(){
        System.out.println("喵！");
    }
}
