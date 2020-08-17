package cn.centuryw.BeginToLearn;

/**
 * 测试instanceof运算符的使用
 * instanceof是二元运算符，左边是对象，右边是类，当对象是右边类或子类所创建对象时，返回true，否则返回false
 *
 * @author centuryw
 */
public class TestInstanceof {
    public static void main(String[] args) {
        Programmer s = new Programmer("小红", 20, "Java");  //子类创建的对象
        System.out.println(s instanceof Programmer);    //子类
        System.out.println(s instanceof Person);    //继承的父类
        //结果都为true
    }
}
