package cn.centuryw.BeginToLearn.ThreadCommunication;

/**
 * 存钱线程类
 */
public class ThreadSave extends Thread{
    private BankAccount account;

    public ThreadSave(String name,BankAccount account){
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
            this.account.saveMoney(100000);

        }

    }
}
