package cn.centuryw.beginToLearn;

/**
 * 测试二维数组
 *
 */
public class Test2DArray {
    public static void main(String[] args) {
        //定义二维数组
        int[][] a = new int[3][];
        a[0] = new int[]{20,30};
        a[1] = new int[]{10,20,30};
        a[2] = new int[]{20,60};
        System.out.println(a[1][2]);
        //静态初始化二维数组
        int[][] b = {
                {1,2,3},
                {10,20},
                {1,6,8,9}
        };
        System.out.println(b[2][3]);
    }
}
