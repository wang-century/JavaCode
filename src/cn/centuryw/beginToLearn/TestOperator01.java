package cn.centuryw.beginToLearn;

/**
 * 测试运算符
 * @author centuryw
 */
public class TestOperator01 {
    public static void main(String[] args) {
        // byte + int 结果为 int
        System.out.println("===算数运算符===");
        byte a = 1;
        int b = 2;
        System.out.println(a+b);
        // long + int 结果为 long
        long a2 = 4;
        int b2 = 3;
        System.out.println(a2+b2);
        // float + double 结果为 double
        float f1 = 3.14F;
        double d1 = b+b2;
        System.out.println(f1+d1);

        // 取余操作 可以为浮点数，一般使用整数，结果为“余数”，“余数”符号和左边操作数相同
        System.out.println(7%3);
        System.out.println(-7%3);
        System.out.println(7%-3);

        // 自增自减一元运算符
        System.out.println("===自增自减一元运算符===");
        int number1 = 1;
        int number2 = number1++;    //执行结果为number2=1。先给number2赋值，然后number1自增
        int number3 = 2;
        int number4 = ++number3;    //执行结果为number4=3。number3先自增，然后赋值给number4
        System.out.println("number1="+number1+"\tnumber2="+number2);
        System.out.println("number3="+number3+"\tnumber4="+number4);

        // 赋值及扩展运算符
        System.out.println("===赋值及扩展运算符===");
        int e = 3;
        int f = 4;
        e += f; //相当于a=a+b
        System.out.println("e="+e+"\nf="+f);
        a = 3;
        b = 4;
        a *= b+3;   //相当于a=a*(b+3)
        System.out.println("a="+a+"\nb="+b);

        // 关系运算符    关系运算的结果是布尔值：true/false
        System.out.println("===关系运算符===");
        a = 3;
        System.out.println(a==3);
        System.out.println(a!=3);
        System.out.println(a<5);

        char g = 'a';
        char h = 'c';
        System.out.println((int)g); //强制类型转换
        System.out.println(0+g);    //int+char为int
        System.out.println(0+h);
        System.out.println(g<h);

        //逻辑运算符
        System.out.println("===逻辑运算符===");
        /* 运算符    符号   说明
           逻辑与    &      两个操作数为true，结果才为true，否则为false
           逻辑或    |      两个操作数有一个为true，则结果为true
           短路与    &&     只要有一个为false，则直接返回false
           短路或    ||     只要有一个为true，则直接返回true
           逻辑非    !      取反：!false为true，!true为false
           逻辑异或  ^      相同为false，不同为true
         */
        boolean c1 = true;
        boolean c2 = false;
        System.out.println(c1&c2);
        System.out.println(c1|c2);
        System.out.println(c1^c2);
        System.out.println(!c2);
        System.out.println(c1&&c2);
        System.out.println(c1||c2);

        /*条件运算符
            语法格式 x ? y : z
            其中x为boolean类型表达式，先计算x的值，若为true，则整个运算的结果为表达式y的值，否则为z的值
        * */
        System.out.println("===条件运算符===");
        int score = 80;
        int x = -100;
        String type = score<60 ? "不及格" : "及格";
        System.out.println("type="+type);

        System.out.println(x>0?1:(x==0?0:-1));



    }
}
