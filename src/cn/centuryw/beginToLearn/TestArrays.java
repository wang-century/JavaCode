package cn.centuryw.beginToLearn;
import java.util.Arrays;

/**
 * java.util.Arrays工具类的使用
 *
 *
 */
public class TestArrays {
    public static void main(String[] args) {
        /* 打印数组 */
        System.out.println("---打印数组---");
        int[] ary1 = {1,2,3};
        System.out.println(ary1);   //打印数组引用的值
        System.out.println(Arrays.toString(ary1));  //打印数组元素的值

        /* 数组元素排序 */
        System.out.println("---数组元素排序---");
        int[] ary2 = {4,3,6,3,1,2};
        System.out.println(Arrays.toString(ary2));
        Arrays.sort(ary2);
        System.out.println(Arrays.toString(ary2));

        /* 二分法查找元素 */
        System.out.println("---二分法查找元素---");
        System.out.println(Arrays.toString(ary2));
        System.out.println("查找元素3结果为:"+Arrays.binarySearch(ary2,3));    //在数组ary2中查找3  找到返回索引，否则返回-1


    }

}
