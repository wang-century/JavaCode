package cn.centuryw.BeginToLearn.ConcurrencyPackage;

import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * semaphore的使用
 *
 * 引入:
 * semaphore（发信号）的主要作用是控制线程的并发占锁数量。
 * synchronized可以起到"锁"的作用，但某个时间段内，只能有一个线程允许执行。
 * semaphore可以设置同时允许几个线程执行。
 * semaphore字面意思是信号量的意思，它的作用是控制访问特定资源的线程数目。
 * semaphore的构造器:
 * public semaphore(int permits):permits表示许可线程的数量
 * public semaphore(int permits，boolean fair): fair表示公平性,若为true,则下一次等待最久的线程先执行
 * semaphore的方法:
 *      public void acquire() throws InterruptedException表示获取许可
 *      public void release()release()表示释放许可
 */
public class TestSemaphore {
    public static void main(String[] args) {
        Service service = new Service();
        for (int i=0;i<5;i++){
            MyThread a = new MyThread(service);
            a.start();
        }
    }
}

class Service{
    // 1表示许可的意思,表示最多允许1个线程执行acquire()和release()之间的内容
    private final Semaphore semaphore = new Semaphore(1);

    /**
     * 登录
     */
    public void login(){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+" 进入时间"+System.currentTimeMillis());
            try {
                Thread.sleep(1000);
                System.out.println("登录成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"离开时间"+System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread{
    private final Service service;

    public MyThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.login();
    }
}
