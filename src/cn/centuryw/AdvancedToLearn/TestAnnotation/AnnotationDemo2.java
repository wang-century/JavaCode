package cn.centuryw.AdvancedToLearn.TestAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 注解模拟Junit框架
 *
 * 需求:定义若干个方法，只要加了MyTest注解，
 *      就可以被自动触发执行。
 *
 * 分析:
 * (1）定义一个自定义注解TestMy.
 * --只能注解方法。
 * --存活范围一直都在。
 * (2）定义若干个方法，只要有@TestMy注解的方法就能被触发执行!!
 * 没有这个注解的方法不能执行!!
 *
 * 小结:
 * 注解和反射可以配合解决一些框架思想
 * 注解可以实现标记的成分做特殊处理!!
 */
public class AnnotationDemo2 {
    @MyTest
    public void test01(){
        System.out.println("test01");
    }

    @MyTest
    public void test02(){
        System.out.println("test02");
    }

    @MyTest
    public void test03(){
        System.out.println("test03");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // 模拟测试类的启动按钮，有注解就执行
        AnnotationDemo2 demo = new AnnotationDemo2();
        // 1.得到类对象
        Class<?> c = AnnotationDemo2.class;
        // 2.获取类中全部方法对象
        Method[] methods = c.getDeclaredMethods();
        // 3.遍历全部方法，判断是否有"MyTest"注解，有则执行
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)){
                // 触发方法执行
                method.invoke(demo);
            }
        }
    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyTest{

}

