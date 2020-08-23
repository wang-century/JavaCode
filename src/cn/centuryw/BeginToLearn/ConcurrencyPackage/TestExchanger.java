package cn.centuryw.BeginToLearn.ConcurrencyPackage;

import java.util.concurrent.Exchanger;

/**
 * Exchanger
 * 作用
 *      Exchanger（交换者）是一个用于线程间协作的工具类。Exchanger用于进行线程问的数据交换。
 *      两个线程通过exchange方法交换数据，如果第一个线程先执行exchange()方法，它会一直等待第二个线程也执行exchange方法,当
 *          两个线程都达到同步点时,这两个线程就可以交换数据,将本线程生产出来的数据传递给对方
 * Exchanger构造方法:
 *      public Exchanger()
 * Exchanger重要方法:
 *      public v exchange(v x)
 * 分析:
 *      (1）需要2个线程
 *      (2）需要一个交换对象负责交换两个线程执行的结果。
 *
 * 总结:
 *      Exchanger可以实现线程间的数据交换。
 *      一个线程如果等不到对方的数据交换就会一直等待。
 *      我们也可以控制一个线程等待的时间。
 *      必须双方都进行交换才可以正常进行数据的交换。
 */
public class TestExchanger {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Boy(exchanger).start();
        new Girl(exchanger).start();
        // 交换结果


    }
}

class Boy extends Thread{
    private final Exchanger<String> exchanger;
    public Boy(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("男孩开始做好自己的信物");
            String res = exchanger.exchange("同心锁");
            System.out.println("男孩收到信物:"+res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Girl extends Thread{
    private final Exchanger<String> exchanger;
    public Girl(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("女孩开始做好自己的信物");
            String res = exchanger.exchange("钥匙");
            System.out.println("女孩收到信物:"+res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


