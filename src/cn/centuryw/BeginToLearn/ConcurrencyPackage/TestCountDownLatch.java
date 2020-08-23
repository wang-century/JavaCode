package cn.centuryw.BeginToLearn.ConcurrencyPackage;

import java.util.concurrent.CountDownLatch;

/**
 * countDownLatch的使用(了解)
 *      countDownLatch允许一个或多个线程等待其他线程完成操作，再执行自己。
 *      例如:线程1要执行打印:A和c，
 *          线程2要执行打印:B，但线程1在打印A后，要线程2打印B之后才能打印c，
 *          所以:线程1在打印A后，必须等待线程2打印完B之后才能继续执行
 *
 * 需求:
 *      提供A线程，打印A , c
 *      提供B线程，打印B
 *
 * 构造器:
 *      public countDownLatch(int count)//初始化唤醒需要的down几步。
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        // 创建CountDownLatch对象用于监督A,B线程
        CountDownLatch countDownLatch = new CountDownLatch(1);
        // 启动线程A
        new ThreadA(countDownLatch).start();
        // A等待自己
        new ThreadB(countDownLatch).start();

    }


}

class ThreadA extends Thread{
    private final CountDownLatch countDownLatch;

    public ThreadA(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run(){
        System.out.println("A");
        try {
            // 让当前线程让出CPU,等待自己
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("C");
    }
}

class ThreadB extends Thread{
    private final CountDownLatch countDownLatch;

    public ThreadB(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run(){
        System.out.println("B");
        // 让监督者中计算器-1,唤醒被等待的线程
        countDownLatch.countDown();
    }
}