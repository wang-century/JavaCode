package cn.centuryw.BeginToLearn.ThreadPools;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *      什么是线程池。
 * 线程池:其实就是一个容纳多个线程的容器，其中的线程可以反复的使用，
 *       省去了频繁创建和销毁线程对象的操作，无需反复创建线程而消耗过多资源。
 * 为什么要用线程池:
 *      合理利用线程池能够带来三个好处
 *          1.降低资源消耗。
 *              --减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务。
 *          2.提高响应速度
 *              --不需要频繁的创建线程，如果有线程可以直接用，不会出现系统僵死!
 *          3.提高线程的可管理性（线程池可以约束系统最多只能有多少个线程，不会因为线程过多而死机）
 *
 * 线程池的核心思想:线程复用，同一个线程可以被重复使用，来处理多个任务。
 *
 *
 *      创建一个线程池。
 * 线程池在Java中的代表类:Executorservice(接口)。
 * Java在Executors类下提供了一个静态方法得到一个线程池的对象:
 * 1.public static Executorservice newFixedThreadPool(int nThreads):
 *      创建一个线程池返回。
 * Executorservice提交线程任务对象执行的方法:
 * 1.Future<?> submit(Runnable task):提交一个Runnable的任务对象给线程池执行。
 * 2.Future<?> submit(Callable task):提交一个Callable的任务对象给线程池执行。
 *
 *
 * java死锁产生的四个必要条件:
 *      1、互斥使用，即当资源被一个线程使用(占有)时，别的线程不能使用。
 *      2、不可抢占，资源请求者不能强制从资源占有者手中夺取资源，资源只能由资源占有者主动释放。
 *      3、请求和保持，即当资源请求者在请求其他的资源的同时保持对原有资源的占有。
 *      4、循环等待，即存在一个等待循环队列: p1要p2的资源，p2要p1的资源。这样就形成了一个等待环
 * 当上述四个条件都成立的时候，便形成死锁。当然，死锁的情况下如果打破上述任何一个条件，便可让死锁消失
 */

public class ThreadPoolsDemo1 {
    public static void main(String[] args) {
        // 创建一个线程池，指定线程的固定数量是3
        ExecutorService pools = Executors.newFixedThreadPool(3);
        // 添加线程任务
        Runnable target = new MyRunnable();
        pools.submit(target);   //第1次提交任务，此时线程池创建新线程，自动触发执行
        pools.submit(target);   //第2次提交任务，此时线程池创建新线程，自动触发执行
        pools.submit(target);   //第3次提交任务，此时线程池创建新线程，自动触发执行
        pools.submit(target);   //第4次提交任务，复用之前的线程。
        //pools.shutdown();       //等待任务执行完毕以后才会关闭线程池
        //pools.shutdownNow(); //立即关闭线程池的代码，无论任务是否执行完毕!


        //　线程池任务
        Future<String>t1 = pools.submit(new MyCallable(100));
        Future<String>t2 = pools.submit(new MyCallable(200));
        Future<String>t3 = pools.submit(new MyCallable(300));

        // 获取线程池执行结果
        try {
            String resu1 = t1.get();
            String resu2 = t2.get();
            String resu3 = t3.get();
            System.out.println(resu1);
            System.out.println(resu2);
            System.out.println(resu3);
        }catch (Exception e){
            e.printStackTrace();
        }


        pools.shutdown();       //等待任务执行完毕以后才会关闭线程池
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}


class MyCallable implements Callable<String>{
    private final int n;

    public MyCallable(int n) {
        this.n = n;
    }

    // 需求：使用线程池，计算出1-100,1-200,1-300的和并返回
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i=1;i<=n;i++){
            sum += i;
        }
        return Thread.currentThread().getName()+"1-"+n+"累加和结果为"+sum;
    }
}