package cn.centuryw.BeginToLearn.ConcurrencyPackage;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 并发包的介绍。(面试的重点中的重点)
 *
 * 并发包的来历:
 *      在实际开发中如果不需要考虑线程安全问题，大家不需要做线程安全，因为如果做了反而性能不好!
 *      但是开发中有很多业务是需要考虑线程安全问题的，此时就必须考虑了。否则业务出现问题
 *      Java为很多业务场景提供了性能优异，且线程安全的并发包，程序员可以选择使用!
 *
 * Map集合中的经典集合:HashMap它是线程不安全的，性能好
 *      --如果在要求线程安全的业务情况下就不能用这个集合做Map集合，否则业务会崩溃~
 * 为了保证线程安全，可以使用Hashtable。注意:线程中加入了计时
 *      -- Hashtable是线程安全的Map集合，但是性能较差!(已经被淘汰了，虽然安全，但是性能差)
 * 为了保证线程安全，再看concurrentHashMap(不止线程安全，而且效率高，性能好，最新最好用的线程安全
 *      -- concurrentHashMap保证了线程安全，综合性能较好!
 */
public class TestConcurrentHashMap {
    static Map<String,String> hashMap = new HashMap<>();
    static Map<String,String> hashTable = new Hashtable<>();
    static Map<String,String> concurrentHashMap  = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        // 演示HashMap在高并发下的线程不安全性。
        System.out.println("HashMap:");
        Runnable task1 = new MyRunnable(hashMap);
        TestHash(task1,hashMap);
        // 测试Hashtable
        System.out.println("Hashtable:");
        Runnable task2 = new MyRunnable(hashTable);
        TestHash(task2,hashTable);
        // 测试concurrentHashMap
        System.out.println("concurrentHashMap:");
        Runnable task3 = new MyRunnable(concurrentHashMap);
        TestHash(task3,concurrentHashMap);
    }



    static void TestHash(Runnable runnable,Map<String,String> map){
        // 向hashMap中添加100万个元素
        Thread t1 = new Thread(runnable,"线程1");
        Thread t2 = new Thread(runnable,"线程2");

        // 计时开始
        long startTime = new Date().getTime();


        t1.start();
        t2.start();

        // 让t1和t2跑完,主线程不能竞争其CPU
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 计时结束
        long endTime = new Date().getTime();
        // 等两个线程执行完毕后获取集合最终元素个数
        System.out.println("元素个数:"+map.size()+"\t运行时间(ms):"+(endTime-startTime));
    }

    static class MyRunnable implements Runnable{
        private Map<String,String> map = null;

        MyRunnable(Map<String,String> map){
            this.map = map;
        }
        /**
         * 任务:向map中添加50万个元素
         */
        @Override
        public void run() {
            for (int i=0;i<500000;i++){
                map.put(Thread.currentThread().getName()+i,i+"");
            }
        }
    }
}
