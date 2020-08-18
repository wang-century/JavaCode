package cn.centuryw.BeginToLearn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 目标:collection集合概述。
 * 什么是集合?
 * 集合是一个大小可变的容器。
 * 容器中的每个数据称为一个元素。数据==元素。
 * 数组:类型和长度一旦定义出来就都固定了。
 * 集合有啥用?
 *      在开发中，很多时候元素的个数是不确定的。
 *      而且经常要进行元素的增删该查操作，集合都是非常合适的。
 *      开发中集合用的更多!!
 *
 * Java中集合的代表是:collection.
 * collection集合是Java中集合的祖宗类。
 * 学习collection集合的功能，那么一切集合都可以用这些功能!!
 * 集合的特点是:类型可以不确定，大小不固定。集合有很多种，不同的集合特点和使用场景不同。
 *
 *      集合的特点:
 * set系列集合:添加的元素是无序，不重复，无索引的。
 * --Hashset:添加的元素是无序，不重复，无索引的。
 * -- LinkedHashset:添加的元素是有序，不重复，无索引的。
 * -— Treeset:按照大小默认升序排序!!
 * List系列集合:添加的元素是有序，可重复，有索引。
 * -- ArrayList:添加的元素是有序，可重复，有索引。
 * -- LinekdList:添加的元素是有序，可重复，有索引。
 *
 *      collection集合的常用API.
 * collection是集合的祖宗类，它的功能是全部集合|都可以继承使用的，所以要学习它。
 *      collection API如下:
 * - public boolean add(E e):               把给定的对象添加到当前集合中。
 * - public void clear():                   清空集合中所有的元素。
 * - public boolean removeE e):             把给定的对象在当前集合中删除。
 * - public boolean contains(object obj):   判断当前集合中是否包含给定的对象。
 * - public boolean isEmpty():              判断当前集合是否为空。
 * - public int size():                     返回集合中元素的个数。
 * - public object[] toArray():             把集合中的元素，存储到数组中
 */
public class TestCollection {
    public static void main(String[] args) {
        // 多态写法
        // HashSet  无序、不重复、无索引
        Collection<String>sets = new HashSet<>();
        sets.add("Java");
        sets.add("Python");
        sets.add("Cpp");
        System.out.println(sets);

        // ArrayList:有序、可重复、有索引
        Collection<String>lists = new ArrayList<>();
        lists.add("Java");
        lists.add("Python");
        lists.add("Cpp");
        System.out.println(lists);

    }


}
