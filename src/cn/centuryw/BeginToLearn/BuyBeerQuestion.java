package cn.centuryw.BeginToLearn;

/**
 * 目标:非规律化递归问题，编程思维的拓展。
 * 啤酒问题:啤酒2元一瓶，4个盖子可以换一瓶，2个空瓶可以换一瓶。
 */
public class BuyBeerQuestion {
    // 存放喝酒数
    static int totalNum;
    static int lastPingZiNum;
    static int lastGaiZiNum;

    public static void main(String[] args) {
        // 拿10元买酒
        buyBeer(10);
        System.out.println("总数:"+totalNum);
        System.out.println("剩余盖子:"+lastGaiZiNum);
        System.out.println("剩余瓶子:"+lastPingZiNum);

    }

    /**
     * 买酒
     * @param money 买酒的钱
     */
    static void buyBeer(int money){
        // 拿钱买酒
        int number = money / 2;
        // 累加
        totalNum += number;
        // 算出当前剩余的全部盖子和瓶子数,换算成金额继续购买
        int currentPingZi = lastPingZiNum + number;
        double currentGaiZi = lastGaiZiNum + number;
        // 换算成金额
        int totalMoney = 0;
        totalMoney += (currentPingZi/2.0);
        // 算出剩余的瓶子
        lastPingZiNum = currentPingZi % 2;
        // 算出盖子
        totalMoney += (currentGaiZi/4.0);
        lastGaiZiNum = (int) (currentGaiZi % 4);
        // 继续拿钱买酒
        if (totalMoney>=2){
            buyBeer(totalMoney);
        }
    }

}
