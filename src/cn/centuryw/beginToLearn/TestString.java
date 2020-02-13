package cn.centuryw.beginToLearn;

/**
 * 测试字符串类的基本用法
 * 1.String类又称为不可变字符序列。
 * 2.String位于java.lang包中，Java程序默认导入java.lang包下的所有类。
 * 3.Java字符串是Unicode字符序列，例如字符串”Java”就是4个Unicode字符。
 * 4.Java没有内置的字符串类型，而是在标准Java类库中提供了一个预定义的类String，每个双引号括起来的字符串都是String类的一个实例。
 */
public class TestString {
    public static void main(String[] args) {
        //创建方法
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = "abc" + "def";    //字符串拼接
        String str4 = "18" + 19;    //注意：不是加法，是字符串连接符
        System.out.println(str4);

        //比较字符串
        String name1 = "shiji";
        String name2 = "shiji";
        String name3 = new String("shiji");

        System.out.println(name1 == name2);
        System.out.println(name2 == name3); //name2 与 name3 不是同一个对象

        //比较字符串时，通常使用equals
        System.out.println(name2.equals(name3));

        //String类常用方法一
        String s1 = "core Java";
        String s2 = "core Java";
        System.out.println(s1.charAt(3));   //提取下标为3的字符
        System.out.println(s1.length());    //字符串的长度
        System.out.println(s1.equals(s2));  //比较两个字符串是否相同
        System.out.println(s1.equalsIgnoreCase(s2));    //比较两个字符串，忽略大小写
        System.out.println(s1.indexOf("Java"));     //字符串s1中是否包含Java
        String result = s1.replace(' ','#');    //将s1中的空格替换成#
        System.out.println("替换结果为："+result);

        String s3 = "";
        String s4 = "How are you?";
        System.out.println(s4.startsWith("How"));   //是否以How开头 正确为true，否则为false
        System.out.println(s4.endsWith("you"));     //是否以you结尾 正确为true，否则为false

        s3 = s4.substring(4);   //提取字符串，从下标为4开始到结尾
        System.out.println(s3);
        s3 = s4.substring(4,7); //提取字符串，从下标4开始到7(不包括)结束
        System.out.println(s3);
        s3 = s4.toLowerCase();  //转小写(全部)
        System.out.println(s3);
        s3 = s4.toUpperCase();  //转大写(全部)
        System.out.println(s3);

        String s5 = " How dare you?";
        s3 = s5.trim(); //去除字符串首尾的空格（不包括中间的空格）
        System.out.println(s3+'\n'+s5);
    }
}
