package cn.centuryw.beginToLearn;

import java.util.Arrays;

/**
 * 测试数组存储表格数据
 */
public class TestArrayTableData {
    public static void main(String[] args) {
        // 每行数据
        Object[] a1 = {1001, "小七", 18, "教师", "2008.8.8"};
        Object[] a2 = {1001, "小八", 19, "教师", "2008.4.8"};
        Object[] a3 = {1001, "小六", 17, "教师", "2008.5.8"};
        // 存放到table_data数组
        Object[][] table_data = {a1, a2, a3};
        // 打印输出
        for(Object[] temp:table_data){
            System.out.println(Arrays.toString(temp));
        }

    }
}
