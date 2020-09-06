package cn.centuryw.AdvancedToLearn.TestReflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 目标:反射的概念。
 反射，注解，代理，泛型是Java的高级技术，是以后框架的底层原理必须使用到的技术。
 反射:是Java独有的技术。是Java技术显著的特点。
 反射是指对于任何一个类，在"运行的时候"都可以直接得到这个类全部成分。
    在运行时,可以直接得到这个类的构造器对象。（constructor)
    在运行时，可以直接得到这个类的成员变量对象。（Field)
    在运行时，可以直接得到这个类的成员方法对象。（Method）
 反射的核心思想和关键就是得到:编译以后的class文件对象。
 反射提供了一个class类型，就是可以得到编译以后的class类对象。
    HelloWorld.java -> javac -> HelloWorld.class

    class c = HelloWorld.class;

 注意:反射是工作在运行时的技术，因为只有运行之后才会有class类对象。
 小结:
     反射的核心思想和关键就是得到:编译以后的class文件对象。
     反射是在运行时获取类的字节码文件对象:然后可以解析类中的全部成分。
 */
public class ReflectDemo {
    /**
     * 反射获取Class类对象
     * 引入:
     *      反射是通过先得到编译以后的class类对象:字节码文件。
     *      然后才可以得到类中的全部成分，进行一些功能设计。
     *
     * 反射为一个类的全部成分都设计了一个类型来代表这个对象:
     * Class:       字节码文件的类型
     * Constructor: 构造器的类型
     * Field:       成员变量的类型
     * Method:      方法的类型
     *
     * 反射技术的第一步永远是先得到Class类对象:有三种方式获取
     *      (1）类名.class
     *      (2）通过类的对象.getClass()方法
     *      (3) Class.forName ("类的全限名")
     *          -- public static Class<?> forName(string className)
     *
     * Class类下的方法:
     * string getSimpleName();      获得类名字符串:类名
     * string getName();            获得类全名:包名+类名
     * T newInstance();             创建Class对象关联类的对象，其实底层也是调用无参数构造器，已经被淘汰;
     *
     * 小结:
     * class类对象的获取有三种方式:
     *      1.类名.class。
     *      2.通过类的对象.getClass()方法。
     *      3.Class.forName("类的全限名")
     * class类的方法:
     *      string getSimpleName(); 获得类名字符串:类名
     *      string getName();       获得类全名:包名+类名
     */
    @Test
    public void demo1(){
        // (1）类名.class
        Class<?> c1 = Student.class;
        System.out.println(c1);

        // (2）通过类的对象.getClass()方法
        Student student = new Student("张三",20);
        Class<?> c2 = student.getClass();
        System.out.println(c2);

        // (3) Class.forName ("类的全限名")
        try{
            Class<?> c3 = Class.forName("cn.centuryw.AdvancedToLearn.TestReflect.Student");
            System.out.println(c3);
        }catch (Exception e){
            e.printStackTrace();
        }

        // Class类下的方法
        System.out.println(c1.getSimpleName());
        System.out.println(c1.getName());
    }


    /**
     * 目标:反射获取Field成员变量对象。
     * 反射的第一步是先得到class类对象。
     * 1、Field getField(string name) ;
     * 根据成员变量名获得对应Field对象，只能获得public修饰
     * 2.Field getDeclaredField (string name) ;
     * 根据成员变量名获得对应Field对象，只要申明了就可以得到
     * 3.Field[ getFields();
     * 获得所有的成员变量对应的Field对象，只能获得public的
     * 4.Field[]getDeclareFields ();
     * 获得所有的成员变量对应的Field对象，只要申明了就可以得到
     * 小结:
     * 获取全部成员变量: getDeclaredFields
     * 获取某个成员变量: getDeclaredField
     */
    @Test
    public void getDeclaredFields(){
        /* 获取全部的成员变量 */
        // 得到class类对象
        Class<?> c = Student.class;
        // 获取全部申明的成员变量
        Field[] fields = c.getDeclaredFields();
        for (Field field:fields){
            System.out.println(field.getName()+"-->"+field.getType());
        }
    }

