package cn.centuryw.BeginToLearn;

import java.util.Calendar;
import java.util.Date;

public class TestCalendar {
    /**
     * 目标:日历类calendar的使用。
     * calendar代表了系统此刻日期对应的日历对象。
     * calendar是一个抽象类，不能直接创建对象。
     * calendar日历类创建日历对象的语法:|
     * calendar rightNow = calendar.getinstance ();
     * calendar的方法:
     * l.public static calendar getInstance ():返回一个日历类的对象。
     * 2.public int get (int field):取日期中的某个字段信息。
     * 3.public void set(int field,int value):修改日历的某个字段信息。
     * 4.public void add(int field,int amount):为某个字段增加/减少指定的值
     * 5.public final Date getTime():拿到此刻日期对象。
     * 6.public long getTimeInMillis():拿到此刻时间毫秒值
     */
    public static void main(String[] args) {
        // 创建日历对象
        Calendar now = Calendar.getInstance();
        System.out.println(now);
        // 获取年份
        System.out.println(now.get(Calendar.YEAR));
        // 一年中的第几天
        System.out.println(now.get(Calendar.DAY_OF_YEAR));
        // 修改日历信息
        now.set(Calendar.YEAR,2000);
        System.out.println(Calendar.YEAR);
        // 获取此刻日期对象
        Date date = now.getTime();
        System.out.println(date);
        // 此刻时间毫秒值
        long time = now.getTimeInMillis();
        System.out.println(time);
        // 题：请问701天后的日期
        now.add(Calendar.DAY_OF_YEAR,701);
        date = now.getTime();
        System.out.println(date);

    }

}
