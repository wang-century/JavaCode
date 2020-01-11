package cn.centuryw.beginToLearn;

/**
 * 测试重写
 *      方法的重写需要符合下面的三个要点
 *          1.方法名、形参列表相同
 *          2.返回值类型和声明异常类型，子类小于等于父类
 *          3.访问权限，子类大于等于父类
 * @author centuryw
 */
public class TestOverride {
    public static void main(String[] args) {
        Horse h = new Horse();
        h.run();
        h.stop();
    }
}

class Vehicle{  //交通工具类
    public void run(){
        System.out.println("跑");
    }
    public void stop(){
        System.out.println("停止");
    }
    public Person whiIsPsg(){   //返回一个Person
        return new Person();
    }
}

class Horse extends Vehicle{    //交通工具 马
    public void run() {
        System.out.println("四蹄奔跑");
    }
    public Programmer whiIsPsg(){   //因为Programmer继承Peroson，所以允许返回
        return new Programmer();
    }

}



