package cn.centuryw.BeginToLearn.TestStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 什么是stream流?
 *      在Java 8中，得益于Lambda所带来的函数式编程，
 *      引入了一个全新的stream流概念，用于解决已有集合/数组类库既有的弊端。
 * stream流能解决什么问题?
 *      可以解决已有集合类库或者数组API的弊端。
 *      stream认为集合和数组操作的API很不好用，所以采用了stream流简化集合和数组的操作!
 *
 * 小结:
 * stream流的核心思想:把集合或者数组转成一个stream流（传送带）
 * 然后使用stream流的强大功能进行元素的处理!
 */
public class StreamDemo1 {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        list.add ("张无忌");
        list.add("周芷若");
        list.add ("赵敏");
        list.add("张强");
        list.add ("张三丰");
        /* 需求:从集合中筛选出所有姓张的人,再找出姓名长度是3的人 */
        // 原方法
        //test1();
        // 使用stream流
        list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(System.out::println);

    }

    /**
     * 需求:从集合中筛选出所有姓张的人,再找出姓名长度是3的人
     */
    static void test1(){
        // 找出姓张的人
        List<String> zhangList = new ArrayList<>();
        for (String s:list){
            if (s.startsWith("张")){
                zhangList.add(s);
            }
        }
        // 找出姓名长度为3的人
        List<String> length3list = new ArrayList<>();
        for (String s:zhangList){
            if (s.length()==3){
                length3list.add(s);
            }
        }
        System.out.println(zhangList);
        System.out.println(length3list);
    }


}
