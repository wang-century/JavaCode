package cn.centuryw.BeginToLearn;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TestGenericity {
    /**
     * 什么是泛型?
     * 泛型就是一个标签:<数据类型>
     * 泛型可以在编译阶段约束只能操作某种数据类型。
     * 注意:JDK 1.7开始之后，泛型后面的申明可以省略不写!!
     * 泛型和集合都只能支持引用数据类型，不支持基本数据类型。
     * <p>
     * 好处：
     * 泛型在编译阶段约束了操作的数据类型，从而不会出现类型转换异常。
     */
    public static void main(String[] args) {
        // 创建MyArrayList对象
        MyArrayList<String> list = new MyArrayList<>();
        // 给你任何一个类型的数组，都能返回它的内容
        String[] names = {"1213", "23", "伪君"};
        System.out.println(myToString(names));
        // 泛型接口
        Data<Student> data = new StudentData();
        data.add(new Student());    // 添加学生
        // ？通配符
        ArrayList<BMW> bmwArrayList = new ArrayList<>();
        ArrayList<BENZ> benzArrayList = new ArrayList<>();
        bmwArrayList.add(new BMW());
        benzArrayList.add(new BENZ());
        GenericDemo.run(benzArrayList);
        GenericDemo.run(bmwArrayList);
    }


    static <T> String myToString(T[] array) {
        /**
         * 目标:自定义泛型方法。
         *  什么是泛型方法?
         *      定义了泛型的方法就是泛型方法。
         * 泛型方法的定义格式:
         *   修饰符<泛型变量>返值类型 方法名称(形参列表){
         *   }
         * 注意:方法定义了是什么泛型变量，后面就只能用什么泛型变量。
         * 泛型类的核心思想:是把出现泛型变量的地方全部替换成传输的真实数据类型。
         *  需求:给你任何一个类型的数组，都能返回它的内容。
         */
        StringBuilder result = new StringBuilder();
        result.append("[");
        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                T value = array[i];
                result.append(i == array.length - 1 ? value : value + ",");
            }
        }
        result.append("]");
        return result.toString();
    }

}

/**
 * 什么是泛型接口?
 * 使用了泛型定义的接口就是泛型接口。
 * 泛型接口的格式:
 * 修饰interface接口名称<泛型变量>{
 * 需求:教务系统，提供一个接口可约束一定要完成数据的增删改查操作
 *
 * @param <T>
 */
interface Data<T> {
    void add(T object);

    void delete(T object);

    void update(T object);

    void query(T object);
}

/**
 * 操作学生数据(实现泛型接口)
 */
class StudentData implements Data<Student> {

    @Override
    public void add(Student object) {

    }

    @Override
    public void delete(Student object) {

    }

    @Override
    public void update(Student object) {

    }

    @Override
    public void query(Student object) {

    }
}


class MyArrayList<T> {
    /**
     * 目标:自定义泛型类。
     * 引入:
     * 我们之前用的泛型都是别人写好的，接下来我们来自定义泛型类使用。
     * 泛型类的概念:
     * 使用了泛型定义的类就是泛型类。
     * 泛型类的格式:
     * 修饰符class类名<泛型变量>{}
     * 泛型变量建议使用E， T ， K , v
     * 需求:模拟ArrayList自定义一个集合MyArrayList集合。
     * 泛型类的核心思想:是把出现泛型变量的地方全部替换成传输的真实数据类型。
     */
    private ArrayList<T> list = new ArrayList<T>();

    public void add(T value) {
        // 添加数据

    }

    public T remove(T value) {
        // 删除数据

        return value;
    }
}

/**
 * 目标:泛型通配符。
 * 需求:开发一个极品飞车的游戏，所有的汽车都能一起参与比赛。
 * 注意:
 *      虽然BMW和BENZ都继承了car
 *      但是ArrayList<BMW>和ArrayList<BENZ>与jArrayList<car>没有关系的!泛型没有继承关系
 * 通配符:?
 *      ?可以用在使用泛型的时候代表一切类型。
 * E，T，K ，v是在定义泛型的时候使用代表一切类型。
 *
 * 泛型的上下限:
 *      ? extends car :那么?必须是car或者其子类。(泛型的上限)
 *      ? supercar :那么?必须是car或者其父类。（泛型的下限。不是很常卿
 */
class GenericDemo{
    // 定义方法，使汽车一起参加比赛
    public static void run(ArrayList<?extends Car> cars){

    }
}
class Car{

}
class BMW extends Car{

}

class BENZ extends Car{

}