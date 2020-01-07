package cn.centuryw.beginToLearn;

/**
 * 测试do-while循环结构
 *
 * @author centuryw
 */
public class TestDoWhile {
    public static void main(String[] args) {
        //求1-100之间的累加和
        int sum = 0;
        int i = 1;
        do {    //不管条件是否符合，先执行一遍后判断
            sum += i;
            i++;
        } while (i <= 100);
        System.out.println("结果为:"+sum);
    }
}
