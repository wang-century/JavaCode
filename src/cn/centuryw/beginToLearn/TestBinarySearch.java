package cn.centuryw.beginToLearn;

import java.util.Arrays;

/**
 * 二分法查找
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        // 定义数据
        int[] data = {30, 20, 50, 10, 80, 9, 7, 12, 100, 40, 8};
        int search_value = 20;

        int result = binarySearch(data,search_value);
        if(result!=-1){
            System.out.println("在序列中找到了"+search_value);
        }else{
            System.out.println("在序列中没有找到"+search_value);
        }
    }

    // 定义二分法查找（传入数组和要查找的数，若找到则返回该数，否则返回-1）
    public static int binarySearch(int[] data, int value) {
        /* 参数:
         *      data  数组
         *      value 要查找的数  */

        // 对数据进行排序
        Arrays.sort(data);

        // 二分法（折半）查找
        int start_point = 0;    // 查找起始点
        int end_point = data.length - 1;      // 查找结束点

        while (start_point <= end_point) {
            int mid_point = (start_point + end_point) / 2;    // 中间点

            // 如果查找的数等于中间点位置的数，返回该数
            if(value==data[mid_point]){
                return data[mid_point];
            }

            // 如果查找的数大于中间点位置的数，则起始点设为“中间点+1”
            if(value>data[mid_point]){
                start_point = mid_point+1;
            }

            // 如果查找的数小于中间点位置的数，则结束点设为“中间点-1”
            if(value<data[mid_point]){
                end_point = mid_point-1;
            }
        }
        // 若循环结束仍未找到数则返回-1
        return -1;
    }
}
