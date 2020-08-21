package cn.centuryw.BeginToLearn;

/**
 *      二分查找。
 * 正常查找:从第一个元素开始遍历，一个一个的往后找，综合查找比较耗时。
 * 二分查找:二分查找的前提:对数组是有要求的，数组必须已经排好序。
 * 如果没有该元素，返回-1。综合性能比较好!!
 * 每次先与中间的元素进行比较，如果大于往右边找，如果小于往左边找，如果等于就返回该元素索引位置
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {10,14,21,38,45,57,58,81,87,99};
        System.out.println(binarySearch(array,10));

    }

    /**
     * 传入数组和要查找的元素进行二分法查找(必须是已经排序的数组)
     * @param value  要查找的值
     * @param array　要进行查找的数组
     * @return  是否存在，是则返回元素在数组的位置，否则返回-1
     */
    public static int binarySearch(int[] array,int value){
        // 定义起始位置和结束位置
        int start =0;
        int end = array.length-1;

        // 循环条件为：起始位置与结束位置不重叠
        while (start<=end){
            // 中间元素索引
            int middle = (start+end)/2;
            // 比较当前元素与中间元素
            if (value> array[middle]){
                // 元素大于中间元素，往右找，起始位置改变
                start = middle+1;
            }else if (value<array[middle]){
                // 元素小于中间元素，往左找，结束位置改变
                end = middle-1;
            }else if (value==array[middle]){
                // 元素等于中间元素，返回索引
                return middle;
            }
        }
        // 若上述条件无返回值，则未找到元素，返回－１
        return -1;
    }
}
