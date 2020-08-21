package cn.centuryw.BeginToLearn;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        // 准备一个数组
        int array[] = {1,4,3,2,5,1};
        int array2[] = selectionSort(array);
        System.out.println(Arrays.toString(array2));

    }


    /**
     * 对数组进行选择排序(升序)
     * @param array 要进行排序的数组
     */
    public static int[] selectionSort(int[] array){
        int arrayLength = array.length;
        // 排序轮次
        for (int i=0;i<arrayLength-1;i++){
            for (int j=i+1;j<arrayLength;j++){
                if (array[i]>array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
