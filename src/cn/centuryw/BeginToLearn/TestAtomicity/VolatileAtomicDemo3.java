package cn.centuryw.BeginToLearn.TestAtomicity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 保证原子性操作的方案二:原子类(性能高效,线程安全)
 *     概述: java从JDK1.5开始提供了java.util.concurrent.atomic包(简称Atomic包)，这个包中的原子操作类提供了一
 * 种用法简单，性能高效，线程安全地更新一个变量的方式。
 *
 * AtomicInteger        原子型Integer，可以实现原子更新操作
 *
 *      CAS与synchronized:乐观锁，悲观锁。
 * CAS和Synchronized都可以保证多线程环境下共享数据的安全性。那么他们两者有什么区别?
 * Synchronized是从悲观的角度出发（悲观锁)
 * 总是假设最坏的情况，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁，这样别人想拿这个数据就会阻塞直到它拿到锁
 * (共享资源每次只给一个线程使用，其它线程阻塞，用完后再把资源转让给其它线程)。因此Synchronized我们
 * 也将其称之为悲观锁。jdk中的ReentrantLock也是—种悲观锁。性能较差!!
 *
 * CAS是从乐观的角度出发:
 * 总是假设最好的情况，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在更新的时候会判断—下在此期间别人有没有去更新这个数据。
 * CAS这种机制我们也可以将其称之为乐观锁。综合性能较好!
 *
 *
 *
 */


public class VolatileAtomicDemo3 {
    public static void main(String[] args) {
        Runnable task = new MyRunnable();
        // 启动100个线程，执行100次count+100操作
        for (int i=0;i<100;i++){
            new Thread(task).start();
        }
        // 运行结果:10000
    }

    static class MyRunnable implements Runnable{
        // 创建一个Integer更新的原子类AtomicInteger,初始值是0
        private AtomicInteger atomicInteger = new AtomicInteger();

        /**
         * 每次任务＋１００
         */
        @Override
        public void run() {
            // 加锁
            for (int i = 0; i < 100; i++) {
                System.out.println(atomicInteger.incrementAndGet());    // atomicInteger增加并且取值
            }
        }
    }
}

