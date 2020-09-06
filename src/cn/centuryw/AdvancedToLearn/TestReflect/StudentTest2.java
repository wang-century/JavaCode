package cn.centuryw.AdvancedToLearn.TestReflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 目标:反射_获取constructor构造器然后通过这个构造器初始化对象。
 * 反射获取class中的构造器对象constructor作用:
 * 也是初始化并得到类的一个对象返回。
 * constructor的API:
 * 1. T newInstance (object... initargs)
 * 创建对象，注入构造器需要的数据。
 * 2. void setAccessible(true)
 * 小结:
 * 可以通过定位类的构造器对象。
 * 如果构造器对象没有访问权限可以通过: void setAccessible(true)打开权限
 * 构造器可以通过T newInstance(object... initargs)调用自己，传入参数!
 * 修改访问权限，true代表暴力攻破权限，false表示保留不可访问权限(暴力反射)
 */
public class StudentTest2 {
    /**
     * 调用无参构造器得到一个类的对象
     * @throws Exception 错误信息
     */
    @Test
    public void createObj1() throws Exception{
        // 得到class类对象
        Class<?> c = Student.class;
        // 定位无参构造器对象
        Constructor<?> constructor = c.getDeclaredConstructor();
        // 暴力打开私有构造器的访问权限
        constructor.setAccessible(true);
        // 通过无参构造器初始化对象返回
        Student student = (Student)constructor.newInstance();
        System.out.println(student);
    }

    /**
     * 调用有参构造器得到一个类的对象
     * @throws Exception 错误信息
     */
    @Test
    public void createObj2() throws Exception{
        // 得到class类对象
        Class<?> c = Student.class;
        // 定位无参构造器对象
        Constructor<?> constructor = c.getDeclaredConstructor(String.class,int.class);
        // 通过无参构造器初始化对象返回
        Student student = (Student)constructor.newInstance("萧柒",20);
        System.out.println(student);
    }

}
