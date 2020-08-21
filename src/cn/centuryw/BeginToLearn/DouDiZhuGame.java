package cn.centuryw.BeginToLearn;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *      斗地主游戏的案例开发。
 *
 *      业务需求分析:
 * 斗地主的做牌，洗牌，发牌,看牌（排序）
 * 业务:总共有54张牌。
 * 点数:"3"，"4","5","6","7"，"8","9","10","J", "Q"，"K"，"A"，"2"
 * 花色:""，""，"",""
 * 大小王:"" ，""
 * 点数分别要组合4种花色，大小王各一张。
 * 斗地主:发出51张牌，剩下3张作为底牌。
 *      功能:
 * 1.做牌。
 * 2.洗牌
 * 3.定义3个玩家。
 * 4.发牌。
 * 5.排序（拓展，了解）
 * 6.看牌。
 *
 *      用面向对象设计案例:
 * a.定义一个牌类，代表牌对象。
 * b.定义一个集合存储54张牌，集合只需要一个!
 */
public class DouDiZhuGame {
    /* a.定义一个静态集合，存储54张牌对象，集合只需要一个 */
    public static List<Card>ALL_CARDS = new ArrayList<>();
    public static void main(String[] args) {
        /* b.做牌 */
        // 1.定义数组存储牌的点数，类型确定，个数用数组存储
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        // 2.定义数组存储花色
        String[] colors = {"红桃","黑桃","梅花","方块"};
        // 3.先遍历点数与花色组成牌对象存入集合
        int index = 0;
        for (String number:numbers){
            // 遍历花色
            for (String color:colors){
                // 组装
                Card card = new Card(number,color,index++);
                ALL_CARDS.add(card);
            }
        }
        // 4.单独加入大小王
        Collections.addAll(ALL_CARDS,new Card("","大王",index++),new Card("","小王",index++));
        System.out.println("输出新牌："+ALL_CARDS);

        /* c.洗牌(打乱顺序) */
        Collections.shuffle(ALL_CARDS);
        System.out.println("洗牌后："+ALL_CARDS);

        /* d.定义三个玩家 */
        List<Card> player_1 = new ArrayList<>();
        List<Card> player_2 = new ArrayList<>();
        List<Card> player_3 = new ArrayList<>();

        /* e.发牌(轮询 %3) */
        // 留3张当底牌
        for (int i=0;i<ALL_CARDS.size()-3;i++){
            Card card = ALL_CARDS.get(i);
            if (i%3==0){
                player_1.add(card);
            }else if (i%3==1){
                player_2.add(card);
            }else if (i%3==2){
                player_3.add(card);
            }
        }
        List<Card>lastThreeCards = ALL_CARDS.subList(ALL_CARDS.size()-3,ALL_CARDS.size());

        /* f.对牌进行排序 */
        Collections.sort(player_1);
        Collections.sort(player_2);
        Collections.sort(player_3);



        /* g.看牌 */
        System.out.println("玩家1："+player_1);
        System.out.println("玩家2："+player_2);
        System.out.println("玩家3："+player_3);
        System.out.println("底牌："+lastThreeCards);

    }
}

class Card implements Comparable{
    private String number;
    private String color;
    private int index;  // 牌在新牌的索引

    public Card(){
    }

    public Card(String number,String color,int index){
        this.number = number;
        this.color = color;
        this.index = index;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color+this.number;
    }

    @Override
    public int compareTo(Object o) {
        if (this.index < ((Card) o).index){
            return 1;
        }else if (this.index > ((Card) o).index){
            return -1;
        }
        return 0;
    }
}