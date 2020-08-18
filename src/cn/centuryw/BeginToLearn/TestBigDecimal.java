package cn.centuryw.BeginToLearn;

import java.math.BigDecimal;

public class TestBigDecimal {
    /**
     * 目标:BigDecimal大数据类。
     * 引入:
     * 浮点型运算的时候直接+/可能会出现数据失真（精度问题）。
     * BigDecimal可以解决浮点型运算数据失真的问题。
     * BigDicimal类:
     * 包:java.math.
     * 创建对象的方式：
     *      public static BigDecimal valueOf(double val);   // 包装浮点型数据
     * 方法声明
     * public BigDecimal add (BigDecimal value)     加法运算
     * public BigDecimal subtract(BigDecimal value) 减法运算
     * public BigDecimal multiply(BigDecimal value) 乘法运算
     * public BigDecimal divide (BigDecimal value)  除法运算
     */

    public static void main(String[] args) {
        // 原运算与使用BigDecimal运算比较
        System.out.println(0.1+0.2);    // 0.30000000000000004
        System.out.println(0.09+0.01);  // 0.09999999999999999
        System.out.println(1.0-0.32);   // 0.6799999999999999
        System.out.println(1.015*100);  // 101.49999999999999
        System.out.println(1.301/100);  // 0.013009999999999999

        double a = 0.1;
        double b = 0.2;
        double c = a+b;
        System.out.println(c);  // 0.30000000000000004

        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);
        BigDecimal c1 = a1.add(b1);
        System.out.println(c1); // 0.3
        // 将BigDecimal转回double
        double res = c1.doubleValue();
        System.out.println(res);




    }
}
