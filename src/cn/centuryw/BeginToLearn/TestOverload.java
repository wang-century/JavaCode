package cn.centuryw.BeginToLearn;

/**
 * 测试方法重载
 *
 * @author centuryw
 */
public class TestOverload {
    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(add(1, 2, 3));
    }

    //方法名相同，参数 个数/类型/顺序 不同，构成重载
    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

}
