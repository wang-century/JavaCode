package cn.centuryw.BeginToLearn.ThreadCommunication;

/**
 * 银行账户
 */
public class BankAccount {
    private String id;
    private double money;

    public BankAccount() {
    }

    public BankAccount(String id, double money) {
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
     * 取钱操作
     * @param money　要取的金额
     */
    public synchronized void drawMoney(double money){
        // 如果钱足够则取出，不够则提示
        if (this.money>=money){
            this.money -= money;
            System.out.println(Thread.currentThread().getName()+"取出"+money+"元，剩余金额"+this.money+"元");

        }else {
            System.out.println("余额不足，操作失败");
        }
        // 唤醒其他线程，自己休眠
        this.notifyAll();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 存钱操作
     * @param money　要存的金额
     */
    public synchronized void saveMoney(double money) {
        String name = Thread.currentThread().getName();
        if (this.money!=0){
            System.out.println("余额充足"+name+"不存钱");
        }else {
            this.money += money;
            System.out.println(name+"存钱金额"+100000+"，余额"+this.money);
        }
        // 取完之后唤醒其他线程，自己休眠
        this.notifyAll();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
