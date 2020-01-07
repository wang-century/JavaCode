package cn.centuryw.beginToLearn;

/**
 * 测试for循环结构
 * @author centuryw
 */
public class TestFor {
    public static void main(String[] args) {
        //求1-100之间的累加和
        int sum = 0;
        for(int i=1;i<=100;i++){
            sum += i;
        }
        System.out.println(sum);
    }
}
