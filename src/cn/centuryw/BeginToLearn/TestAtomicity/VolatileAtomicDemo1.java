package cn.centuryw.BeginToLearn.TestAtomicity;

/**
 *      volatile修饰变量的原子性研究
 * 什么是原子性?
 *      原子性，是指一批操作是一个整体，要么同时成功，要么同时失败，不能被干扰。
 *
 * volatile只能保证线程间变量的可见性，但是不能保证变量操作的原子性。
 *
 */


public class VolatileAtomicDemo1 {
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
            for (int i=0;i<100;i++){
                count++;
                System.out.println(count);
            }
        }
    }
}