    @Test
    public void getDeclaredField() throws Exception{
        /* 获取某个成员变量对象 */
        // 得到class类对象
        Class<?> c = Student.class;
        // 定位某个成员变量对象（通过名称定位）
        Field age = c.getDeclaredField("age");
        System.out.println(age.getName()+"-->"+age.getType());
    }

    /**
     * 目标:反射获取成员变量:取值和赋值。
     * Field的方法:给成员变量赋值和取值
     * void set(object obj，object value):给对象注入某个成员变量数据
     * object get(object obj):获取对象的成员变量的值。
     * void setAccessible(true);暴力反射，设置为可以直接访问私有类型的属性。
     * class getType();获取属性的类型，返回class对象。
     * string getName ();获取属性的名称。
     */
    @Test
    public void fieldDemo() throws Exception{
        // 得到class类对象
        Class<?> c = Student.class;
        // 定位某个成员变量对象（通过名称定位）
        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        // 为成员变量赋值
        Student student = new Student("张三",10);
        System.out.println(student);
        name.set(student,"Lucy");
        System.out.println(student);
        // 获取成员变量的值
        String value = name.get(student)+"";
        System.out.println(value);
    }

    /**
     * 目标:反射—获取Method方法对象
     * 反射获取类的Method方法对象:
     * 1、Method getMethod (string name,class...args) ;
     * 根据方法名和参数类型获得对应的方法对象，只能获得public的
     * 2、Method getDeclaredMethod (string name,class...args);
     * 根据方法名和参数类型获得对应的方法对象，包括private的
     * 3、Method[] getMethods ();
     * 获得类中的所有成员方法对象，返回数组，只能获得public修饰的且包含父类的
     * 4、Method[] getDeclaredMethods () ;
     * 获得类中的所有成员方法对象，返回数组，只获得本类申明的方法。
     *
     * Method的方法
     * object invoke (object obj, object... args)
     * 参数一:触发的是哪个对象的方法执行。
     * 参数二:args:调用方法时传递的实际参数
     */
    @Test
    public void getDeclaredMethod() throws Exception{
        /* 获取类中所有成员方法对象 */
        // 得到class类对象
        Class<?> c = Student.class;
        // 获取全部方法
        Method[] methods = c.getDeclaredMethods();
        // 遍历
        for (Method method : methods) {
            System.out.println(method.getName()+"-->"+method.getParameterCount()+"-->"+method.getReturnType());
        }
    }

    @Test
    public void getDechardMethod() throws Exception{
        /* 获取类中某个成员方法对象 */
        // 得到class类对象
        Class<?> c = Student.class;
        // 定位某个方法
        Method getAge = c.getDeclaredMethod("getAge");
        Method setAge = c.getDeclaredMethod("setAge", int.class);
        // 触发方法执行
        Student student = new Student("张三",14);
        setAge.invoke(student,30);
        System.out.println(getAge.invoke(student));
    }

    /**
     * 拓展
     * 1.反射可以破坏面向对象的封装性（暴力反射）。
     * 2.同时可以破坏泛型的约束性。
     */
    @Test
    public void reflectExtension() throws Exception{
        // 泛型只能工作在编译阶段，运行阶段泛型就消失了
        // 反射工作在运行阶段
        List<Double> scores = new ArrayList<>();
        scores.add(99.9);
        scores.add(88.3);
        // 通过反射暴力注入一个其它类型的数据进入
        // 得到集合对象的class文件对象
        Class<?> c = scores.getClass();
        // 定位add方法
        Method add = c.getDeclaredMethod("add", Object.class);
        // 触发方法
        add.invoke(scores,"你好");
        System.out.println(scores);
    }
}
