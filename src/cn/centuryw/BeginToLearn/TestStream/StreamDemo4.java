package cn.centuryw.BeginToLearn.TestStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 收集stream流:把stream流的数据转回成集合
 * 引入:
 * stream的作用是:把集合转换成一根传送带，借用stream流的强大功能进行的操作。
 * 但是实际开发中数据最终的形式还是应该是集合，最终stream流操作完毕以后还是要转换成集合。
 * 这就是收集stream流。
 * stream流:手段
 * 集合:才是目的。
 * 流:只能使用一次
 */
public class StreamDemo4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        // 筛选
        Stream<String> streamResult = list.stream().filter(s -> s.length() == 3).filter(s -> s.startsWith("张"));
        // 把stream流转换成set集合
        Set<String> sets = streamResult.collect(Collectors.toSet());
        System.out.println(sets);
        // 把stream流转换成List集合
        Stream<String> streamResult2 = list.stream().filter(s -> s.length() == 3).filter(s -> s.startsWith("张"));
        List<String>lists = streamResult2.collect(Collectors.toList());
        System.out.println(lists);
        // 把stream流转换成数组
        Stream<String> streamResult3 = list.stream().filter(s -> s.length() == 3).filter(s -> s.startsWith("张"));
        String[] array = streamResult3.toArray(String[]::new);
        System.out.println(Arrays.toString(array));

    }
}
