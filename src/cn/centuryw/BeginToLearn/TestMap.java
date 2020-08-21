package cn.centuryw.BeginToLearn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map集合的特点:
 * 1.Map集合的特点都是由键决定的。
 * 2.Map集合的键是无序，不重复的，无索引的。
 * Map集合后面重复的键对应的元素会覆盖前面的整个元素!
 * 3.Map集合的值无要求。
 * 4.Map集合的键值对都可以为null。
 * HashMap:元素按照键是无序，不重复，无索引，值不做要求。
 * LinkedHashMap:元素按照键是有序，不重复，无索引，值不做要求。Map集合的特点:
 * 1.Map集合的特点都是由键决定的。
 * 2.Map集合的键是无序，不重复的，无索引的。
 * Map集合后面重复的键对应的元素会覆盖前面的整个元素!
 * 3.Map集合的值无要求。
 * 4.Map集合的键值对都可以为null。
 * HashMap:元素按照键是无序，不重复，无索引，值不做要求。
 * LinkedHashMap:元素按照键是有序，不重复，无索引，值不做要求。
 *
 *      Map集合的常用API(重点)
 * - public v put(K key,v value)            把指定的键与指定的值添加到Map集合中。
 * - public v get(object key)               根据指定的键，在Map集合中获取对应的值。
 * - public set<K>keyset()                  获取Map集合中所有的键，存储到set集合中。
 * - public boolean containKey(object key)  判断该集合中是否有此键。
 * - public set<Map.Entry<K,V>> entryset()  获取到Map集合中所有的键值对对象的集合(set集合)
 * - pubic v remove(Object key)             把指定的键所对应的键值对元素在Map集合中删除，返回被删除元素
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String,Integer> maps = new HashMap<>();
        maps.put("手机",2000);
        maps.put("饮料",3);
        maps.put(null,null);
        System.out.println(maps);

        // 清空
        //maps.clear();
        //System.out.println(maps);

        // 判断是否为空
        System.out.println(maps.isEmpty());

        // 根据键获取值
        Integer value = maps.get("手机");
        System.out.println(value);

        // 根据键删除键值
        maps.remove("手机");
        System.out.println(maps);

        // 判断是否包含
        System.out.println(maps.containsKey("饮料"));
        System.out.println(maps.containsValue(3));

        // 获取所有键集合
        System.out.println(maps.keySet());

        // 获取所有值集合
        System.out.println(maps.values());

        // 获取所有键值集合
        Set<Map.Entry<String,Integer>> entries = maps.entrySet();
        for (Map.Entry<String,Integer> entry:entries){
            String k = entry.getKey();
            Integer v = entry.getValue();
        }
        System.out.println(maps.entrySet());

        // 集合大小
        System.out.println(maps.size());

        // 合并集合
        Map<String,Integer>maps2 = new HashMap<>();
        maps2.put("小米",3);
        maps2.put("手表",3);
        maps.putAll(maps2);     // 将maps2数据全部倒入maps
        System.out.println(maps);


        // 遍历集合
        // 1.
        maps.forEach((k,v)->{
            System.out.println(k+"->"+v);
        });
        // 2.
        maps.forEach((k,v)-> System.out.println(k+"->"+v));

        // 存储自定义类型
        Oriange o1 = new Oriange("黄",20.3);
        Oriange o2 = new Oriange("绿",19.5);
        Oriange o3 = new Oriange("红",9.9);
        Map<Integer,Oriange>maps3 = new HashMap<>();
        maps3.put(1,o1);
        maps3.put(2,o2);
        maps3.put(3,o3);
        maps3.forEach((k,v)-> System.out.println("编号："+k+" 橘子："+v));

        /* 小案例：输出一个字符串中每个字符出现的次数　*/
        Map<Character,Integer>wordsCount = new HashMap<>();
        String words = "Hello Lucy, I'm Jake. How are you? I miss you.";
        for (int i=0;i<words.length();i++){
            Character word = words.charAt(i);
            // 如果map集合中包含该字符，次数＋１
            if(wordsCount.containsKey(word)){
                Integer count = wordsCount.get(word);   // 获取次数
                wordsCount.put(word,count+1);   //　次数+1
            }else{
                wordsCount.put(word,1);
            }
        }
        System.out.println(wordsCount);


    }
}

