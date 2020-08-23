package cn.centuryw.BeginToLearn.ConcurrencyPackage;

import java.util.concurrent.CyclicBarrier;

/**
 * cyclicBarrier
 * cyclicBarrier作用:
 *      某个线程任务必须等待其他线程执行完毕以后才能最终触发自己执行。
 *
 * 例如:公司召集5名员工开会，等5名员工都到了，会议开始。
 *      我们创建5个员工线程，1个开会任务，几乎同时启动
 *      使用cyclicBarrier保证5名员工线程全部执行后，再执行开会线程。
 *
 * 构造器:
 *      public cyclicBarrier(int parties，Runnable barrierAction)
 * 方法:
 *      public int await()
 *      //每个线程调用await方法告诉cyclicBarrier我已经到达了屏障，然后当前线程被回收
 *      //用于在线程到达屏障5时，优先执行barrieraction，方便处理更复杂的业务场景
 */
public class TestCyclicBarrier {
    public static void main(String[] args) {
        // 创建循环屏障对象,等5个线程执行完毕后触发任务
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,new Meeting());
        for (int i=0;i<5;i++){
            new EmployeeThread("员工"+i,cyclicBarrier).start();
        }

    }
}

/**
 * 员工线程
 */
class EmployeeThread extends Thread{
    private final CyclicBarrier cyclicBarrier;

    public EmployeeThread(String name,CyclicBarrier cyclicBarrier){
        super(name);
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(3000); // 等待3秒
            System.out.println(Thread.currentThread().getName()+"已进入会议室...");
            cyclicBarrier.await();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }
}

class Meeting implements Runnable{
    @Override
    public void run() {
        System.out.println("开始会议...");
    }
}
