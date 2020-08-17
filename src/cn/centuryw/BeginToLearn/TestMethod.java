package cn.centuryw.BeginToLearn;

/**
 * 测试方法的基本使用
 * @author centuryw
 */
public class TestMethod {
    public static void main(String[] args) {
        //通过对象调用普通方法
        TestMethod tm = new TestMethod();
        tm.printText();
        tm.printText();
        int c = tm.add(1,2,3)+200;
        System.out.println(c);
    }
    void printText(){
        System.out.println("打印文字");
    }

    int add(int a,int b,int c){
        int sum = a+b+c;
        return sum;     //return的两个作用：1.结束方法的运行 2.返回值
    }
}
