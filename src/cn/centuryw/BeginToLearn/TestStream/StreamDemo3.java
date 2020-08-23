package cn.centuryw.BeginToLearn.TestStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * stream流的常用API
 *      forEach:    逐一处理(遍历)
 *      count:      统计个数
 *                      -- long count();
 *      filter :    过滤元素
 *                      -- stream<T> filter(Predicate<? super T> predicate)
 *      limit:      取前几个元素
 *      skip:       跳过前几个
 *      map:        加工方法(映射,把原来的元素加工以后重新放上去)
 *      concat:     合并流
 *
 * 终结与非终结方法。
 *      终结方法:一旦stream调用了终结方法，流的操作就全部终结了，不能继续使用，
 *              只能创建新的Stream操作。
 *      终结方法:foreach, count
 *      非终结方法:每次调用完成以后返回一个新的流对象，
 *              可以继续使用，支持链式编程!
 */
public class StreamDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add ("张无忌");
        list.add("周芷若");
        list.add ("赵敏");
        list.add("张强");
        list.add ("张三丰");
        // 筛选
        list.stream().filter(s->s.length()==3).filter(s->s.startsWith("张")).forEach(System.out::println);

        // 统计个数
        long count = list.stream().filter(s->s.length()==3).filter(s->s.startsWith("张")).count();
        // 取前1个输出
        list.stream().filter(s->s.length()==3).filter(s->s.startsWith("张")).limit(1).forEach(System.out::println);
        // 跳过前1个输出
        list.stream().filter(s->s.length()==3).filter(s->s.startsWith("张")).skip(1).forEach(System.out::println);
        // map加工:在所有名字前加"员工:"
        list.stream().map(s->"员工:"+s).forEach(System.out::println);
        // 把所有元素加工成学生对象
        list.stream().map(Student::new).forEach(System.out::println);
        // 合并流
        Stream<Integer> s1 = Stream.of(10,30,40,50);
        Stream<String> s2 = list.stream();
        Stream<Object> s3 = Stream.concat(s1,s2);
        s3.forEach(System.out::println);

    }
    static class Student{
        private String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student:"+this.name;
        }
    }
}
