package com.company;

/**
 * 测试字符类型
 *
 * @author centuryw
 */
public class TestPrimitiveDataType2 {
    public static void main(String[] args) {
        char a = 'T';
        char b = '王';
        char c = '\u0061';
        System.out.println(c);

        //转义字符
        System.out.println("" + 'a' + '\'' + '\t' + 'b');

        //String就是字符序列
        String d = "abc";
        System.out.println(d);

        //测试布尔类型
        boolean man = true;

        if(man) {
            System.out.println("男性");
        }
        if(man==true){  //不推荐这样写
            System.out.println("男性");
        }
    }
}
