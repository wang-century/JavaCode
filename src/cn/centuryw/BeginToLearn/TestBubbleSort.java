package cn.centuryw.BeginToLearn;

import java.util.Arrays;

/**
 * 实现冒泡排序
 */

public class TestBubbleSort {
    public static void main(String[] args) {
        // 定义一个数组
        int[] values = {3,1,6,2,9,0,7,4,5,8};
        int temp;
        for(int i=0;i<values.length-1;i++){
            boolean flag = true;    // 用于判断是否排序完成
            for(int j=0;j<values.length-1-i;j++){
                // 比较大小 换顺序
                if(values[j]>values[j+1]){
                    temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                    flag = false;   // 若发生了交换说明排序未完成
                }
                System.out.println(Arrays.toString(values));
            }
            // 若未发生交换说明排序已完成，则退出循环
            if(flag){
                break;
            }
            System.out.println("-------");
        }

    }
}
