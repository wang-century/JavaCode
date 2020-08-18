package cn.centuryw.BeginToLearn;

public class TestPackageClass {
    /**
     * 测试包装类
     */
    public static void main(String[] args) {
        // 将字符串数值转为Integer类型
        Integer num = Integer.parseInt("123");
        System.out.println(num);
        System.out.println(num.toString()); // 将数值转为字符串输出
    }

}
