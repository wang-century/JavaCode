package cn.centuryw.BeginToLearn;

import java.text.SimpleDateFormat;
import java.util.Arrays;

public class TestSystem {
    /**
     * 目标:System系统类的使用。
     * system代表当前系统。
     * 静态方法:
     *      1.public static void exit(int status):终止JVM虚拟机，非O是异常终止。
     *      2.public static long currentTimeMillis():获取当前系统此刻时间毫秒值。
     *      3.可以做数组的拷贝。
     *          arraycopy(object var0，int varl，object var2， int var3,int var4);
     *          参数一:原数组
     *          参数二:从原数组的哪个位置开始赋值。
     *          参数三:目标数组
     *          参数四:赋值到目标数组的哪个位置
     *          参数五:赋值几个。
     */
    public static void main(String[] args) {
        System.out.println("程序开始");

        // 获取系统当前时间毫秒值
        System.out.println(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yy年MM月dd日 hh:mm:ss");
        System.out.println(sdf.format(System.currentTimeMillis()));

        // 数组的拷贝
        int array1[] = {10,20,30,40,50};
        int array2[] = new int[4];

        System.arraycopy(array1,2,array2,1,3);
        System.out.println(Arrays.toString(array2));

        // 终止虚拟机
        System.exit(0); // 0是正常终止

        System.out.println("程序结束");
    }
}
