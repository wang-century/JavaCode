package cn.centuryw.BeginToLearn.TestAtomicity;

import cn.centuryw.BeginToLearn.ThreadCommunication.VolatileDemo;

/**
 *      保证原子性操作的方案一:加锁(性能较差)
 */


public class VolatileAtomicDemo2 {
    public static void main(String[] args) {
        Runnable task = new MyRunnable();
        // 启动100个线程，执行100次count+100操作
        for (int i=0;i<100;i++){
            new Thread(task).start();
        }
        // 运行结果:9998
    }

    static class MyRunnable implements Runnable{
        private volatile int count;

        /**
         * 每次任务＋１００
         */
        @Override
        public void run() {
            // 加锁
            synchronized ("lock") {
                for (int i = 0; i < 100; i++) {
                    count++;
                    System.out.println(count);
                }
            }
        }
    }
}

