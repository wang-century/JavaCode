package cn.centuryw.AdvancedToLearn.TestAnnotation;

import javax.swing.text.Element;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 目标:注解的概念。
 注解:
 用在类上，方法上，成员变量，构造器，...上对成分进行编译约束，标记等操作的。
 注解是JDK1.5的新特性。
 注解相当一种标记，是类的组成部分，可以给类携带一些额外的信息。
 注解是给编译器或JVM看的，编译器或JVM可以根据注解来完成对应的功能。
 注解作用:
 1.标记。
 2.方法重写约束@Override
 3.函数式接口约束。 @FunctionalInterface
 4.现今最牛逼的框架技术多半都是在使用注解和反射。都是属于框架的基础技术。
 我们之前用的注解都是别人写好的，今天我们自己来定义一下注解。


 自定义注解的格式:
    [修饰符]@interface注解名{
        //注解属性
    }
 小结:
 自定义注解用@interface关键字。
 注解默认可以标记很多地方。


 目标:注解的属性:
 属性的格式
 -格式1:数据类型属性名();
 –格式2:数据类型属性名()default默认值;
 属性适用的数据类型:
 八种数据数据类型(int，short，long，double，byte
 ，char，boolean，float)
 string，class
 以上类型的数组形式都支持
 小结:
 注解可以有属性，属性名必须带()
 在用注解的时候，属性必须赋值，除非这个属性有默认值!!


 目标:注解的特殊属性名称: value
 value属性，如果只有一个value属性的情况下，
 使用value属性的时候可以省略value名称不写!!
 但是如果有多个属性,且多个属性没有默认值，那么value是不能省略的。

 元注解是sun公司提供的。
 元注解是用在自定义注解上的注解。
 元注解是用来注解自定义注解的。
 元注解有两个:
 @Target:约束自定义注解只能在哪些地方使用，
 --但是默认的注解可以在类，方法，构造器，成员变量，..．使用。
 @Rentention :申明注解的生命周期
 --中明注解的作用范围:编译时，运行时。

 @Target
  *作用:用来标识注解使用的位置，如果没有使用该注解标识，则自定义的注解可以使用在任意
  *CLASS:注解作用在源码阶段，字节码文件阶段，运行阶段不存在，默认值.
 RUNTIME:注解作用在源码阶段，字节码文件阶段，运行阶段（开发常用)
 可使用的值定义在ElementType枚举类中，常用值如下
 TYPE，类，接口
 FIELD，成员变量
 METHOD，成员方法
 PARAMETER，方法参数Ⅰ
 CONSTRUCTOR，构造器
 LOCAL_VARIABLE，局部变量

 @Retention
 作用:用来标识注解的生命周期(有效存活范围)
 太可使用的值定义在RetentionPolicy枚举类中，常用值如下
 SOURCE:注解只作用在源码阶段，生成的字节码文件中不存在

 小结:
 @Target约束自定义注解可以标记的范围。
 Retention用来约束自定义注解的存活范围。


 */
public class AnnotationDemo {
}

@Book(name = "Java从入门到入土",authors = {"张三","李四"},price = 33.5)
class MyBook{
    @Book(name = "Java从入门到入土",authors = {"张三","李四"},price = 33.5)
    @Hello("你好")
    public MyBook(){
    }
}

// 注解的属性
@interface Book{
    String name();
    String[] authors();
    double price();
    String address() default "中国";
}

// 元注解，约束只能在方法、构造器使用
@Target({ElementType.METHOD,ElementType.CONSTRUCTOR})
// 存活范围
@Retention(RetentionPolicy.RUNTIME)
// 注解的特殊属性名称
@interface Hello{
    String value();
    int age() default 20;
}
