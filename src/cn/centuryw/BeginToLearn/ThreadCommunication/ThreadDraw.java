package cn.centuryw.BeginToLearn.ThreadCommunication;

/**
 * 取钱线程类
 */
public class ThreadDraw extends Thread{
    // 保存共享账户
    private BankAccount account;

    public ThreadDraw(String name,BankAccount account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
            this.account.drawMoney(100000);
        }

    }

}
