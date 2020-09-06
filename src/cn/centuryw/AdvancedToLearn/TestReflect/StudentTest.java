package cn.centuryw.AdvancedToLearn.TestReflect;

import org.junit.Test;

import java.lang.reflect.Constructor;


/**
 * 反射获取Constructor构造器对象．
 * 反射的第一步是先得到Class类对象（Class文件）
 *
 * 反射中Class类型获取构造器提供了很多的API:
 * 1. constructor getConstructor(class... parameterTypes)
 * 根据参数匹配获取某个构造熟，只能拿public修饰的构造器，几乎不用!
 * 2.constructor getDeclaredConstructor(Class... parameterTypes)
 * 根据参数匹配获取某个构造器，只要申明就可以定位，不关心权限修饰符，建议使用!
 * 3. constructor[] getConstructors ()
 * 获取所有的构造器，只能拿public修饰的构造器。几乎不用!!太弱了!
 * 4. constructor[] getDeclaredConstructors ()
 * 获取所有申明的构造器，只要你写我就能拿到，无所谓权限。建议使用!!
 * 小结:
 * 获取类的全部构造器对象:constructor[] getDeclaredConstructors ()
 * --获取所有申明的构造器，只要你写我就能拿到，无所谓权限。建议使用!!
 * 获取类的某个构造器对象:constructor getDeclaredConstructor(Class... parameterTy
 * --根据参数匹配获取某个构造器，只要申明就可以定位，不关心权限修饰符，建议使用!
 *
 * 反射获取constructor构造器然后通过这个构造器初始化对象。
 *
 * 反射获取class中的构造器对象constructor作用:
 * 也是初始化并得到类的一个对象返回。
 * constructor的API:
 * 1.T newInstance(object... initargs)
 *      创建对象，注入构造器需要的数据。
 * 2.void setAccessible (true)
 *      修改访问权限，true代表暴力攻破权限，false表示保留不可访问权限(暴力反射)
 * 小结:
 * 可以通过定位类的构造器对象。
 * 如果构造器对象没有访问权限可以通过:void setAccessible(true)打开权限
 * 构造器可以通过T newInstance(object... initargs)调用自己，传入参数!
 */
public class StudentTest {

    /**
     * 1.getConstructors
     * 获取全部构造器，只能拿public修饰
     */
    @Test
    public void getConstructors(){
        // a.得到class类对象
        Class<?> student = Student.class;
        // b.定位全部构造器，只能拿public修饰
        Constructor<?>[] cons = student.getConstructors();
        // c.遍历构造器
        for(Constructor<?> constructor:cons){
            System.out.println(constructor.getName()+"-->"+constructor.getParameterCount());
        }
    }

    /**
     * 2.getDeclaredConstructors
     * 获取全部构造器
     */
    @Test
    public void getDeclaredConstructors(){
        // a.得到class类对象
        Class<?> student = Student.class;
        // b.定位全部构造器
        Constructor<?>[] cons = student.getDeclaredConstructors();
        // c.遍历构造器
        for (Constructor<?>con:cons){
            System.out.println(con.getName()+"-->"+con.getParameterCount());
        }
    }

    /**
     * 3.getConstructor
     * 获取某个构造器(有权限限制)
     */
    @Test
    public void getConstructor() throws NoSuchMethodException {
        // a.得到class类对象
        Class<?> student = Student.class;
        // b.定位某个构造器
        Constructor<?> con = student.getConstructor(String.class,int.class);
        // 构造器名称和参数
        System.out.println(con.getName()+"-->"+con.getParameterCount());
    }

    /**
     * 4.
     * 获取某个构造器(无权限限制)
     */
    @Test
    public void getDeclaredConstructor() throws NoSuchMethodException {
        // a.得到class类对象
        Class<?> student = Student.class;
        // b.定位某个构造器
        Constructor<?> con = student.getDeclaredConstructor();
        // 构造器名称和参数
        System.out.println(con.getName()+"-->"+con.getParameterCount());
        // b.定位某个构造器
        con = student.getDeclaredConstructor(String.class,int.class);
        // 构造器名称和参数
        System.out.println(con.getName()+"-->"+con.getParameterCount());
    }
}
