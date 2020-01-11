package cn.centuryw.beginToLearn;

import java.util.Date;
//import java.sql.Date; //包重名
import static java.lang.Math.PI;    //导入Math类的PI属性
/**
 * 测试import导入包及导入包重名的解决方法及静态导入
 * @author centuryw
 */

public class TestImport {
    public static void main(String[] args) {
        //包重名时 使用包名+类名来显式调用相关类
        java.util.Date date1 = new java.util.Date();
        //导入指定类的静态属性可以直接使用
        System.out.println(PI);
    }
}
