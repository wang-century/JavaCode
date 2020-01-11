package cn.centuryw.beginToLearn;

/**
 * 测试继承  使用extends实现继承
 * @author centuryw
 */
public class TestExtends {
    public static void main(String[] args) {
        Programmer w = new Programmer("小龙",20,"Java");
        w.rest();
        w.study();
    }
}

class Person{
    String name;
    int age;
    public void rest(){
        System.out.println("休息一会");
    }
}

class Programmer extends Person{    //Programmer类继承Person类
    String major;
    public void study(){
        System.out.println("正在学习");
    }
    public Programmer(String name,int age,String major){
        this.name = name;
        this.age = age;
        this.major = major;
    }
}
