package cn.centuryw.BeginToLearn;

import java.util.ArrayList;
import java.util.Date;

public class TestDate {
    /**
     * 日期类的使用
     * 构造器:
     *      -- public Date():创建当前系统的此刻日期时间对象。
     *      -- public Date(long time) :
     * 方法:
     *      -- public long getTime():返回自1970年1月1日 00:00:00 GMT以来走过的总的毫秒数。
     * 时间记录的两种方式:
     *      a . Date目期对象。
     *      b.时间毫秒值:从1970-01-01 00:00:00开始走到此刻的总的毫秒值。1s = 1000ms
     */
    public static void main(String[] args) {
        // 创建日期对象(此刻日期时间对象)
        Date date = new Date();
        System.out.println(date);   // Mon Aug 17 22:50:24 CST 2020
        System.out.println(date.getTime());     // 返回自1970年1月1日 00:00:00 GMT以来走过的总的毫秒数

        /*
            实例：程序计时
         */
        long startTime = new Date().getTime();   // 程序开始时间
        StringBuilder str = new StringBuilder();
        for (int i=0;i<5000000;i++){
            str.append(i);
        }
        System.out.println("集合大小："+str.length());
        long endTime = new Date().getTime();
        long useTime = endTime - startTime; // 程序所用时间=结束时间-开始时间
        System.out.println("程序用时(ms)："+useTime);

        // 获取600秒以后的时间
        System.out.println(new Date(date.getTime()+(600*1000)));
    }

}
