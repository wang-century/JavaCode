package cn.centuryw.BeginToLearn;

/**
 * 目标:递归的形式
 * 递归:方法在方法中又调用了自己。
 * 递归:
 *      直接递归:自己的方法调用自己。
 *      间接递归:自己的方法调用别的方法，别的方法又调用自己。
 * 小结:
 *      递归是自己调用自己。
 *      递归如果控制的不恰当，会形成递归的死循环，从而导致栈内存溢出错误!!
 *      递归应该防止进入递归的死循环!
 *
 * 递归的三要素（理论）:
 *      1.递归的终结点:f(1)=1
 *      2.递归的公式:f(x)= f(x-1)+1
 *      3.递归的方向:必须走向终结点
 *
 *
 * 递归的核心思想-公式转换
 *      已知:f(x)= f(x+1)+2
 *          f(1)= 1
 *      求:f(10)= ?
 *
 *
 * 猴子吃桃:
 * 猴子第一天摘了若干个桃子，当即吃了一半，觉得好不过瘾，然后又多吃了一个。
 * 第二天又吃了前一天剩下的一半，觉得好不过瘾，然后又多吃了一个。
 * 以后每天都是如此
 * 等到第十天再吃的时候发现只有1个桃子，请问猴子第一天总共摘了多少个桃子。
 * 递归的三要素:
 * (1）公式:
 * (2）终结点:
 * (3）递归的方向:
 *
 *
 * 目标:1-n的和。
 * f(n)= l +2+3 +4 +5 + ....n-l + n
 * f(n) = f(n-l) +rI
 *      流程:
 * f(5)= f(4)+5= l + 2 + 3 +4 + 5
 * f(4)= f(3)+4= 1 +2 +3 +4
 * f(3) = f(2)+ 3= 1+2＋3
 * f(2） = f(1)+2=1 +2
 * f(1）= 1
 * 递归的核心三要素:
 * (1）递归的终点接:f(1)= 1
 * (2）递归的公式:f(n) = f(n-1)+n
 * (3）递归的方向必须走向终结点:
 *
 *
 * 计算n的阶乘
 *
 * 非规律化递归:啤酒问题:（作业）
 * 啤酒2元1瓶，4个盖子可以换一瓶，2个空瓶可以换一瓶
 * ，问10元可以喝多少瓶，剩余多少盖子和瓶子!!15 3 1
 */
public class RecursionDemo {
    public static void main(String[] args) {
        // f(x) = f(x-1)+1
        System.out.println(demo1(10));
        // f(x)= f(x+1)+2
        System.out.println(demo2(10));
        // 猴子吃桃
        System.out.println(demo3(1));
        // 1-n的累加和
        System.out.println(demo4(10));
        // n的阶乘
        System.out.println(demo5(10));
    }

    /**
     * 已知:  f(x) = f(x-1)+1
     *       f(1) = 1
     * 求:   f(10) = ?
     * @param value 值
     * @return 计算结果
     */
    static int demo1(int value){
        if (value == 1){
            return 1;
        }else {
            return demo1(value-1)+1;
        }
    }

    /**
     * 已知:f(x)= f(x+1)+2
     *     f(1)= 1
     * 求:f(10)= ?
     * 解:
     *      设:f(x) = f(x-1)
     *      则:原式为f(x-1)=f(x-1+1)+2
     *             f(x-1) = f(x)+2
     *             f(x) = f(x-1)-2
     * @param value 值
     * @return 计算结果
     */
    static int demo2(int value){
        if (value==1){
            return 1;
        }else {
            return demo2(value-1)-2;
        }
    }

    /**
     * 猴子吃桃:
     * 猴子第一天摘了若干个桃子，当即吃了一半，觉得好不过瘾，然后又多吃了一个。
     * 第二天又吃了前一天剩下的一半，觉得好不过瘾，然后又多吃了一个。
     * 以后每天都是如此
     * 等到第十天再吃的时候发现只有1个桃子，请问猴子第一天总共摘了多少个桃子。
     * 递归的三要素:
     * (1）公式:f(x) = 2f(x+1)+2
     * (2）终结点:f(10) = 1
     * (3）递归的方向:
     */
    static int demo3(int value){
        if (value==10){
            return 1;
        }else {
            return 2*(demo3(value+1)+1);
        }
    }

    /**
     * 计算1-n的和
     * @param n 要计算的值
     * @return 计算结果
     */
    static int demo4(int n){
        if (n==1){
            return 1;
        }else {
            return demo4(n-1)+n;
        }
    }

    /**
     * 计算n的阶乘
     * @param n 要计算的值
     * @return 计算结果
     */
    static int demo5(int n){
        if (n==1){
            return 1;
        }else {
            return demo5(n-1)*n;
        }
    }

}
