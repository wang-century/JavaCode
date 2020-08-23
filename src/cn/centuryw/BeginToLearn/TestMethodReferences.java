package cn.centuryw.BeginToLearn;

import java.util.*;
import java.util.function.IntFunction;

/**
 * 方法引用的概述〈了解)
 * 方法引用:
 *      方法引用是为了进一步简化Lambda表达式的写法。
 * 方法引用的格式:
 *      类型或者对象::引用的方法。
 * 关键语法是:"::"
 * 小结:
 *      方法引用可以进一步简化Lambda表达式的写法。
 *      关键语法是:"::"
 *
 * 目标:方法引用有四种形式:
 *      1.静态方法的引用。
 *      2.实例方法的引用。
 *      3.特定类型方法的引用。
 *      4.构造器引用。
 *
 * 1.静态方法的引用。
 * 引用格式:
 *      类名::静态方法。
 * 简化步骤:
 *      a.定义一个静态方法，把需要简化的代码放到一个静态方法中去。
 * 静态方法引用的注意事项
 *      ”重要:被引用的方法的参数列表要和函数式接口中的抽象方法的参数列表一致。"
 *      如果函数式接口中的抽象方法有返回值，则被引用的方法必须也有相同的返回值
 *      如果函数式接口中的抽象方法没有返回值，则被引用的方法可以有返回值，也可以没有返回值
 *
 * 2.实例方法的引用
 * 格式:
 *      对象::实例方法。
 * 简化步骤:
 *      a.定义一个实例方法，把需要的代码放到实例方法中去。
 * 实例方法引用的注意事项
 *      ”重要:被引用的方法的参数列表要和函数式接口中的抽象方法的参数列表一致。"
 *
 * 3.特定类型方法的引用
 * 特定类型:
 *      string ,任何类型。
 * 格式:
 *      特定类型::方法。
 * 注意:
 *      如果第一个参数列表中的形参中的第一个参数作为了后面的方法的调用者，
 *      并且其余参数作为后面方法的形参，那么就可以用特定类型方法引用了。
 *
 * 4.构造器引用。
 * 格式是:
 *      类名::new
 * 注意点:
 *      前后参数一致的情况下，又在创建对象就可以使用构造器引用
 *      s -> new student(s) => student::new
 *
 * 小结:
 *      方法引用是可遇不可求，能用则用，不能用就不要用!
 */
public class TestMethodReferences {
    public static void main(String[] args) {
        List<String>lists = new ArrayList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        lists.add("4");
        lists.forEach(s-> System.out.println(s));
        /* 方法引用,实例方法 */
        lists.forEach(System.out::println);


        List<TestLambda.Student>list = new ArrayList<>();
        TestLambda.Student s1 = new TestLambda.Student(20,"张三");
        TestLambda.Student s2 = new TestLambda.Student(19,"里斯");
        TestLambda.Student s3 = new TestLambda.Student(21,"网无");
        Collections.addAll(list,s1,s2,s3);
        /* 静态方法的引用 */
        list.sort(((o1, o2) -> Student.compareByAge(o1, o2)));   // 简化前
        // 如果前后参数一样,而且是静态方法,可以使用静态方法引用
        list.sort(Student::compareByAge);

        /* 特定类型方法的引用 */
        String[] strs = {"James","A","John","Dlei","Boom","bzz"};
        // 按照元素的首字符(忽略大小写)升序排序
        /*Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);  // 忽略大小写,升序
            }
        });*/
        Arrays.sort(strs,(o1,o2)->o1.compareToIgnoreCase(o2));  // 简化
        /* 特定类型的方法引用 */
        Arrays.sort(strs,String::compareToIgnoreCase);

        System.out.println(Arrays.toString(strs));

        /* 构造器引用 */
        // 实例:指定转化成字符串类型的数组(可以使用构造器引用实现)
        /*String[] strings = lists.toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });*/
        // 简化
        String[] strings = lists.toArray(String[]::new);
        System.out.println(Arrays.toString(strings));



    }

    static class Student{
        private int age;
        private String name;

        public static int compareByAge(TestLambda.Student o1, TestLambda.Student o2) {
            return o1.getAge() - o2.getAge();
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return ""+this.name+":"+this.age;
        }

    }
}
