package com.company;

/**
 * 测试嵌套循环
 *
 * @author centuryw
 */
public class TestNestedLoop {
    public static void main(String[] args) {
        /*
        输出
            1	1	1	1	1
            2	2	2	2	2
            3	3	3	3	3
            4	4	4	4	4
            5	5	5	5	5
         */
        for (int j = 1; j < 6; j++) {
            for (int i = 0; i < 5; i++) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
        //输出9*9乘法表
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
        //用while循环分别计算100以内的奇数及偶数和
        int jsum = 0;
        int osum = 0;
        int i = 1;
        while (i <= 100) {
            if (i % 2 == 0) {
                osum += i;
            } else {
                jsum += i;
            }
            i++;
        }
        System.out.println("奇数和:" + jsum + "\t偶数和:" + osum);

        //用while循环或其他循环输出1-1000之间能被5整除的数，并且每行输出5个
        int k = 0;
        for (int j = 1; j <= 1000; j++) {
            if (j % 5 == 0) {
                k += 1;
                System.out.print(j + "\t");
                if (k % 5 == 0) {
                    System.out.println();
                }
            }
        }
        //第二种方法
        for (int j = 1; j <= 1000; j++) {
            if (j % 5 == 0) {
                System.out.print(j + "\t");
            }
            if (j % 25 == 0) {
                System.out.println();
            }
        }


        //把100-150之间不能被3整除的数输出，并且每行输出5个
        int m = 0;
        for (int n = 100; n <= 150; n++) {
            if (n % 3 == 0) {
                continue;
            }
            System.out.print(n + "\t");
            m += 1;
            if (m % 5 == 0) {
                System.out.println();
            }
        }
    }
}

