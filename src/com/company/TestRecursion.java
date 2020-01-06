package com.company;

import java.util.Scanner;

/**
 * 测试递归
 * 递归：即自己调用自己
 * 递归结构包括两部分：
 * 1.定义递归头 什么时候不调用自身方法，如果没有头将陷入死循环，也就是递归的结束条件
 * 2.递归体   什么时候需要调用自身方法
 *
 * @author centuryw
 */
public class TestRecursion {
    public static void main(String[] args) {
        //使用递归求n的阶乘
        long d1 = System.currentTimeMillis();     //返回当前时刻 毫秒数
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要阶乘的数:");
        int n = scanner.nextInt();
        System.out.printf("%d的阶乘结果为:%s\n", n, factorial(n));
        long d2 = System.currentTimeMillis();
        System.out.printf("递归耗时:%sms\n", (d2 - d1));
        //使用循环求n的阶乘
        long d3 = System.currentTimeMillis();
        System.out.println("循环结果:" + factorialLoop(n));
        long d4 = System.currentTimeMillis();
        System.out.printf("递归耗时:%sms\n", (d4 - d3));
    }

    //计算n的阶乘
    static long factorial(int n) {
        if (n == 1) {   //递归头
            return 1;
        } else {     //递归体
            return n * factorial(n - 1);
        }
    }

    //使用循环求n的阶乘
    static long factorialLoop(int n) {
        if (n == 1) {
            return 1;
        } else {
            int result = n;
            for (; n > 1; n--) {
                result *= (n - 1);
            }
            return result;
        }

    }

}
