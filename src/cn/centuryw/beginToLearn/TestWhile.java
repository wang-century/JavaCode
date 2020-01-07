package cn.centuryw.beginToLearn;

/**
 * 测试while循环结构
 * @author centuryw
 */
public class TestWhile {
    public static void main(String[] args) {
        //求1-100之间的累加和
        int sum_result = 0;
        int i = 1;
        while(i<=100){
            sum_result+=i;
            i++;
        }
        System.out.println("累加和为："+sum_result);
    }
}
