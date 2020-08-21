package cn.centuryw.BeginToLearn;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *      线程的概述。（并发编程）
 * 什么是进程?
 *      程序是静止的，运行中的程序就是进程。
 * 进程的三个特征:
 *      1.动态性:进程是运行中的程序，要动态的占用内存，CPU和网络等资源。
 *      2.独立性:进程与进程之间是相互独立的，彼此有自己的独立内存区域。
 *      3.并发性:假如CPU是单核，同一个时刻其实内存中只有一个进程在被执行。
 *              CPU会分时轮询切换依次为每个进程服务，因为切换的速度非常
 *              快，给我们的感觉这些进程在同时执行，这就是并发性。
 *
 * 并行:同一个时刻同时有多个在执行。
 *
 * 什么是线程?
 *      线程是属于进程的。一个进程可以包含多个线程，这就是多线程。
 *      线程创建开销相对于进程来说比较小。
 *      线程也支持并发性。
 *
 *      线程的作用:
 * 可以提高程序的效率，线程也支持并发性，可以有更多机会得到cPU。
 * 多线程可以解决很多业务模型。
 * 大型高并发技术的核心技术。
 * 设计到多线程的开发可能都比较难理解。
 *
 *
 *      线程的创建方式一
 * 多线程是很有用的，我们在进程中创建线程的方式有三种:
 *      (1）直接定义一个类继承线程类Thread，重写run()方法，创建线程对象
 *          调用线程对象的start()方法启动线程。
 *      (2）定义一个线程任务类实现Runnable接口，重写run()方法，创建线程任务对象，把
 *          线程任务对象包装成线程对象，调用线程对象的start()方法启动线程。
 *      (3）实现callable接口（拓展）。
 *
 * a.继承Thread类的方式
 * -- 1.定义一个线程类继承Thread类。
 * -- 2.重写run()方法
 * -- 3.创建一个新的线程对象。
 * -- 4.调用线程对象的start()方法启动线程。
 *
 * b.实现Runnable接口的方式。
 * -- 1.创建一个线程任务类实现Runnable接口。
 * -- 2.重写run ()方法
 * -- 3.创建一个线程任务对象。
 * -- 4;把线程任务对象包装成线程对象
 * -- 5.调用线程对象的start()方法启动线程。
 *
 * c.实现callable接口。
 * -- 1,定义一个线程任务类实现callable接口，申明线程执行的结果类型。
 * -- 2,重写线程任务类的call方法，这个方法可以直接返回执行的结果。
 * -- 3,创建一个callable的线程任务对象。
 * -- 4，把callable的线程任务对象包装成一个未来任务对象。
 * -- 5.把未来任务对象包装成线程对象。
 * -- 6.调用线程的start()方法启动线程
 *
 * 继承Thread类的优缺点:
 *      优点:编码简单。
 *      缺点:线程类已经继承了Thread类无法继承其他类了，功能不能通过继承拓展（单继承的缺点)
 *
 * Runnable接口创建线程的优缺点:
 *      缺点:代码复杂一点。
 *      优点:
 *          线程任务类只是实现了Runnable接口，可以继续继承其他类，而且可以继续实现其他接口
 *          同一个线程任务对象可以被包装成多个线程对象
 *          适合多个线程去共享同一个资源
 *          增加和序的健壮性，实现解耦操作，代码可以被多个线程共享，代码和线程独立。
 *          线程池可以放入实现Runable或callable线程任务对象。
 *          注意:其实Thread类本身也是实现了Runnable接口的。
 *
 * 实现Callable接口优缺点:
 * 优点:全是优点。
 *      --线程任务类只是实现了callable接口，可以继续继承其他类，同时可以继续实现其
 *      --一个线程任务对象可以被共享成多个线程对象。适合做多线程的资源共享操作。
 *      --很适合做线程池的执行任务。
 *      --可以直接获取线程执行的结果。
 * 缺点:编码复杂。
 *
 * 线程的注意事项。
 *      线程的启动必须调用start()方法。否则当成普通类处理。
 *      -- start()方法底层其实是给CPU注册当前线程，并且触发run()方法执行
 *      建议线程先创建子线程，主线程的任务放在之后。
 *      如果线程直接调用run()方法，相当于变成了普通类的执行，此时将只有主线程在执行他们
 *
 *
 *      线程的常用API
 * Thread类的API:
 *      1.public void setName (string name):给当前线程取名字。
 *      2.public void getName ():获取当前线程的名宁E
 *          --线程存在默认名称，子线程的默认名称是:Thread-索引。
 *          --主线程的默认名称就是:main
 *      3.public static Thread currentThread()
 *          --获取当前线程对象，这个代码在哪个线程中，就得到哪个线程对象。
 *      4.public static void sleep(long time):
 *          --让当前线程休眠多少毫秒。
 *
 *
 *      目标:线程安全问题。
 * 线程安全问题:多个线程操作同一个共享资源的时候可能会出现线程安全问题。
 *
 * 模拟出取款问题的案例:
 * 注意:用高度面向对象的思想设计。
 *      分析:
 *      (1）提供一个账户类Account.java作为创建共享资源账户对象的类。
 *      (2）定义一个线程来用于创建2个线程分别代表小明和小红来取钱。
 *
 */
public class TestMultithreading {
    // 启动后的TestMultithreading当成一个进程。
    // main方法是由主线程执行的，理解成main方法就是一个主线程
    public static void main(String[] args) {
        /* 线程的创建 */
        //create_thread();
        /* 线程安全问题：取款问题 */
        // 1.创建一个共享资源账户对象
        Account acc = new Account("ICBC-1101",100000);
        // 2.创建两个线程对象进行取钱操作
        Thread person_1 = new DrawThread(acc,"小明");
        person_1.start();
        Thread person_2 = new DrawThread(acc,"小红");
        person_2.start();
        //





    }

    /**
     * 线程的创建
     */
    static void create_thread(){
        /* 方式ａ　*/
        // 3.创建线程对象
        Thread t1 = new MyThread("１号");
        Thread t2 = new MyThread("2号");
        // 4.调用线程对象的start()方法启动线程。
        t1.start();
        t2.start();

        /* 方式ｂ */
        // 3.创建一个线程任务对象(注意：线程任务对象不是线程对象，只是执行线程的任务的)
        Runnable runnable = new MyRunnable();
        // 4.把线程任务对象包装成线程对象
        // Thread t3 = new Thread(runnable);
        Thread t3 = new Thread(runnable,"runnable线程");
        // 5.调用线程对象的start()方法启动线程。
        t3.start();

        /* 方式ｂ的匿名内部类写法(简化写法) */
        Runnable runnable1 = new MyRunnable(){
            @Override
            public void run(){
                for (int i=0;i<3;i++){
                    System.out.println("子线程"+Thread.currentThread().getName()+"输出:"+i);
                }
            }
        };
        // 或者
        new Thread(new MyRunnable(){
            @Override
            public void run(){
                for (int i=0;i<3;i++){
                    System.out.println("子线程"+Thread.currentThread().getName()+"输出:"+i);
                }
            }
        }).start();


        /* c.实现callable接口 */
        // 3,创建一个callable的线程任务对象。
        Callable<String> call = new MyCallable();
        // 4.把callable的线程任务对象包装成一个未来任务对象(未来任务对象就是一个Runnable对象)
        FutureTask<String> task = new FutureTask<>(call);
        // 5.把未来任务对象包装成线程对象。
        Thread t4 = new Thread(task);
        // 6.调用线程的start()方法启动线程
        t4.start();


        // 获取主线程对象
        Thread mainThread = Thread.currentThread();
        mainThread.setName("最强主线程");

        // 主线程任务
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+"输出:"+(i+5));
        }

        // 7.在最后去获取线程执行的结果,如果线程没有结果﹐让出CPU等线程执行完再来取结果
        try {
            String rs = task.get(); // 获取call方法返回的结果(正常/异常结果)
            System.out.println("ｃａｌｌａｂｌｅ执行结果："+rs);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


/**
    a.继承Thread类的方式
 * -- 1.定义一个线程类继承Thread类。
 * -- 2.重写run()方法
 * -- 3.创建一个新的线程对象。
 * -- 4.调用线程对象的start()方法启动线程。
 */
// 1.定义一个线程类继承Thread类。
class MyThread extends Thread{
    /**
     * 构造器为线程设置名称
     * @param name　线程名称
     */
    public MyThread(String name){
        super(name);
    }


    // 2.重写run()方法
    @Override
    public void run(){
        // 线程的执行方法
        for (int i=0;i<5;i++){
            System.out.println("子线程"+this.getName()+"输出:"+i);
            try {
                Thread.sleep(500);  // 线程休眠0.5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * b.实现Runnable接口的方式。
 * -- 1.创建一个线程任务类实现Runnable接口。
 * -- 2.重写run()方法
 * -- 3.创建一个线程任务对象。
 * -- 4.把线程任务对象包装成线程对象
 * -- 5.调用线程对象的start()方法启动线程。
 */
// 1.创建一个线程任务类实现Runnable接口
class MyRunnable implements Runnable{

    // 2.重写run()方法
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println("子线程"+Thread.currentThread().getName()+"输出:"+i);
            try {
                Thread.sleep(600);  // 线程休眠0.6秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * c.实现callable接口。
 * -- 1,定义一个线程任务类实现callable接口，申明线程执行的结果类型。
 * -- 2,重写线程任务类的call方法，这个方法可以直接返回执行的结果。
 * -- 3,创建一个callable的线程任务对象。
 * -- 4，把callable的线程任务对象包装成一个未来任务对象。
 * -- 5.把未来任务对象包装成线程对象。
 * -- 6.调用线程的start()方法启动线程
 */
// 1.定义一个线程任务类实现callable接口，申明线程执行的结果类型。
class MyCallable implements Callable<String>{
    // 2.重写线程任务类的call方法，这个方法可以直接返回执行的结果。
    @Override
    public String call() throws Exception {
        // 需求：计算１－１００的和
        int sum=0;
        for (int i=1;i<=100;i++){
            sum+=i;
        }
        return Thread.currentThread().getName()+"执行的结果是："+sum;
    }
}



/**
 * 账户
 */
class Account{
    //创建一把锁对象:因为账户对象对于小明小红是唯一的﹐所以这里的锁对象对于小明小红也是唯一的
    private final Lock lock = new ReentrantLock();


    private String id;      // 帐号
    private double money;   // 余额

    public Account() {
    }

    public Account(String id, double money) {
        this.id = id;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * 取钱
     * @param money　取钱额度
     */
    public void drawMoney(double money){
        // 1.先知道是谁取钱
        String name = Thread.currentThread().getName();
        // 2.判断余额是否足够
        synchronized (this) {   // 方法1.同步代码块
            // 方法3.lock显示锁
            lock.lock();    // 上锁
            try{
                if (this.money >= money) {
                    // 3.更新余额
                    this.money -= money;
                    System.out.println(name + "进行取钱操作,取出" + money + "元,余额" + this.money + "元");

                } else {
                    System.out.println(name + "进行取钱操作,余额不足！");
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();  // 解锁
            }
        }
    }

    /**
     * 取钱2
     * @param money　取钱额度
     */
    public synchronized void drawMoney2(double money){  // 方法2.同步方法
        // 1.先知道是谁取钱
        String name = Thread.currentThread().getName();
        // 2.判断余额是否足够
        synchronized (this) {
            if (this.money >= money) {
                // 3.更新余额
                this.money -= money;
                System.out.println(name + "进行取钱操作,取出" + money + "元,余额" + this.money + "元");

            } else {
                System.out.println(name + "进行取钱操作,余额不足！");
            }
        }
    }
}


/**
 * 取钱
 */
class DrawThread extends Thread{
    // 定义成员变量接受账户对象
    private final Account acc;
    public DrawThread(Account acc,String name){
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        // 取钱
        this.acc.drawMoney(100000);
        super.run();
    }
}