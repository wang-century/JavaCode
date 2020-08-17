package cn.centuryw.BeginToLearn;

import java.math.BigDecimal;

/**
 * 测试基本数据类型
 * @author centuryw
 */
public class TestPrimitiveDataType {
    public static void main(String[] args) {
        //测试整形变量
        int a = 15;
        int b = 015;    //以0开头是八进制
        int c = 0x15;   //以0x开头是16进制
        int d = 0b1101; //以0b开头是二进制
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        //测试浮点型变量  注意：浮点数是不精确的，一定不要用于比较！
        float A = 3.14F;
        double B = 6.28;
        double C = 628E-2;
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        //精确浮点运算需要用到java.math包的BigDecimal
        BigDecimal bd = BigDecimal.valueOf(1.0);
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        System.out.println(bd); //0.5
        System.out.println(1.0-0.1-0.1-0.1-0.1-0.1);    //0.5000000000000001

        BigDecimal bd2 = BigDecimal.valueOf(0.1);
        BigDecimal bd3 = BigDecimal.valueOf(1.0/10.0);

        System.out.println(bd2.equals(bd3));

    }
}
