package cn.centuryw.BeginToLearn;

import java.text.CollationElementIterator;
import java.util.*;

/**
 *      collections工具类的使用。
 * java.utils.collections:是集合工具类
 * collections并不属于集合，是用来操作集合的工具类。
 *      collections有几个常用的API:
 * - public staticT> boolean addAll(collection<? super T> c，T... elements)      给集合对象批量添加元素!
 * - public static void shuffle(List<?> list)                               打乱集合顺序(只能打乱有序的List集合)
 * - public static <T>void sort(List<T>list，comparator<? super T>)         将集合中元素按照指定规则排序
 * - public static <T> void sort(List<T> list):将集合中元素按照默认规则排序
 */
public class TestCollections {
    public static void main(String[] args) {
        Collection<String>names = new ArrayList<>();
        // 批量添加元素
        Collections.addAll(names,"曹操","张三","李四","网无");
        System.out.println(names);

        List<String> names2 = new ArrayList<>();
        Collections.addAll(names2,"曹操","张三","李四","网无");
        System.out.println(names2);
        // 打乱顺序
        Collections.shuffle(names2);
        System.out.println(names2);

        // 默认排序
        List<Double> scores = new ArrayList<>();
        Collections.addAll(scores,98.5,55.5,59.4,88.5);
        System.out.println(scores);
        Collections.sort(scores);
        System.out.println(scores);

        // 指定规则排序
        List<Oriange>orianges = new ArrayList<>();
        orianges.add(new Oriange("红色",20.3));
        orianges.add(new Oriange("蓝色",19.44));
        orianges.add(new Oriange("绿色",30.3));
        Collections.sort(orianges); // 方式1
        // 方式2
        Collections.sort(orianges, new Comparator<Oriange>() {
            @Override
            public int compare(Oriange o1, Oriange o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        System.out.println(orianges);

    }

}

class Oriange implements Comparable<Oriange>{
    private final double price;

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    private final String color;

    public Oriange(String color,double price){
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "颜色："+this.color+" 价格："+this.price;
    }

    @Override
    public int compareTo(Oriange o) {
        return Double.compare(this.price, o.price);
    }
}