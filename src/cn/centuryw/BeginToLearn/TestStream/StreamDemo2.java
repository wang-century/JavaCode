package cn.centuryw.BeginToLearn.TestStream;

import java.util.*;
import java.util.stream.Stream;

/**
 * strean流的获取
 *
 * stream流式思想的核心:
 *      先得到集合或者数组的stream流（就是一根传送带）
 *      然后就用这个stream流操作集合或者数组的元素。
 *      然后用stream流简化替代集合操作的API.
 *
 * 集合获取流的API:
 *      (1) default Stream<E>stream();
 *
 * 小结:
 *      集合获取stream流用stream();
 *      数组:Arrays.stream数组)
 *      stream.of(数组);
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        // collection集合如何获取stream流
        Collection<String> c = new ArrayList<>();
        Stream<String> ss = c.stream();
        // Map集合获取流
        Map<String,Integer> map = new HashMap<>();
        // 先获取键的stream流
        Stream<String> keyss = map.keySet().stream ( ) ;
        // 再获取值的stream流
        Stream<Integer> valuess = map.values ().stream ( );
        // 获取键值对的stream流(key=value:Map.Entry<string,Integer>)
        Stream<Map.Entry<String,Integer>> keyAndValues = map.entrySet().stream();

        // 数组也有stream流
        String[] arrs = new String[] { "Java","JavaEE" ,"Spring Boot"};
        Stream<String> arrsss1 = Arrays.stream(arrs);
        Stream<String> arrsss2 = Stream.of(arrs);

    }
}
