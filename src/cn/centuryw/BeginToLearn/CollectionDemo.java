package cn.centuryw.BeginToLearn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *      collection集合的遍历方式。
 * 什么是遍历?为什么开发中要遍历?
 * 遍历就是一个一个的把容器中的元素访问一遍。
 * 开发中经常要统计元素的总和，找最值，找出某个数据然后干掉等等业务都需要遍历。
 *
 * collection集合的遍历方式是全部集合都可以直接使用的
 *      collection集合的遍历方式有三种:
 * (1）迭代器。
 * (2）foreach(增强for循环)。
 * (3） JDK 1.8开始之后的新技术Lambda表达式。
 * a.迭代器遍历集合。
 *      public Iterator iterator():获取集合对应迭代器
 *      hasNext():  是否有下一个值
 *      next():     获取下一个值
 * b.foreach遍历集合
 *      foreach是一种遍历形式，可以遍历集合或者数组。
 *      foreach遍历集合实际上是迭代器遍历的简化写法。
 *      foreach遍历的关键是记住格式:
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> lists = new ArrayList<>();
        lists.add("张三");
        lists.add("里斯");
        lists.add("网无");

        // 1.获取集合对应迭代器
        Iterator<String> it = lists.iterator();
        // 2.循环获取（是否存在下一个元素）
        while (it.hasNext()){
            System.out.println(it.next());
        }

        // foreach
        for (String value:lists){
            System.out.println(value);
        }

        // lambda
        lists.forEach(s->{
            System.out.println(s);
        });
        lists.forEach(s-> System.out.println(s));
        lists.forEach(System.out::println);

    }



}
