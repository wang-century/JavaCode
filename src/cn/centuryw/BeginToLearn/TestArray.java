package cn.centuryw.BeginToLearn;

/**
 * 数组
 * 基本特点
 *      1.长度确定
 *      2.元素是相同类型
 *      3.数组类型可以是任何数据类型，包括基本类型和引用类型
 * 数组的初始化
 *      初始化方式有三种：静态初始化、动态初始化、默认初始化
 * 数组的遍历
 *      1.使用循环遍历初始化和读取数组
 *      2.使用foreach循环 读取数组元素的值，不能修改元素的值
 * @author centuryw
 */
public class TestArray {
    public static void main(String[] args) {
        /* 数组的声明：
            方法一：type[] arr_name;    推荐使用此方法
            方法二：type arr_name[];
           注意：
            1.声明时并没有实例化任何对象，只有在实例化数组对象时，JVM才分配空间，这时才与长度有关
            2.声明一个数组的时候并没有数组被真正创建
            3.构造一个数组必须指定长度
        */
        int[] s; //声明数组
        s = new int[10];    //给数组分配空间   下标从0开始 9结束
        for (int i = 0; i < 10; i++) {
            s[i] = 2 * i + 1;    //给数组元素赋值
            System.out.println(s[i]);
        }
        Girl[] girl_array = new Girl[3];
        girl_array[0] = new Girl();

        /*测试数组的三种初始化方法*/
        //静态初始化
        int[] a = {1, 2, 3};
        Girl[] g = {new Girl(), new Girl(), new Girl()};
        //默认初始化
        int[] a2 = new int[3];  //默认0
        boolean[] a3 = new boolean[3];  //默认false
        String[] a4 = new String[3];    //默认null
        //动态初始化
        int[] a5 = new int[3];
        a5[0] = 1;  //给数组元素赋值
        a5[1] = 2;

        //数组的遍历
        //使用循环遍历初始化和读取数组
        for (int i = 0; i < 10; i++) {
            s[i] = 2 * i + 1;    //给数组元素赋值
            System.out.println(s[i]);
        }
        //使用foreach循环 读取数组元素的值，不能修改元素的值
        String[] s2 = {"你好","我好","大家好"};
        for(String m:s2){
            System.out.println(m);
        }

    }
}

