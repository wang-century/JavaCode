package cn.centuryw.BeginToLearn.ThreadCommunication;

/**
 * 并发编程下，多线程访问变量的不可见性问题
 */
public class VolatileDemo extends Thread {
    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.flag = true;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }



}
